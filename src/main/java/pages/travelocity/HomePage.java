package pages.travelocity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/ul/li[2]/a")
    private WebElement flightsButtonMenu;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/button")
    private WebElement buttonFieldOriginFlight;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div/div/div[1]/button")
    private WebElement buttonFieldDestinationFlight;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div/div[2]/ul/li[1]/button")
    private WebElement firstResultSearchOriginFlight;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div/div/div[2]/ul/li[1]/button")
    private WebElement firstResultSearchDestinationFlight;

    @FindBy(id = "location-field-leg1-origin")
    private WebElement fieldOriginFlight;

    @FindBy(id = "location-field-leg1-destination")
    private WebElement fieldDestinationFlight;

    @FindBy(id = "d1-btn")
    private WebElement buttonDepartingDate;

    @FindBy(id = "add-hotel-checkbox")
    private WebElement checkBoxHotel;

    @FindBy(id = "add-car-checkbox")
    private WebElement checkBoxCar;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/button")
    private WebElement searchButtonFlight;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/button[2]")
    private WebElement buttonNextElementDatePicker;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]")
    private WebElement monthDepartingDatePicker;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[3]/button")
    private WebElement buttonDatePicker;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/div/figure/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/button")
    private WebElement searchButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://www.travelocity.com/");
    }

    public FlightsResultPage searchFlight(String flyingFrom, String flyingTo) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(flightsButtonMenu));

        flightsButtonMenu.click();

        buttonFieldOriginFlight.click();
        fieldOriginFlight.sendKeys(flyingFrom);
        firstResultSearchOriginFlight.click();

        buttonFieldDestinationFlight.click();
        fieldDestinationFlight.sendKeys(flyingTo);
        firstResultSearchDestinationFlight.click();

        buttonDepartingDate.click();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonNextElementDatePicker));
        buttonNextElementDatePicker.click();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonNextElementDatePicker));
        buttonNextElementDatePicker.click();

        List<WebElement> calendarMonthDeparting=monthDepartingDatePicker.findElements(By.tagName("button"));
        WebElement dayMonthDeparting=calendarMonthDeparting.get(17);
        dayMonthDeparting.click();
        buttonDatePicker.click();

        searchButton.click();

        return new FlightsResultPage(getWebDriver());
    }

    public HotelResultPage searchFlighPlusHotel(String flyingFrom, String flyingTo) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(flightsButtonMenu));

        flightsButtonMenu.click();

        buttonFieldOriginFlight.click();
        fieldOriginFlight.sendKeys(flyingFrom);
        firstResultSearchOriginFlight.click();

        buttonFieldDestinationFlight.click();
        fieldDestinationFlight.sendKeys(flyingTo);
        firstResultSearchDestinationFlight.click();

        buttonDepartingDate.click();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonNextElementDatePicker));
        buttonNextElementDatePicker.click();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonNextElementDatePicker));
        buttonNextElementDatePicker.click();

        List<WebElement> calendarMonthDeparting=monthDepartingDatePicker.findElements(By.tagName("button"));
        WebElement dayMonthDeparting=calendarMonthDeparting.get(17);
        WebElement dayMonthReturning=calendarMonthDeparting.get(30);
        dayMonthDeparting.click();
        dayMonthReturning.click();
        buttonDatePicker.click();

        checkBoxHotel.click();
        checkBoxCar.click();

        searchButton.click();

        return new HotelResultPage(getWebDriver());

    }

}
