package com.BDD.pom;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Pages {

    @AndroidFindBy(id = "com.etsy.android:id/empty_view_tertiary_button")
    public WebElement maybeLater;

    @AndroidFindBy(id = "com.etsy.android:id/menu_bottom_nav_homee")
    public List<WebElement> homeIconList;





}
