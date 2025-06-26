package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    private String search = "//input[@name='search']";
    private String searchIcon = "//button[@class='btn btn-default btn-lg']";
    private String searchpageHeader = "//div[@id='content'] //h1";

    public HomePage(Page page){
        this.page=page;
    }
    public String getHomePageTitle() {
        String title= page.title();
        System.out.println("Home Page Title:"+title);
        return title;
    }
    public String getHomeUrl(){
        String url = page.url();
        System.out.println(url);
        return url;
    }
    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchIcon);
       String header = page.textContent(searchpageHeader);
       System.out.println("Product Header:"+header);
       return header;
    }

}
