package component;

import data.menu.HeaderMenuItemData;
import data.menu.ISubMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPopup extends AbsBaseComponent{
    public HeaderPopup(WebDriver driver) {
        super(driver);
    }
    private String headerSubmenuPopupSelector = "[title='%s']";
    private String subMenuItemLocator = "//a[contains(text(),'%s')]";
    ////span[contains(@title,'Обучение')]



    public HeaderPopup popupShouldBeVisible(HeaderMenuItemData headerMenuItemData) {

        String selector = String.format(headerSubmenuPopupSelector, headerMenuItemData.getName());
        webDriverWait.waitForAttributeNotContains($(By.cssSelector(selector)), "style", "none");
        return this;
    }

    public HeaderPopup clickSubMenuItemCoursesName(ISubMenu subMenuItemData) {

        String locator = String.format(subMenuItemLocator, subMenuItemData.getName());
        $(By.xpath(locator)).click();
        return this;
    }

//    public HeaderPopup moveCursorToHeaderItem(ISubMenu subMenuItemData) {
//        //  //span[contains(@title,'Обучение')]
//        String selector = String.format(subMenuItemLocator, subMenuItemData.getName());
//        //String selector = String.format("[data-name='%s'].header3__nav-item", headerMenuItemData.getName());
//        actions
//                .moveToElement($(By.cssSelector(selector)))
//                .build()
//                .perform();
//        return this;
//    }
}
