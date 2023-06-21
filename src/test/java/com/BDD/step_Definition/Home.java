package com.BDD.step_Definition;

import com.BDD.pom.Pages;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
         firstSize = homePage().homePageContents.size();
        for (int i = 0; i < homePage().homePageContents.size(); i++) {
            contentList1.add(homePage().homePageContents.get(i).getAttribute("content-desc"));
            System.out.println("content 1 =" + homePage().homePageContents.get(i).getAttribute("content-desc"));
        }


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
}
