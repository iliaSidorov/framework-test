package com.appline.testproject.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelInsurancePage extends BasePage{

    @FindBy(xpath = "//a//b[contains(text(), 'Оформить онлайн')]")
    private WebElement issueOnlineBtn;

    public WebElement getIssueOnlineBtn() {
        return issueOnlineBtn;
    }
}
