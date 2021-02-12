import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BMICalculatorTest {

    WebDriver driver;
    @Test
    public void seleniumStart() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        WebElement weightInput = driver.findElement(By.name("wg"));
        weightInput.sendKeys("72");
        WebElement heightInput = driver.findElement(By.name("ht"));
        heightInput.sendKeys("184");
        WebElement calculateButton = driver.findElement(By.name("cc"));
        calculateButton.click();
        WebElement bmiStatus = driver.findElement(By.className("content"));
        String expectedBmiStatus = "Your category is Normal";
        String actualBmiStatus = bmiStatus.getAttribute("value");
        Assert.assertEquals(actualBmiStatus, expectedBmiStatus);



    }


}
