package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

public abstract class BasePage {

    private int timeout = 5000;

    public void click(SelenideElement element){
        element.waitUntil(visible, timeout);
        element.shouldBe(enabled);
        element.click();
    }

    public void typeText(SelenideElement element, String text){
        element.shouldBe(visible, enabled).clear();
        element.val(text);
    }

    public void shouldBeConditions(SelenideElement element, Condition... conditions){
        for(Condition condition: conditions){
            element.shouldBe(condition);
        }
    }
}