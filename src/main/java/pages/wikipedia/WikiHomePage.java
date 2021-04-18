package pages.wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class WikiHomePage extends BasePage {

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(xpath = "/html/body/div[3]/form/fieldset/button")
    private WebElement searchButton;

    public WikiHomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://www.wikipedia.org/");
    }

    public ArticlePage search(String busqueda) {
        searchInput.sendKeys(busqueda);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new ArticlePage(getWebDriver());
    }
}
