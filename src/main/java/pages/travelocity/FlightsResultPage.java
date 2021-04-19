package pages.travelocity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class FlightsResultPage extends BasePage {

    public FlightsResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(tagName = "h1")
    private WebElement hiddenTitle;

    @FindBy(id = "listings-sort")
    private WebElement sortByBox;

    @FindBy(className = "uitk-card-link")
    private WebElement buttonsList;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/section/main/div[6]/section/footer/div/button[1]")
    private WebElement buttonContinue;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/section/main/div[5]/section/footer/div/button[1]")
    private WebElement buttonContinue2;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/section/main/ul/li[1]/div/div/div/button")
    private WebElement firstResult;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/section/main/ul/li[3]/div/div/div/button")
    private WebElement thirdResult;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/section/main/ul")
    private WebElement resultList;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/section/main/div[3]/section/button")
    private WebElement buttonShowMore;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/section/main/div[2]/div[1]/section/fieldset/div/select/option[3]")
    private WebElement sortByDurationShorter;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/section/main/div[6]/section/div[2]/div/div[1]/h2")
    private WebElement sectionTitle1;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div[3]/div[1]/section/main/div[5]/section/div[2]/div/div[1]/h2")
    private WebElement sectionTitle2;

    public String getH1Title() {
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(hiddenTitle));
        return hiddenTitle.getText();
    }

    public boolean getsortByBoxText(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(sortByBox));
        return sortByBox.isDisplayed();
    }

    public List<WebElement> getDurationFlightsList(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(resultList));
        List<WebElement> resultListElements=resultList.findElements(By.cssSelector(".uitk-type-200.uitk-text-emphasis-theme"));
        List<WebElement> resultListDuration=new ArrayList<WebElement>();
        for (int i = 0; i < resultListElements.size(); i++) {
            if (i%2!=0){
                resultListDuration.add(resultListElements.get(i));
            }
        }

        return resultListDuration;
    }

    public List<WebElement> getBaggageFees(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(resultList));
        List<WebElement> resultListElements=resultList.findElements(By.className("uitk-lockup-price"));
        List<WebElement> resultListBaggageFees=new ArrayList<WebElement>();
        for (int i = 0; i < resultListElements.size(); i++) {
            resultListBaggageFees.add(resultListElements.get(i));
        }
        return resultListBaggageFees;
    }

    public List<WebElement> sortBy(){
        sortByBox.click();
        sortByDurationShorter.click();
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(resultList));
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.elementToBeClickable(buttonsList));
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.elementToBeClickable(buttonShowMore));
        return getDurationFlightsList();
    }

    public String selectFirstResult(){
        firstResult.click();
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(buttonContinue));
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.elementToBeClickable(buttonContinue));
        return sectionTitle1.getText();
    }

    public void actionButtonContinue(){
        buttonContinue.click();
    }

    public String selectThirdResult(){
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(resultList));
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.elementToBeClickable(thirdResult));
        thirdResult.click();
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.visibilityOf(buttonContinue2));
        getWebDriverWaitResultPageTravelocity().until(ExpectedConditions.elementToBeClickable(buttonContinue2));
        return sectionTitle2.getText();
    }

    public FlightDetailsPage actionButtonContinue2(){
        buttonContinue2.click();
        ArrayList<String> tabs2 = new ArrayList<String> (getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs2.get(1));
        return new FlightDetailsPage(getWebDriver());
    }

}
