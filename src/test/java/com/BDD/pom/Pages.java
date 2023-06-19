package com.BDD.pom;

public class Pages extends BasePage {


    private Registration registration;
    private HomePage homePage;

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    public Registration registration() {
        if (registration == null) {
            registration = new Registration();
        }
        return registration;
    }


}
