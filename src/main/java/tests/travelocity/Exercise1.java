package tests.travelocity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.travelocity.CheckoutPage;
import pages.travelocity.FlightDetailsPage;
import pages.travelocity.FlightsResultPage;
import pages.travelocity.HomePage;
import tests.BaseTest;

public class Exercise1 extends BaseTest {

    private FlightsResultPage flightsResultPage;
    private FlightDetailsPage flightDetailsPage;
    private CheckoutPage checkoutPage;

    public FlightsResultPage getFlightsResultPage() {
        return flightsResultPage;
    }

    public void setFlightsResultPage(FlightsResultPage flightsResultPage) {
        this.flightsResultPage = flightsResultPage;
    }

    public FlightDetailsPage getFlightDetailsPage() {
        return flightDetailsPage;
    }

    public void setFlightDetailsPage(FlightDetailsPage flightDetailsPage) {
        this.flightDetailsPage = flightDetailsPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }

    public void setCheckoutPage(CheckoutPage checkoutPage) {
        this.checkoutPage = checkoutPage;
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
        /*
        *Realiza todas las validaciones anteriores en una sola
         */

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
        setFlightDetailsPage(flightDetailsPage);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(flightDetailsPage.getTotalTrip(), "$183.93");
        softAssert.assertEquals(flightDetailsPage.getTitleDepartureFlight(), "Las Vegas to Los Angeles");
        softAssert.assertEquals(flightDetailsPage.getTitleReturningFlight(), "Ontario to Las Vegas");
        softAssert.assertAll();
    }

    @Test(description = "Step 7 for Exam first item ")
    public void step7() {
        FlightDetailsPage flightDetailsPage=getFlightDetailsPage();
        CheckoutPage checkoutPage=flightDetailsPage.actionCheckOutButton();
        setCheckoutPage(checkoutPage);
    }

    @Test(description = "Step 8 for Exam first item ")
    public void step8() {
        CheckoutPage checkoutPage=getCheckoutPage();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(checkoutPage.getH1Text(), "Secure booking - only takes a few minutes!");
        softAssert.assertEquals(checkoutPage.getTravelingTitle(), "Who's traveling?");
        softAssert.assertEquals(checkoutPage.getTotalTripText(), "$183.93");
        softAssert.assertEquals(checkoutPage.getDepartureTitle(), "Las Vegas (LAS) to Los Angeles (LAX)");
        softAssert.assertEquals(checkoutPage.getReturningTitle(), "Ontario (ONT) to Las Vegas (LAS)");
        softAssert.assertAll();
    }

}
