import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class AutoRia
{


    public static WebDriver driver;

    public static void main (String[] args)
    {
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com.ua");
        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("auto ria");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement autoRiaResult = driver.findElement(By.xpath("//li[@role='presentation'][1]"));
        autoRiaResult.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement autoRiaLink = driver.findElement(By.xpath("//h3[@class='r'][1]"));
        autoRiaLink.click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='cansel close']")).click();

        fillFields("//select[@id='categories']", "//*[@id='categories']/option[2]");
        fillFields("//*[@id='brandTooltipBrandAutocomplete-1']", "//*[@id='brandTooltipBrandAutocomplete-1']/ul/li[6]/a");
        fillFields("//*[@id='brandTooltipModelAutocomplete-1']/label", "//*[@id='brandTooltipModelAutocomplete-1']/ul/li[9]/a");
        fillFields("//*[@id='regionCenters']", "//*[@id='regionCenters']/option[14]");
        fillFields("//*[@id='year']", "//*[@id='year']/option[22]");
        fillFields("//*[@id='yearTo']", "//*[@id='yearTo']/option[8]");
        fillFields("//*[@id='priceFrom']", 9000);
        fillFields("//*[@id='priceTo']", 19000);

        /*WebElement categories = driver.findElement(By.xpath("//select[@id='categories']"));
        categories.click();
        WebElement selectVehicleType = driver.findElement(By.xpath("//*[@id='categories']/option[2]"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        selectVehicleType.click();
        WebElement wd = driver.findElement(By.className("review-front"));
        wd.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement mark = driver.findElement(By.xpath("//*[@id='brandTooltipBrandAutocomplete-1']"));
        mark.click();
        WebElement selectMark = driver.findElement(By.xpath("//*[@id='brandTooltipBrandAutocomplete-1']/ul/li[6]/a"));
        selectMark.click();
        wd.click();
        */
        driver.findElement(By.className("button-primary")).click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List<WebElement> listOfResults = driver.findElements(By.xpath("//span[@class='blue bold']"));
        listOfResults.get(0).click();
        WebElement carTitle = driver.findElement(By.xpath("//h1[@title='Alfa Romeo 159 3.2 Q4 2007']"));

    }

    public static void fillFields(String xpath_1, String xpath_2)
    {
        WebElement fieldFinder = driver.findElement(By.xpath(xpath_1));
        fieldFinder.click();
        WebElement selectField = driver.findElement(By.xpath(xpath_2));
        selectField.click();
        WebElement completeForm = driver.findElement(By.className("review-front"));
        completeForm.click();
    }

    public static void fillFields(String xpath_1, int price)
    {
        WebElement fieldFinder = driver.findElement(By.xpath(xpath_1));
        fieldFinder.click();
        String priceToFill = Integer.toString(price);
        fieldFinder.sendKeys(priceToFill);
        WebElement completeForm = driver.findElement(By.className("review-front"));
        completeForm.click();
    }

}
