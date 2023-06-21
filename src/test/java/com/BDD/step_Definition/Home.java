package com.BDD.step_Definition;

import com.BDD.pom.Pages;
import com.utilities.MDriver;
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
import java.util.List;

import static com.utilities.MDriver.getAndroidDriver;
import static com.utilities.MDriver.getMDriver;

public class Home extends Pages {

    List<String> contentList1 = new ArrayList<>();
    List<String> contentList2 = new ArrayList<>();
    int firstSize;


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

        Assert.assertTrue(countOfItem>2);

    }
}
