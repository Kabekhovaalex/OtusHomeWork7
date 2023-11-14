package component;
import data.CategoryData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CourseFilterComponent extends AbsBaseComponent{

    public CourseFilterComponent(WebDriver driver) {
        super(driver);
    }
    private String courseCategoryLocator = "//div[./label[text()='%s']]//input";
    ////main[contains(@class,'sc-1j17uuq-1 dPcKhb')] /child::section/descendant::section/descendant::div/div[contains(text(), 'Тестирование')]
    public CourseFilterComponent checkСourseFilterComponent(CategoryData categoryData, boolean state) {

        String locator = String.format(courseCategoryLocator, categoryData.getName());
        Assertions.assertEquals(state, $(By.xpath(locator)).isSelected());
        return this;
    }
}
