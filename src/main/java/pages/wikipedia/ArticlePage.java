package pages.wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ArticlePage extends BasePage {

    @FindBy(id = "firstHeading")
    private WebElement pageTitle;

    public ArticlePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTittle(){
        return pageTitle.getText();
    }

}
