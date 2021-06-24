package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class TitleSteps {

    WebDriver driver = null;

    @Given("the browser is opened")
    public void the_browser_is_opened() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @And("the google search page is opened")
    public void the_google_search_page_is_opened() {
        driver.navigate().to("https://google.com");
    }
    @When("the {string} search word is entered")
    public void the_search_word_is_entered(String string) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        driver.findElement(By.name("q")).sendKeys("test automation");
    }
    @And("the enter button is clicked")
    public void the_enter_button_is_clicked() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
    @And("the {string} - th search result link is clicked")
    public void the_th_search_result_link_is_clicked(String string) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("g")));
        driver.findElements(By.className("g")).get(new Random().nextInt(10)+1).click();
    }
    @Then("the {string} word is present in the title")
    public void the_word_is_present_in_the_title(String string) throws InterruptedException {
        driver.getTitle().contains("Automation");
        driver.close();
        driver.quit();
    }

}
