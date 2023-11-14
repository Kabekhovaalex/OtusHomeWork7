import component.*;
import data.BrowserData;
import data.CategoryData;
import data.CoursesTestingData;
import data.courses.CoursesDurationData;
import data.courses.CoursesFormatData;
import data.courses.CoursesSubTitleData;
import data.courses.CoursesTitleData;
import data.menu.HeaderMenuItemData;
import data.menu.SubMenuCategoryCourseItemData;
import exception.BrowserNorSupportedException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.pages.CoursePage;
import pageObject.pages.MainPage;
import sun.plugin.dom.exception.BrowserNotSupportedException;
import waiters.Waiters;

import java.util.concurrent.TimeUnit;

public class UITest {
    private org.apache.logging.log4j.Logger log = LogManager.getLogger(UITest.class);
    private WebDriver driver;


    @BeforeAll
    public static void setUpDriver() throws BrowserNotSupportedException {
        new WebDriverFactory().setUp(BrowserData.FIREFOX);
    }

    @BeforeEach
    public void start() throws BrowserNotSupportedException {
        driver = new WebDriverFactory().createDriver(BrowserData.FIREFOX);
    }

//    @AfterEach
//    public void shutdown() {
//        if (driver != null) {
//            driver.quit();
//            log.info("Закрытие драйвера");
//        }
//    }

    @Test
    public void checkCountCoursesInQASectionTest() {
        new MainPage(driver).open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);


        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);
        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.TESTING);
        new CourseFilterComponent(driver)
                .checkСourseFilterComponent(CategoryData.TESTING, true);

        new CourseCatalog(driver)
                .checkVisibleCourses()
                .checkCountCourses(10);
    }

    @Test
    public void checkCourseInfoTest() {
        String titleCourse = "Java QA Engineer. Professional";
        String subTitleCourse = "Прокачайте свои навыки автоматизации тестирования на Java";
        String durationCourse = "4 месяца";
        String formatCourse = "Онлайн";

        new MainPage(driver)
                .open();

        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);


        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);

        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.TESTING);

        new CourseCatalog(driver)
                .clickCourse(CoursesTestingData.JAVA_QA_PRO.getName());

//        String str = driver.findElement(By.cssSelector(" .sc-1og4wiw-0.sc-s2pydo-1.ifZfhS.diGrSa")).getText();
//        System.out.println("check header = " + str);
       new CoursePage(driver)
              .checkTitleCourse(titleCourse, CoursesTitleData.JAVA_QA_PRO)
                .checkSubTitleCourse(subTitleCourse, CoursesSubTitleData.JAVA_QA_PRO)
                .checkDurationCourse(durationCourse, CoursesDurationData.JAVA_QA_PRO)
               .checkFormatCourse(formatCourse, CoursesFormatData.JAVA_QA_PRO);

    }

    @Test
    public void checkEventsDateTest() {
        new MainPage(driver)
                .open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);

        //headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING);
        WebElement el = driver.findElement(By.xpath("//a[contains(text(),'Тестирование')]"));
        el.click();
       //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //.clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.LESSON_CALENDAR);
//new Waiters (driver).waitUrlContains("events/near/");

//        new EventsCatalog(driver)
//                .checkVisibleEvents();
        // .checkEventsDate();
    }


    @Test
    public void checkSortEventsTest() {

        new MainPage(driver)
                .open();

        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);

        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.LESSON_CALENDAR);
    }
}

