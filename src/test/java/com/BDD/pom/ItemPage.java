package com.BDD.pom;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ItemPage extends Pages {

    @AndroidFindBy(id = "com.etsy.android:id/navigation_button")
    public WebElement backButton;

    @AndroidFindBy(id = "com.android.documentsui:id/icon_thumb")
    public WebElement photoOfItem;



}
