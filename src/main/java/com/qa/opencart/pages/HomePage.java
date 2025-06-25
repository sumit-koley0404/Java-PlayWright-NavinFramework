package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    private String search = "//input[@name='search']";
    private String searchIcon = "//button[@class='btn btn-default btn-lg']";
    private String searchpageHeader = "//div[@id='content'] //h1";

    public HomePage(Page page){
        this.page=page;
    }
    public String getHomePageTitle() {
        return page.title();
    }
    public String getHomeUrl(){
        return page.url();
    }
    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchIcon);
       return page.textContent(searchpageHeader);
    }

}
