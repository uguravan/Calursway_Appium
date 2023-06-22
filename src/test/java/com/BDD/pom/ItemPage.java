package com.BDD.pom;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemPage extends Pages {

    @AndroidFindBy(id = "com.etsy.android:id/navigation_button")
    public WebElement backButton;

    @AndroidFindBy(id = "com.android.documentsui:id/icon_thumb")
    public WebElement photoOfItem;

    @AndroidFindBy(xpath = "//*[@text='Add to cart']")
    public WebElement addToCart;

    @AndroidFindBy(id = "com.etsy.android:id/clg_text_input")
    public List<WebElement> optionsList;

    @AndroidFindBy(id = "com.etsy.android:id/clg_line_item_text")
    public List<WebElement> optionsItemList;





}
