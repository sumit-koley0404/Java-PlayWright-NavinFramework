package com.qa.opencart.test;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest {
    PlaywrightFactory pf;
    Page page;
    HomePage homePage;
    @BeforeMethod
    public void setUp(){
       pf = new PlaywrightFactory();
       page =pf.initBrowser("chrome");
       homePage= new HomePage(page);
    }
    @Test
    public void homePageTitleTest(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle,"Your Store");
    }
    @DataProvider
    public Object[][] getProductData(){
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }
    @Test(dataProvider = "getProductData")
    public void searchTest(String productName){
        String actualSearchHeader = homePage.doSearch(productName);
        Assert.assertEquals(actualSearchHeader,"Search - "+productName);
    }
    @Test
    public void homePageUrl() {
        String actualUrl = homePage.getHomeUrl();
        Assert.assertEquals(actualUrl,"https://naveenautomationlabs.com/opencart/");
    }

    @AfterMethod
    public void tearDown(){
        page.context().browser().close();
    }
}
