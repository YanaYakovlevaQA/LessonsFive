import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class solutionsEnterprize {

    @BeforeAll
    static void setUp () {
        Configuration.browserSize = "1920x1980";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
       //Configuration.holdBrowserOpen = true; конфигурация для проверки теста
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