package tests.travelocity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.travelocity.HomePage;
import pages.travelocity.HotelResultPage;
import tests.BaseTest;

public class Exercise2 extends BaseTest {

    private HotelResultPage hotelResultPage;

    public HotelResultPage getHotelResultPage() {
        return hotelResultPage;
    }

    public void setHotelResultPage(HotelResultPage hotelResultPage) {
        this.hotelResultPage = hotelResultPage;
    }

    @Test(description = "Step 1-2-3 for Exam two item ")
    @Parameters({"flyingFrom", "flyingTo"})
    public void step123(String flyingFrom, String flyingTo) {
        HomePage homePage=getHomePage();
        SoftAssert softAssert=new SoftAssert();
        HotelResultPage hotelResultPage=homePage.searchFlighPlusHotel(flyingFrom, flyingTo);
        setHotelResultPage(hotelResultPage);
        softAssert.assertEquals(hotelResultPage.sortByIsPresent(), true);
        for (int i = 0; i < hotelResultPage.hotelPricesDisplayed().size(); i++) {
            softAssert.assertEquals(hotelResultPage.hotelPricesDisplayed().get(i).isDisplayed(), true);
        }
        softAssert.assertEquals(hotelResultPage.getTextTrip(), "Trip prices include roundtrip flight + hotel, taxes, and fees.");
        softAssert.assertEquals(hotelResultPage.buttonSearchHotel(), true);
        softAssert.assertEquals(hotelResultPage.filterBySection(), true);
        softAssert.assertAll();
    }

    @Test(description = "Step 4 for Exam two item ")
    public void step4() throws InterruptedException {
        HotelResultPage hotelResultPage=getHotelResultPage();
        hotelResultPage.sortByPrice();
        setHotelResultPage(hotelResultPage);
        Thread.sleep(10000);

    }

    @Test(description = "Step 5 for Exam two item ")
    public void step5() throws InterruptedException {
        HotelResultPage hotelResultPage=getHotelResultPage();
        hotelResultPage.selectFirstHotelWith3Stars();
        Thread.sleep(10000);
    }

}
