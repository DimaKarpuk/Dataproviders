package tetst;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.Cities;
import pages.CitiesPage;
import pages.MainPageCatalog;
import pages.SearchStringPage;

import static io.qameta.allure.Allure.step;


public class TestsMainPage extends TestBase {
    MainPageCatalog mainPageCatalog = new MainPageCatalog();
    SearchStringPage searchStringPage = new SearchStringPage();

    @Tag("simple")
    @CsvFileSource(resources = "/testData/catalogTestsFile")
    @ParameterizedTest(name = "Тест кликабельности категории {0} на главной странице")
    void catalogTests(String testData, String expectedValue){
        step("Кликаем по категории товара на главной странице", () -> {
            mainPageCatalog.categorySelect(testData);
        });
        step("Проверяем результат категории товара" , () -> {
            mainPageCatalog.checkExpectedValue(expectedValue);
        });

    }
    @Tag("high")
    @ValueSource(strings = {"Наушники" , "Очки" , "Зеркало"})
    @ParameterizedTest(name = "Тест поиска товара {0} через поисковую строку")
    void searchStringTest(String input){
        step("Пойск товара через пойсковую строку", () -> {
            searchStringPage.searchGoods(input);
        });
        step("Проверяем результата пойска", () -> {
            searchStringPage.searchResultPageShouldHaveText();
        });
        step("Очистка пойсковай строки", () -> {
            searchStringPage.clickSearchClear();
        });

    }
    @Tag("low")
    @EnumSource(Cities.class)
    @ParameterizedTest
    void siteShouldHaveCorrectCitesTest(Cities cities){
        step("Выбор города для доставки", () -> {
            CitiesPage.choiceCitiInput();
            CitiesPage.clearIndicatorCitiChoice();
            CitiesPage.citiSearch(cities.description);
            CitiesPage.citiChoiceSave();

        });
        step("Проверка отображения выбранного города для доставки", () -> {
            CitiesPage.checkMainPageShouldBeCitiChoice(cities.description);
        });
    }
}
