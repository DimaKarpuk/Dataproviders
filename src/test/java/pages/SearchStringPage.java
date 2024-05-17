package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchStringPage {
    static SelenideElement search = $("#catalogSearch"),
    clearSearchInput = $(".Search_clearBtn__j9c8N"),
    checkPageShouldBeInputResult = $(".cr-category_header");
    public static void searchGoods(String value){
        search.setValue(value).pressEnter();
    }

    public static void clickSearchClear() {
        clearSearchInput.click();
    }
    public static void searchResultPageShouldHaveText(String value){
        checkPageShouldBeInputResult.shouldHave(text(value));
    }
}
