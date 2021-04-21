package pages.travelocity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class HotelResultPage extends BasePage {

    public HotelResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    private String nameHotel;
    private String priceHotel;

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getPriceHotel() {
        return priceHotel;
    }

    public void setPriceHotel(String priceHotel) {
        this.priceHotel = priceHotel;
    }

    @FindBy(id = "sort")
    private WebElement sortResult;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[3]/div/div[2]/section[2]/ol")
    private WebElement hotelList;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[3]/div/div[2]/section[1]/header/div/div[1]/div/div")
    private WebElement textTripPrice;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[3]/div/div[1]/section/form/fieldset[1]/div/div/div/div/div[1]/button")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[3]/div/div[1]/section/form/fieldset[2]")
    private WebElement filterBySection;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[3]/div/div[2]/section[1]/header/div/div[2]/form/fieldset/div/select/option[2]")
    private WebElement priceSelectOption;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[3]/div/div[2]/section[3]/button")
    private WebElement buttonShowMore;

    public boolean sortByIsPresent(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(sortResult));
        return sortResult.isDisplayed();
    }

    public List<WebElement> hotelPricesDisplayed(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(hotelList));
        List<WebElement> resultListElements=hotelList.findElements(By.cssSelector(".uitk-cell.loyalty-display-price.all-cell-shrink"));
        return resultListElements;
    }

    public String getTextTrip(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(textTripPrice));
        return textTripPrice.getText();
    }

    public boolean buttonSearchHotel(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(searchButton));
        return searchButton.isDisplayed();
    }

    public boolean filterBySection(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(filterBySection));
        return filterBySection.isDisplayed();
    }

    public void sortByPrice(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(sortResult));
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(buttonShowMore));
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.elementToBeClickable(buttonShowMore));
        sortResult.click();
        priceSelectOption.click();
        buttonShowMore.click();
    }

    public RoomSelectHotel selectFirstHotelWith3Stars(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(hotelList));
        List<WebElement> resultListElements=hotelList.findElements(By.cssSelector(".uitk-type-300.uitk-type-bold.all-r-padding-one"));
        List<WebElement> resultListHotels=hotelList.findElements(By.cssSelector(".uitk-card.uitk-grid.imagelayout-left-fullbleed"));
        int index=0;
        for (int i = 0; i < resultListElements.size(); i++) {
            if (resultListElements.get(i).getText().equals("3.0/5")){
                index=i;
                break;
            }
        }
        WebElement buttonHotel=resultListHotels.get(index);
        setNameHotel(hotelList.findElements(By.tagName("h3")).get(index+1).getText());
        setPriceHotel(hotelList.findElements(By.cssSelector(".uitk-cell.loyalty-display-price.all-cell-shrink")).get(index+1).getText());
        buttonHotel.click();
        ArrayList<String> tabs2 = new ArrayList<String> (getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs2.get(1));
        return new RoomSelectHotel(getWebDriver());
    }

}
