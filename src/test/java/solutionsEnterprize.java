import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class solutionsEnterprize {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1980";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void solutionsEnterprize() {

        //Открытие github
        open("/git-guides");

        //Открытие Solutions
        $(withTagAndText("button", "Solutions")).hover();

        //Клик по Enterprises
        $(byText("Enterprises")).click();

        //Проверка
        $("#hero-section-brand-heading").shouldHave(exactText("The AI-powered\ndeveloper platform"));
    }
}