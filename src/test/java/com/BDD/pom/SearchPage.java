package com.BDD.pom;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends Pages {



    @AndroidFindBy(id = "com.etsy.android:id/listing_title")
    public List<WebElement> contentOfSearchListTitle;

}
