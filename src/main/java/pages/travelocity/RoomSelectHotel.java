package pages.travelocity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class RoomSelectHotel extends BasePage {
    public RoomSelectHotel(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[1]/div[3]/div/div[1]/div[1]/h1")
    private WebElement titleNameHotel;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[1]/div[4]/div/div[2]/div/section/span[2]")
    private WebElement priceHotel;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[1]/div[5]/div/div/section/div[3]/div/div[1]/div[2]/div/div/div[2]/button")
    private WebElement buttonReserveARoom;

    public String getTitleNameHotel(){
        return titleNameHotel.getText();
    }

    public String getPriceHotel(){
        return priceHotel.getText();
    }

    public boolean buttonReserveIsPresent(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.elementToBeClickable(buttonReserveARoom));
        return buttonReserveARoom.isDisplayed();
    }

}
