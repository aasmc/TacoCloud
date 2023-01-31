package ru.aasmc.tacoclound;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageBrowserTest {

    @LocalServerPort
    private int port;
    private static HtmlUnitDriver browser;

    @BeforeAll
    public static void setup() {
        browser = new HtmlUnitDriver();
        browser.manage().timeouts()
                .implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
    }

    @AfterAll
    public static void teardown() {
        browser.quit();
    }

    @Test
    public void testHomePage() {
        String homePage = "http://localhost:" + port;
        browser.get(homePage);

        String title = browser.getTitle();
        assertEquals("Taco Cloud", title);

        String h1 = browser.findElement(new By.ByTagName("h1")).getText();
        assertEquals("Welcome to...", h1);

        String imgSrc = browser.findElement(new By.ByTagName("img")).getAttribute("src");
        assertEquals(homePage + "/images/TacoCloud.png", imgSrc);
    }
}
