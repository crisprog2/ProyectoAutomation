package tests;

import configuration.MyDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.WikiHomePage;

public class BaseTest {

    MyDriver myDriver;

    private WikiHomePage wikiHomePage;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver=new MyDriver(browser);
        wikiHomePage=new WikiHomePage(myDriver.getWebDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        wikiHomePage.dispose();
    }

    public WikiHomePage getWikiHomePage() {
        return wikiHomePage;
    }
}
