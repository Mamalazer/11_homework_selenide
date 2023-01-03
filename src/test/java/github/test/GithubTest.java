package github.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static github.page.CodeTab.openRepoPage;

public class GithubTest extends BaseTest {

    @Test
    @DisplayName("Check block 'SoftAssertions' on selenide page in the github")
    public void test01() {
        openRepoPage("/selenide/selenide")
                .openWikiTab()
                .showAllPages()
                .openPageByName("SoftAssertions")
                .checkText("Using JUnit5");
    }
}
