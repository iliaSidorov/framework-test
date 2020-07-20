package com.appline.testproject.framework.pages;

import com.appline.testproject.framework.util.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MenuPage extends BasePage{

    @FindBy(xpath = "//ul[@class='lg-menu__list']//span[text()]")
    private List<WebElement> mainMenuItems;

    @FindBy(xpath = "//div[@class='lg-menu__sub']//a[text()]")
    private List<WebElement> subMenuItems;

    public void selectMainMenuItem(String menuItem) {
        for (WebElement item : mainMenuItems) {
            if (item.getText().equalsIgnoreCase(menuItem)) {
                //wait and focus on menuItem
                new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(item));
                new Actions(DriverManager.getDriver()).moveToElement(item).perform();
                return;
            }
        }
        Assertions.fail("Cannot find menu item " + menuItem);
    }

    public void selectSubMenuItem(String subMenuItem) {
        for (WebElement item : subMenuItems) {
            if (item.getText().equalsIgnoreCase(subMenuItem)) {
                new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
    }





}
