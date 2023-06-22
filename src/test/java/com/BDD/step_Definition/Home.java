package com.BDD.step_Definition;

import com.BDD.pom.Pages;
import com.utilities.MDriver;
import com.utilities.M_Util;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.utilities.MDriver.getAndroidDriver;
import static com.utilities.MDriver.getMDriver;

public class Home extends Pages {

    List<String> contentList1 = new ArrayList<>();
    List<String> contentList2 = new ArrayList<>();
    int firstSize;
    int contentFirstSize;


    @When("I click on continue as guest button")
    public void iClickOnContinueAsGuestButton() {
        registration().continueAsGuest.click();
    }

    @And("I click on maybe later button")
    public void i_click_on_maybe_later_button() {
        homePage().maybeLater.click();
        //       firstSize = homePage().homePageContents.size();
//        for (int i = 0; i < homePage().homePageContents.size(); i++) {
//            contentList1.add(homePage().homePageContents.get(i).getAttribute("content-desc"));
//            System.out.println("content 1 =" + homePage().homePageContents.get(i).getAttribute("content-desc"));
//        }


    }

    @When("I refresh page")
    public void iRefreshPage() {
        touchAction.press(PointOption.point(500, 500))
                .waitAction()
                .moveTo(PointOption.point(500, 900))
                .release()
                .perform();
    }

    @Then("I verify page content has been updated")
    public void i_verify_page_content_has_been_updated() throws InterruptedException {
        Thread.sleep(2500);
        for (int i = 0; i < homePage().homePageContents.size(); i++) {
            System.out.println("content 2 =" + homePage().homePageContents.get(i).getAttribute("content-desc"));
            contentList2.add(homePage().homePageContents.get(i).getAttribute("content-desc"));
        }
        System.out.println(contentList1.size());

        contentList1.removeAll(contentList2);

        System.out.println(contentList1.size());

        Assert.assertTrue(contentList1.size() >= (firstSize / 2));

    }

    @Test
    public void testName() {
        List<String> a1 = new ArrayList<>();
        a1.add("cuneyt");
        a1.add("muharrem");
        a1.add("ensar");

        List<String> a2 = new ArrayList<>();
        a2.add("cuneyt");
        a2.add("muharrem");
        a2.add("memet");

        a1.removeAll(a2);
        System.out.println(a1);

    }

    @And("I handle the presence of the search bar")
    public void iHandleThePresenceOfTheSearchBar() {

        if (homePage().searchBoxList.size() == 0) {
            homePage().homePageContents.get(0).click();
            itemPage().backButton.click();
        }

    }

    @When("I click on search with image button")
    public void iClickOnSearchWithImageButton() {
        homePage().camIcon.click();
    }


    @And("I click on select an existing photo")
    public void iClickOnSelectAnExistingPhoto() {
        homePage().selectExistPhoto.click();
        Alert alert = getMDriver().switchTo().alert();
        alert.accept();
    }


    @And("I select photo from library")
    public void iSelectPhotoFromLibrary() throws IOException {
        String sourceFilePath = "C:\\Users\\diez_\\Desktop\\clarusway\\AppiumTest\\Photo\\belt.jpg";
        File sourceFile = new File(sourceFilePath);
        getAndroidDriver().pushFile("/sdcard/download/belt.jpg", sourceFile);
        itemPage().photoOfItem.click();


    }

    @Then("I verify the results related to my photo")
    public void iVerifyTheResultsRelatedToMyPhoto() {

        List<WebElement> contentOfSearchListTitle = searchPage().contentOfSearchListTitle;
        List<String> tileText = new ArrayList<>();

        for (int i = 0; i < contentOfSearchListTitle.size(); i++) {
            tileText.add(contentOfSearchListTitle.get(i).getText());
            System.out.println(contentOfSearchListTitle.get(i).getText());
        }

        int countOfItem = 0;

        for (int i = 0; i < tileText.size(); i++) {
            if (tileText.get(i).toLowerCase().contains("belt")) {
                countOfItem = countOfItem + 1;
            }
        }
        System.out.println("countOfItem = " + countOfItem);

        Assert.assertTrue(countOfItem > 2);

    }


    @Given("I collect current total content number")
    public void iCollectCurrentTotalContentNumber() throws InterruptedException {
        contentFirstSize = homePage().contentList.size();
        System.out.println("content1 size = " + contentFirstSize);
    }


    @When("I scroll down")
    public void iScrollDown() {
        M_Util.scrollDown();
        //  M_Util.scrollDownToElement(By.xpath("//*[@content-desc='Comfortwear ']"));
    }

    @Then("I verify total content number increased")
    public void iVerifyTotalContentNumberIncreased() {
        int contentSecondSize = homePage().contentList.size();
        System.out.println("contentSecondSize = " + contentSecondSize);
        Assert.assertTrue(contentSecondSize > contentFirstSize);
    }

    @When("Add item in Set list")
    public void do_it_previous_methods() throws InterruptedException {

        Set<String> totalContent = new HashSet<>();

        for (int j = 0; j < 3; j++) {

            List<WebElement> contents = homePage().contentList;
            List<String> myTextContents = new ArrayList<>(); // dummy

            for (int i = 0; i < contents.size(); i++) {
                myTextContents.add(contents.get(i).getAttribute("content-desc"));
            }
            totalContent.addAll(myTextContents);
            System.out.println("totalContent = " + totalContent);
            M_Util.scrollDown();
        }
    }


    @When("I search {string} item")
    public void iSearchItem(String itemTime) {
        homePage().searchBox.click();
        homePage().searchBox.sendKeys(itemTime);
        getAndroidDriver().pressKey(new KeyEvent(AndroidKey.ENTER));

    }

    @And("I click on first item")
    public void iClickOnFirstItem() throws InterruptedException {
        Thread.sleep(1000);
        searchPage().contentOfSearchListTitle.get(0).click();
    }

    @And("I scroll down to the Add to cart button")
    public void iScrollDownToTheAddToCartButton() {
        M_Util.scrollDownToElement(By.xpath("//*[@text='Add to cart']"));
    }

    @And("I select random options, if available, for the item")
    public void iSelectRandomOptionsIfAvailableForTheItem() {
        int sizeOFOpt = itemPage().optionsList.size();
        for (int i = 0; i < sizeOFOpt; i++) {
            itemPage().optionsList.get(i).click();
            itemPage().optionsItemList.get(0).click();
        }
    }

    @When("I click on the Add to cart button")
    public void iClickOnTheAddToCartButton() {
        itemPage().addToCart.click();
    }


    @Then("I verify that the item has been added to my basket")
    public void iVerifyThatTheItemHasBeenAddedToMyBasket() {


        String text = basketItemNumber.getAttribute("content-desc");
        System.out.println("text = " + text);

    }


}
