package com.BDD.pom;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Registration extends Pages {

    @AndroidFindBy(id = "com.etsy.android:id/clg_text_input")
    public WebElement email;

    @AndroidFindBy(id = "com.etsy.android:id/sign_in_button_email")
    public WebElement continueButton;

    @AndroidFindBy(xpath = "//*[@resource-id='join_neu_first_name_field']")
    public WebElement firstName;

    @AndroidFindBy(xpath = "//*[@resource-id='join_neu_password_field']")
    public WebElement password;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement registrationButton;




}
