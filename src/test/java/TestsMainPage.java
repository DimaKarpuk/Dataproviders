
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.MainPageCatalog;
import pages.SearchStringPage;

import static com.codeborne.selenide.Selenide.*;

public class TestsMainPage {
    MainPageCatalog mainPageCatalog = new MainPageCatalog();
    SearchStringPage searchStringPage = new SearchStringPage();
    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen= true;
    }
    @BeforeEach void beforeEach(){
        open("https://www.21vek.by/");
        mainPageCatalog.cookiesReject();
        mainPageCatalog.cookiesRefuse();
    }
    @AfterEach
    void afterEach(){
        Selenide.clearBrowserLocalStorage();
    }

    @CsvFileSource(resources = "/testData/catalogTestsFile")
    @ParameterizedTest(name = "Тест кликабельности категории {0} на главной странице")
    void catalogTests(String testData, String expectedValue){
        mainPageCatalog.categorySelect(testData);
        mainPageCatalog.checkExpectedValue(expectedValue);
    }
    @CsvFileSource(resources = "/testData/searchStringTestFile")
    @ParameterizedTest(name = "Тест поиска товара {0} через поисковую строку")
    void searchStringTest(String searchQuery, String expectedLink){
        searchStringPage.searchGoods(searchQuery);
        searchStringPage.searchResultPageShouldHaveText(expectedLink);
        searchStringPage.clickSearchClear();
    }
}
