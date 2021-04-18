package tests;

import configuration.MyDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.travelocity.HomePage;
import pages.wikipedia.WikiHomePage;

public class BaseTest {

    MyDriver myDriver;

    private WikiHomePage wikiHomePage;
    private HomePage homePage;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver=new MyDriver(browser);
        //wikiHomePage=new WikiHomePage(myDriver.getWebDriver());
        homePage=new HomePage(myDriver.getWebDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        //wikiHomePage.dispose();
        homePage.dispose();
    }

    public WikiHomePage getWikiHomePage() {
        return wikiHomePage;
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
