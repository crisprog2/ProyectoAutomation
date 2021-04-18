package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.WikiHomePage;

public class WikiTest extends BaseTest{

    @Test
    @Parameters({"busqueda"})
    public void testWikiSearch(String busqueda){
        WikiHomePage wikiHomePage=getWikiHomePage();
        ArticlePage articlePage=wikiHomePage.search(busqueda);
        Assert.assertEquals(articlePage.getPageTittle(), "Colombia");
    }

}
