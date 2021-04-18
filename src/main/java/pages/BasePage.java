package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        webDriverWait=new WebDriverWait(webDriver, 10);
        this.webDriver = webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
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
