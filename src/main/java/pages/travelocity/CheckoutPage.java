package pages.travelocity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(tagName = "h1")
    private WebElement titleCheckouPage;

    @FindBy(id = "totalPriceForTrip")
    private WebElement totalTrip;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[13]/section[2]/article[1]/form/fieldset/h2")
    private WebElement whoIsTravelingTitle;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[12]/div[2]/section/article/section/article/div[1]/div[2]/div[1]")
    private WebElement departureInfoTitle;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[12]/div[2]/section/article/section/article/div[1]/div[3]/div[1]")
    private WebElement returningInfoTitle;

    public String getH1Text(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(titleCheckouPage));
        return titleCheckouPage.getText();
    }
    public String getTotalTripText(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(totalTrip));
        return totalTrip.getText();
    }
    public String getTravelingTitle(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(whoIsTravelingTitle));
        return whoIsTravelingTitle.getText();
    }
    public String getDepartureTitle(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(departureInfoTitle));
        return departureInfoTitle.getText();
    }
    public String getReturningTitle(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(returningInfoTitle));
        return returningInfoTitle.getText();
    }

}
