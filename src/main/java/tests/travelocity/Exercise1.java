package tests.travelocity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.travelocity.FlightDetailsPage;
import pages.travelocity.FlightsResultPage;
import pages.travelocity.HomePage;
import tests.BaseTest;

public class Exercise1 extends BaseTest {

    //HomePage homePage=getHomePage();
    private FlightsResultPage flightsResultPage;

    public FlightsResultPage getFlightsResultPage() {
        return flightsResultPage;
    }

    public void setFlightsResultPage(FlightsResultPage flightsResultPage) {
        this.flightsResultPage = flightsResultPage;
    }

    @Test(description = "Step 1 for Exam first item ")
    @Parameters({"flyingFrom", "flyingTo"})
    public void step1(String flyingFrom, String flyingTo) {
        HomePage homePage=getHomePage();
        FlightsResultPage flightsResultPage=homePage.searchFlight(flyingFrom, flyingTo);
        setFlightsResultPage(flightsResultPage);
        Assert.assertEquals(flightsResultPage.getH1Title(), "Select your departure to Los Angeles");
    }

    @Test(description = "Step 2 for Exam first item ")
    public void step2() {
        FlightsResultPage flightsResultPage=getFlightsResultPage();
        SoftAssert softAssert=new SoftAssert();

        /*
        *Verifica si la caja de Sort by se despliega
         */
        softAssert.assertEquals(flightsResultPage.getsortByBoxText(), true);

        /*
         *Verifica si la duracion de los vuelos está presente
         */
        for (int i = 0; i < flightsResultPage.getDurationFlightsList().size(); i++) {
            softAssert.assertEquals(flightsResultPage.getDurationFlightsList().get(i).isDisplayed(), true);
        }

        /*
         *Verifica si el precio de los vuelos está presente
         */
        for (int i = 0; i < flightsResultPage.getBaggageFees().size(); i++) {
            softAssert.assertEquals(flightsResultPage.getBaggageFees().get(i).isDisplayed(), true);
        }

        softAssert.assertAll();

    }

    @Test(description = "Step 3 for Exam first item ")
    public void step3() {
        FlightsResultPage flightsResultPage=getFlightsResultPage();
        flightsResultPage.sortBy();
    }

    @Test(description = "Step 4 for Exam first item ")
    public void step4() throws InterruptedException {
        FlightsResultPage flightsResultPage=getFlightsResultPage();
        Assert.assertEquals(flightsResultPage.selectFirstResult(),"Las Vegas to Los Angeles");
        flightsResultPage.actionButtonContinue();
        Thread.sleep(10000);
    }

    @Test(description = "Step 5 for Exam first item ")
    public void step5() {
        FlightsResultPage flightsResultPage=getFlightsResultPage();
        Assert.assertEquals(flightsResultPage.getH1Title(), "Select your departure to Las Vegas");
        Assert.assertEquals(flightsResultPage.selectThirdResult(), "Ontario to Las Vegas");
    }

    @Test(description = "Step 6 for Exam first item ")
    public void step6() {
        FlightsResultPage flightsResultPage=getFlightsResultPage();
        FlightDetailsPage flightDetailsPage=flightsResultPage.actionButtonContinue2();
        Assert.assertEquals(flightDetailsPage.getTitle(), "Las Vegas to Los Angeles");
    }

}
