package pages.travelocity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class FlightDetailsPage extends BasePage {

    public FlightDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div[2]/div/main/div/section[2]/div/div/div[1]/div/div/div[1]/h2")
    private WebElement h2Title;

    public String getTitle(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(h2Title));
        return h2Title.getText();
    }

}
