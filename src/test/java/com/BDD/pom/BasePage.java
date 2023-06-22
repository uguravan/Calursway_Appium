package com.BDD.pom;

import com.github.javafaker.Faker;
import com.utilities.MDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static com.utilities.MDriver.getMDriver;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(MDriver.getMDriver()), this);
    }

    public WebDriverWait wait = new WebDriverWait(getMDriver(), 10);

    public static TouchAction touchAction = new TouchAction(getMDriver());

    public Faker faker = new Faker();

    public static Random random = new Random();

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Cart tab')]")
    public WebElement basketItemNumber;



}
