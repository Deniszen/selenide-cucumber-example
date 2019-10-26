package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.AttributeWithValue;

import static com.codeborne.selenide.Condition.*;

public abstract class BasePage {

    public void click(SelenideElement element){
        element.waitUntil(visible, 5000);
        element.shouldBe(enabled);
        element.click();
    }

    public void doubleClick(SelenideElement element) {
        element.waitUntil(visible, 5000);
        element.shouldBe(enabled);
        element.doubleClick();
    }

    public void typeText(SelenideElement element, String text){
        element.shouldBe(visible, enabled).clear();
        element.val(text);
    }

    public void sendText(SelenideElement element, String text) {
        element.shouldBe(visible, enabled).clear();
        element.sendKeys(text);
    }

    public void shouldBeConditions(SelenideElement element, Condition... conditions){
        for(Condition condition: conditions){
            element.shouldBe(condition);
        }
    }

    public void shouldNotBeConditions(SelenideElement element, Condition... conditions){
        for(Condition condition: conditions){
            element.shouldNotBe(condition);
        }
    }

    public void shouldNotHaveAttribute(SelenideElement element, AttributeWithValue... attributes){
        for(AttributeWithValue attribute: attributes){
            element.shouldNotHave(attribute);
        }
    }

    public void shouldHaveAttribute(SelenideElement element, AttributeWithValue... attributes){
        for(AttributeWithValue attribute: attributes){
            element.shouldHave(attribute);
        }
    }


    public void checkText(SelenideElement element, String text) {
        element.shouldBe(visible).shouldHave(text(text));
    }

    public void checkValue(SelenideElement element, String value) {
        element.shouldBe(visible).shouldHave(value(value));
    }
}