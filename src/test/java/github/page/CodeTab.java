package github.page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CodeTab {

    private final String codeTab = "#code-tab";

    public CodeTab() {
        $(codeTab).shouldBe(visible)
                .shouldHave(cssClass("selected"));
    }

    @Step("Открыть репозиторий {repoName} на github")
    public static CodeTab openRepoPage(String repoName) {
        Selenide.open("/" + repoName);
        return new CodeTab();
    }

    @Step("Открыть вкладку 'Wiki'")
    public WikiTab openWikiTab() {
        $("#wiki-tab").click();
        return new WikiTab();
    }
}
