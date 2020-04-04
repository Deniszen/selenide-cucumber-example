package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GooglePage extends BasePage {

    private SelenideElement logo = $(byId("hplogo"));

    private SelenideElement searchField = $(byName("q"));

    private SelenideElement buttonSearch = $(byName("btnK"));

    private SelenideElement buttonDoodle = $(byName("btnI"));

    private ElementsCollection suggestions = $$(".sbct");

    private ElementsCollection results = $$(byXpath("//div[@class='g']"));

    private ElementsCollection domainNames = $$(byXpath("//div[@class='g']//cite"));

    public void checkLogo() {
        shouldBeConditions(logo, visible);
    }

    public void checkSearchField() {
        shouldBeConditions(searchField, visible);
    }

    public void checkSearchButton() {
        shouldBeConditions(buttonSearch, exist, enabled);
    }

    public void checkDoodleButton() {
        shouldBeConditions(buttonDoodle, exist, enabled);
    }

    public void enterSearchText(String text) {
        typeText(searchField, text);
        click(suggestions.first());
    }

    public void checkResults(int count) {
        results.shouldHaveSize(count);
    }

    public void checkDomain(int number, String domainName) {
        domainNames.get(number - 1).shouldHave(text(domainName));
    }
}