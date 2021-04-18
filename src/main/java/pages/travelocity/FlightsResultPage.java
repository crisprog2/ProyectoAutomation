package pages.travelocity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class FlightsResultPage extends BasePage {

    public FlightsResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/aside/fieldset/h2")
    private WebElement filterByTitle;

    public String getFilterByTitle() {
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(filterByTitle));
        return filterByTitle.getText();
    }
}
