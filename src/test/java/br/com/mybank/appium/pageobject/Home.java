package br.com.mybank.appium.pageobject;

import br.com.mybank.appium.util.NicoUno;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.com.mybank.appium.runner.DriverFactory.getDriver;

public class Home {

    NicoUno nicouno = new NicoUno();

    By btnSignUp = By.xpath("//android.view.View[@content-desc='Navigate up']");
    By btnEmail = By.xpath("//*[@class='android.widget.EditText' and @text='Email']");
    By btnPassword = By.xpath("//*[@class='android.widget.EditText' and @text='Password']");
    By btnLogin = By.xpath("//android.view.View[@content-desc='LOG IN']");
    By btnRemember = By.xpath("//android.view.View[@content-desc='Remember Me']");
    By btnForgotPassword = By.xpath("//android.view.View[@content-desc='FORGOT PASSWORD?']");
    By errorEmail = By.xpath("//android.view.View[@content-desc='Please enter a valid email']");
    By errorPassword = By.xpath("//android.view.View[@content-desc='Please enter a valid password']");


    public void validateElementsOnScreen () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorEmail));
        getDriver().findElement(errorEmail).getText().equals("Please enter a valid email");
        getDriver().findElement(errorPassword).getText().equals("Please enter a valid email");
    }

    public void selectRememberButton () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 1);
        wait.until(ExpectedConditions.presenceOfElementLocated(btnRemember));
        getDriver().findElement(btnRemember).click();
    }

    public void validateHome () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 1);
        wait.until(ExpectedConditions.presenceOfElementLocated(btnLogin));
    }


    //we used the action, because appium and uiautomator didn't identify the email and password input field as a text field
    public  void inputLogin () {
        getDriver().findElement(btnEmail).click();
        Actions action = new Actions(getDriver());
        action.sendKeys("michellealvesmas@hotmail.com").perform();
        getDriver().findElement(btnPassword).click();
        action.sendKeys("teste123").perform();
        getDriver().hideKeyboard();
        getDriver().findElement(btnLogin).click();
    }

    public  void notInputLogin () {
        getDriver().findElement(btnEmail).click();
        getDriver().findElement(btnPassword).click();
        getDriver().hideKeyboard();
        getDriver().findElement(btnLogin).click();
    }

}
