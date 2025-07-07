import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class dragAndDropTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1980";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");

        $(columnA).shouldHave(text("A"));
        $(columnB).shouldHave(text("B"));

        WebElement beginning = columnA.toWebElement();
        WebElement end = columnB.toWebElement();

        Selenide.actions().clickAndHold(beginning).moveToElement(end).release().build().perform();

        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }

    @Test
    void dragAndDropTest2() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDrop(to("#column-b"));

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}