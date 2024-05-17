package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class MainPageCatalog {
    SelenideElement rejectСookies = $("[aria-label='Отклонить']"),
    refuseСookies = $(byText("Отказаться")),
    selectСategory = $(".styles_promoList__yozMt"),
    visibilityСheck = $("h1");

    public void cookiesReject(){
        rejectСookies.click();
    }

    public void cookiesRefuse(){
        refuseСookies.click();
    }

    public void categorySelect(String value){
        selectСategory.$(byText(value)).click();
    }

    public void checkExpectedValue(String value){
        visibilityСheck.shouldHave(text(value)).shouldBe(visible);
    }


}


