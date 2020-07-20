package com.appline.testproject.framework.pages;

import com.appline.testproject.framework.util.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelFormingPage extends BasePage {

    //insurance fields
    @FindBy(xpath = "//input[@id='surname_vzr_ins_0']")
    private WebElement insSurnameInp;
    @FindBy(xpath = "//input[@id='name_vzr_ins_0']")
    private WebElement insNameInp;
    @FindBy(xpath = "//input[@id='birthDate_vzr_ins_0']")
    private WebElement insBirthDateInp;

    //personal fields
    @FindBy(xpath = "//label[contains(text(), 'гражданин РФ')]")
    private WebElement RFCitizenBtn;
    @FindBy(xpath = "//label[contains(text(), 'иностранный гражданин')]")
    private WebElement foreignCitizenBtn;
    @FindBy(xpath = "//input[@id='person_lastName']")
    private WebElement personLastNameInp;
    @FindBy(xpath = "//input[@id='person_firstName']")
    private WebElement personFirstNameInp;
    @FindBy(xpath = "//input[@id='person_middleName']")
    private WebElement personMiddleNameInp;
    @FindBy(xpath = "//input[@id='person_birthDate']")
    private WebElement personBirthDateInp;

    //passport fields
    @FindBy(xpath = "//input[@id='passportSeries']")
    private WebElement passportSeriesInp;
    @FindBy(xpath = "//input[@id='passportNumber']")
    private WebElement passportNumberInp;
    @FindBy(xpath = "//input[@id='documentDate']")
    private WebElement documentDateInp;
    @FindBy(xpath = "//input[@id='documentIssue']")
    private WebElement documentIssueInp;

    //contact fields
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneInp;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInp;
    @FindBy(xpath = "//input[@id='repeatEmail']")
    private WebElement repeatEmailInp;

    //buttons
    @FindBy(xpath = "//label[contains(text(), 'Мужской')]")
    private WebElement maleBtn;
    @FindBy(xpath = "//label[contains(text(), 'Женский')]")
    private WebElement femaleBtn;
    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueBtn;
    @FindBy(xpath = "//button[contains(text(), 'Назад')]")
    private WebElement backBtn;


    public void fillField(WebElement element, String text) {
        try {
            new WebDriverWait(DriverManager.getDriver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(element))
                    .sendKeys(text);
        } catch (Exception e) {
            System.out.println("Cannot fill the field");
            e.printStackTrace();
        }
    }

    //need to be improved
    public void fillDateField(WebElement element, String text) {
        try {
            new WebDriverWait(DriverManager.getDriver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(element))
                    .sendKeys(text);
            element.sendKeys(Keys.TAB);
        } catch (Exception e) {
            System.out.println("Cannot fill the date field");
            e.printStackTrace();
        }
    }

    public boolean isAllFieldsValidated() {
        if (DriverManager.getDriver().getPageSource().contains("Поле не заполнено")) {
            System.out.println("Not all fields are validated");
            return false;
        }
        System.out.println("All fields are validates");
        return true;
    }

    //getters
    public WebElement getInsSurnameInp() {
        return insSurnameInp;
    }
    public WebElement getInsNameInp() {
        return insNameInp;
    }
    public WebElement getInsBirthDateInp() {
        return insBirthDateInp;
    }
    public WebElement getRFCitizenBtn() {
        return RFCitizenBtn;
    }
    public WebElement getForeignCitizenBtn() {
        return foreignCitizenBtn;
    }
    public WebElement getPersonLastNameInp() {
        return personLastNameInp;
    }
    public WebElement getPersonFirstNameInp() {
        return personFirstNameInp;
    }
    public WebElement getPersonMiddleNameInp() {
        return personMiddleNameInp;
    }
    public WebElement getPersonBirthDateInp() {
        return personBirthDateInp;
    }
    public WebElement getMaleBtn() {
        return maleBtn;
    }
    public WebElement getFemaleBtn() {
        return femaleBtn;
    }
    public WebElement getPassportSeriesInp() {
        return passportSeriesInp;
    }
    public WebElement getPassportNumberInp() {
        return passportNumberInp;
    }
    public WebElement getDocumentDateInp() { return documentDateInp; }
    public WebElement getDocumentIssueInp() {
        return documentIssueInp;
    }
    public WebElement getPhoneInp() {
        return phoneInp;
    }
    public WebElement getEmailInp() {
        return emailInp;
    }
    public WebElement getRepeatEmailInp() {
        return repeatEmailInp;
    }
    public WebElement getContinueBtn() {
        return continueBtn;
    }
    public WebElement getBackBtn() {
        return backBtn;
    }

}
