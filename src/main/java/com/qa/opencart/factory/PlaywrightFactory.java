package com.qa.opencart.factory;
import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.qa.opencart.factory.PlaywrightFactory;

import java.util.Locale;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    public Page initBrowser(String browserName){
        System.out.println("browser name is :"+ browserName);
        playwright= Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium":
                browser=playwright.chromium().launch
                        (new BrowserType.LaunchOptions().
                                setHeadless(false));
                break;
            case "safari":
               browser= playwright.webkit().launch
                        (new BrowserType.LaunchOptions()
                                .setHeadless(false));
                break;
            case "firefox":
                browser=playwright.firefox().launch
                        (new BrowserType.LaunchOptions().
                                setHeadless(false));
                break;
            case "chrome":
                browser=playwright.chromium().
                        launch(new LaunchOptions().setChannel("chrome").setHeadless(false));

            default:
                System.out.println("please pass the right browser name...");
                break;
        }
        browserContext=browser.newContext();
        page= browserContext.newPage();
        page.navigate("https://naveenautomationlabs.com/opencart/");
        return page;
        




    }
}
