package com.appline.testproject.framework.pages;

import com.appline.testproject.framework.util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //find element by selector
    public boolean isElementPresent(By by) {
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            DriverManager.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    }

    public void clickElement(WebElement element) {
        if (isElementPresent(element)) {
            new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }




}
