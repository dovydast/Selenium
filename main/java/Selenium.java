import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {
    static WebDriver chromeBrowser;

    public static void main(String[] args){
        System.out.println("Selenium");
    }

    static public void setup(){
        System.setProperty("webdriver.chrome.driver",".\\.\\src\\drivers\\chromedriver.exe");
        chromeBrowser = new ChromeDriver();
        chromeBrowser.get("https://google.com");
    }
    static public void setupTwitch(){
        System.setProperty("webdriver.chrome.driver",".\\.\\src\\drivers\\chromedriver.exe");
        chromeBrowser = new ChromeDriver();
        chromeBrowser.get("https://twitch.tv");
    }

    static public void searchByKeyword(String keyword){
       WebElement searchField = chromeBrowser.findElement(By.name("q"));
       searchField.sendKeys(keyword);
       WebElement clicktoSearch = chromeBrowser.findElement(By.name("btnK"));
       waitForElementByName("btnK");
       clicktoSearch.click();

       WebElement resultField = chromeBrowser.findElement(By.id("resultStats"));

       String results = resultField.getText().replaceAll("[ ().,A-Za-z]","");
       System.out.println(results.substring(0,6));
       int results2 = Integer.parseInt(results);
       if(results2 > 500000){
           System.out.println("Paiskos rezultatu daugiau nei 50k");
       }
       else{
           System.out.println("Paieskos rezultatu maziau nei 50k");
       }

    }

    static public void registerTwitchAccount(String username, String password, int monthIndex, String day, String year, String email ){
        // Click the register button to create new account
        waitForElementByXpath("//button[@data-test-selector='anon-user-menu__sign-up-button']");
        WebElement signupButton = chromeBrowser.findElement(By.xpath("//button[@data-test-selector='anon-user-menu__sign-up-button']"));
        signupButton.click();

        // Enter username
        waitForElementById("signup-username");
        WebElement nameInput = chromeBrowser.findElement(By.id("signup-username"));
        nameInput.sendKeys(username);

        //Enter password
        waitForElementById("password-input");
        WebElement passwordInput = chromeBrowser.findElement(By.id("password-input"));
        passwordInput.sendKeys(password);

        //Select Month February
        waitForElementByXpath("//select[@data-a-target=\"birthday-month-select\"]");
        Select selectDate = new Select(chromeBrowser.findElement(By.xpath("//select[@data-a-target='birthday-month-select']")));
        selectDate.selectByIndex(monthIndex);

        //Enter monthday
        waitForElementByXpath("//div[@data-a-target='birthday-date-input']//input[@data-a-target='tw-input']");
        WebElement enterMonth = chromeBrowser.findElement(By.xpath("//div[@data-a-target='birthday-date-input']//input[@data-a-target='tw-input']"));
        enterMonth.sendKeys(day);

        //Enter year

        waitForElementByXpath("//div[@data-a-target='birthday-year-input']//input[@data-a-target='tw-input']");
        WebElement enterYear = chromeBrowser.findElement(By.xpath("//div[@data-a-target='birthday-year-input']//input[@data-a-target='tw-input']"));
        enterYear.sendKeys(year);

        //Enter email
        waitForElementById("email-input");
        WebElement enterEmail = chromeBrowser.findElement(By.id("email-input"));
        enterEmail.sendKeys(email);

        //Button signUp confirm

        waitForElementByXpath("//button[@data-a-target='passport-signup-button']");
        WebElement submitRegister = chromeBrowser.findElement(By.xpath("//button[@data-a-target='passport-signup-button']"));
        submitRegister.click();

    }

    static private void waitForElementByName(String name){
        WebDriverWait waitas = new WebDriverWait(chromeBrowser, 2);
        waitas.until(ExpectedConditions.elementToBeClickable(By.name(name)));
    }
    static private void waitForElementByClassName(String name){
        WebDriverWait waitas = new WebDriverWait(chromeBrowser, 4);
        waitas.until(ExpectedConditions.elementToBeClickable(By.className(name)));
    }
    static private void waitForElementById(String name){
        WebDriverWait waitas = new WebDriverWait(chromeBrowser, 4);
        waitas.until(ExpectedConditions.elementToBeClickable(By.id(name)));
    }
    static private void waitForElementByXpath(String xpath){
        WebDriverWait waitas=new WebDriverWait(chromeBrowser,2);
        waitas.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static void close(){
        chromeBrowser.close();
    }

    public static void quit(){
        chromeBrowser.quit();
    }
}
