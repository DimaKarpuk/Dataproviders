package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class CitiesPage {
    public static final SelenideElement
            inputChoiceCiti = $(".styles_localityBtn__qrGFQ"),
            clearIndicator = $(".BaseSuggest-module__clearIndicator"),
            searchCiti = $("#react-select-2-listbox"),
            saveCitiChoice = $(byText("Сохранить")),
            checkPageShouldBeCitiChoice =$ ("[role = 'presentation']");


    public static void choiceCitiInput(){
        inputChoiceCiti.click();
    }

    public static void clearIndicatorCitiChoice() {
        clearIndicator.click();
    }
    public static void citiSearch(String value){
        searchCiti.$(byText(value)).click();
    }
    public static void citiChoiceSave(){
        saveCitiChoice.click();
    }
    public static void checkMainPageShouldBeCitiChoice(String value){
        checkPageShouldBeCitiChoice.shouldHave(text(value));

    }
}
