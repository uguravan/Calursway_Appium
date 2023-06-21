package com.BDD.pom;

public class Pages extends BasePage {


    private Registration registration;
    private HomePage homePage;
    private ItemPage itemPage;
    private SearchPage searchPage;

    public SearchPage searchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }

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

    public ItemPage itemPage() {
        if (itemPage == null) {
            itemPage = new ItemPage();
        }
        return itemPage;
    }

}
