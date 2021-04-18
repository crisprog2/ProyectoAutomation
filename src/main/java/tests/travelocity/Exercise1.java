package tests.travelocity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.travelocity.FlightsResultPage;
import pages.travelocity.HomePage;
import tests.BaseTest;

public class Exercise1 extends BaseTest {

    @Test
    @Parameters({"flyingFrom", "flyingTo"})
    public void step1(String flyingFrom, String flyingTo) {
        HomePage homePage=getHomePage();
        FlightsResultPage flightsResultPage=homePage.searchFlight(flyingFrom, flyingTo);
        Assert.assertEquals(flightsResultPage.getFilterByTitle(), "Filter by");
    }

}
