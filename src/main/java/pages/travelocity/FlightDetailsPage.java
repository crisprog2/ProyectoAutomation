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

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div[2]/div/main/section[2]/div/div/div[1]/div[1]/table/tbody/tr/td[2]/span")
    private WebElement totalTrip;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div[2]/div/main/div/section[2]/div/div/div[1]/div/div/div[1]/h2")
    private WebElement departureFlightTitleInformation;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div[2]/div/main/div/section[2]/div/div/div[2]/div/div/div[1]/h2")
    private WebElement returningFlightTitleInformation;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div[2]/div/main/section[2]/div/div/div[2]/button")
    private WebElement checkoutButton;

    public String getTotalTrip(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(totalTrip));
        return totalTrip.getText();
    }

    public String getTitleDepartureFlight(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(departureFlightTitleInformation));
        return departureFlightTitleInformation.getText();
    }

    public String getTitleReturningFlight(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(returningFlightTitleInformation));
        return returningFlightTitleInformation.getText();
    }

    public CheckoutPage actionCheckOutButton(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
        return new CheckoutPage(getWebDriver());
    }

}
