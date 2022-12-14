package github.page;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WikiTab {

    private final String wikiTab = "#wiki-tab";

    public WikiTab() {
        $(wikiTab).shouldBe(visible)
                .shouldHave(cssClass("selected"));
    }

    @Step("Раскрыть список всех страниц в разделе 'Pages'")
    public WikiTab showAllPages() {
        $(".js-wiki-more-pages-link").click();
        return this;
    }

    @Step("Открыть страницу с именем {pageName}")
    public WikiTab openPageByName(String pageName) {
        $$(".wiki-rightbar a").filter(text(pageName)).first().click();
        $(".gh-header-title").shouldHave(text(pageName));
        return this;
    }

    @Step("Убедиться, что на странице присутствует текст {text}")
    public WikiTab checkText(String text) {
        $("#wiki-body").shouldHave(text(text));
        return this;
    }
}
