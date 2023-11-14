package component;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.AbsBasePage;

import java.util.List;

public class EventsCatalog  extends AbsBasePage {
    public EventsCatalog(WebDriver driver) {
        super(driver, "/");
    }
    @FindBy(css = ".dod_new-events__list.js-dod_new_events a")
    private List<WebElement> eventsListLocator;

    @FindBy(css = ".dod_new-event__time")
    private List<WebElement> eventsDateListLocator;

    @FindBy(css = ".dod_new-events-dropdown__input")
    private WebElement sortEventsCloseLocator;

    private String sortEventsOpenLocator = "div[class*='dod_new-events-dropdown_opened'] a[title='%s']";

    public EventsCatalog checkVisibleEvents() {

        for (WebElement element : eventsListLocator) {
            Assertions.assertTrue(element.isDisplayed());
        }
        new CookiePopup(driver)
                .clickOnButtonCookie();
        return this;
    }
}
