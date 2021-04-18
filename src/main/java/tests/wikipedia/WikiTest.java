package tests.wikipedia;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.wikipedia.ArticlePage;
import pages.wikipedia.WikiHomePage;
import tests.BaseTest;

public class WikiTest extends BaseTest {

    @Test
    @Parameters({"busqueda"})
    public void testWikiSearch(String busqueda){
        WikiHomePage wikiHomePage=getWikiHomePage();
        ArticlePage articlePage=wikiHomePage.search(busqueda);
        Assert.assertEquals(articlePage.getPageTittle(), "Colombia");
    }

}
