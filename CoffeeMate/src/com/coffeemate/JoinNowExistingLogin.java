package com.coffeemate;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")
public class JoinNowExistingLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://stage.coffee-mate.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJoinNowExisting() throws Exception {
    System.out.println("This test case will verify that when a user tries to log-in as an existing user with an existing. User will see Error Message \"This email address already exists in our system. Please choose a different email address.\"");
    driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=tester92010013%40yahoo.com&stt=True");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtFirstName")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtFirstName")).sendKeys("PubmoTestFirst");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtLastName")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtLastName")).sendKeys("PubmoTestLast");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtPassword")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtPassword")).sendKeys("password123");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtConfirmPassword")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtConfirmPassword")).sendKeys("password123");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtAddress")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtAddress")).sendKeys("1000 BroadwAY LANE");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtAddress2")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtAddress2")).sendKeys("Suite 3V");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtCity")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtCity")).sendKeys("New York");
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_ddlStates"))).selectByVisibleText("New York");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtZipCode")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_txtZipCode")).sendKeys("10003");
    driver.findElement(By.name("flavorTheme")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucRegisterUser_btnRegister")).click();
    // Warning: waitForTextPresent may require manual changes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*This email address already exists in our system\\. Please choose a different email address\\.[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*This email address already exists in our system\\. Please choose a different email address\\.[\\s\\S]*$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
