package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.fastSetValue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class Hooks {

    @Before
    public void setup() {
        browserSize = "1440x800";
        baseUrl = "https://www.google.com";
        timeout = 20000;
        fastSetValue = true;
        open("/");
    }

    @After
    public void after() {
        clearBrowserCache();
        clearBrowserCookies();
        close();
    }
}