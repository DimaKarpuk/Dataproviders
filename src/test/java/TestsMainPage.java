
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.Cities;
import pages.CitiesPage;
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
        Selenide.closeWebDriver();
    }

    @CsvFileSource(resources = "/testData/catalogTestsFile")
    @ParameterizedTest(name = "Тест кликабельности категории {0} на главной странице")
    void catalogTests(String testData, String expectedValue){
        mainPageCatalog.categorySelect(testData);
        mainPageCatalog.checkExpectedValue(expectedValue);
    }
    @ValueSource(strings = {"Наушники" , "Очки" , "Зеркало"})
    @ParameterizedTest(name = "Тест поиска товара {0} через поисковую строку")
    void searchStringTest(String input){
        searchStringPage.searchGoods(input);
        searchStringPage.searchResultPageShouldHaveText();
        searchStringPage.clickSearchClear();
    }
    @EnumSource(Cities.class)
    @ParameterizedTest
    void siteShouldHaveCorrectCitesTest(Cities cities){
        CitiesPage.choiceCitiInput();
        CitiesPage.clearIndicatorCitiChoice();
        CitiesPage.citiSearch(cities.description);
        CitiesPage.citiChoiceSave();
        CitiesPage.checkMainPageShouldBeCitiChoice(cities.description);
    }
}
