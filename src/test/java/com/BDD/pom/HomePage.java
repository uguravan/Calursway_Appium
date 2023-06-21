package com.BDD.pom;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Pages {

    @AndroidFindBy(xpath = "//*[@text='Maybe later']")
    public WebElement maybeLater;

    @AndroidFindBy(id = "com.etsy.android:id/menu_bottom_nav_homee")
    public List<WebElement> homeIconList;

    @AndroidFindBy(id = "com.etsy.android:id/listing_image")
    public List<WebElement> homePageContents;




}
