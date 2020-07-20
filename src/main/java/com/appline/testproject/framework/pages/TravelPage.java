package com.appline.testproject.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelPage extends BasePage {

    @FindBy(xpath = "//div//h3[contains(text(), 'Минимальная')]")
    private WebElement minimalBtn;

    @FindBy(xpath = "//button[contains(text(), 'Оформить')]")
    private WebElement issueBtn;

    public WebElement getMinimalBtn() {
        return minimalBtn;
    }

    public WebElement getIssueBtn() {
        return issueBtn;
    }


}
