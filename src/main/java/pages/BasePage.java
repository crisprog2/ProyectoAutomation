package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private WebDriverWait webDriverWaitResultPageTravelocity;

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        webDriverWait=new WebDriverWait(webDriver, 10);
        webDriverWaitResultPageTravelocity=new WebDriverWait(webDriver, 90);
        this.webDriver = webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public WebDriverWait getWebDriverWaitResultPageTravelocity() {
        return webDriverWaitResultPageTravelocity;
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    public void dispose(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }

}
