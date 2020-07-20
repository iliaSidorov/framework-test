package com.appline.testproject.tests;

import com.appline.testproject.framework.pages.MenuPage;
import com.appline.testproject.framework.pages.TravelFormingPage;
import com.appline.testproject.framework.pages.TravelInsurancePage;
import com.appline.testproject.framework.pages.TravelPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;


class MainTest extends BaseTest{

    //test data
    private final static String INS_SURNAME = "Бобров";
    private final static String INS_NAME = "Борис";
    private final static String INS_BIRTH = "06.11.1998";
    private final static String LAST_NAME = "Боброва";
    private final static String FIRST_NAME = "Белла";
    private final static String MIDDLE_NAME = "Борисовна";
    private final static String BIRTH = "01.03.1983";
    private final static String PASS_SERIES = "4095";
    private final static String PASS_NUMBER = "460769";
    private final static String PASS_DATE = "01.03.2003";
    private final static String PASS_ISSUE = "МВД г.Москвы";

    @Test
    void test() {
        //initialize pages
        MenuPage menuPage = new MenuPage();
        TravelInsurancePage travelInsurancePage = new TravelInsurancePage();
        TravelPage travelPage = new TravelPage();
        TravelFormingPage travelFormingPage = new TravelFormingPage();

        menuPage.selectMainMenuItem("Страхование");
        menuPage.selectSubMenuItem("Страхование путешественников");

        //assert that header 'Страхование путешественников' is present
        String headerXpath = "//h1[contains(text(), 'Страхование путешественников')]";
        assertTrue(menuPage.isElementPresent(By.xpath(headerXpath)),
                String.format("Cannot find header 'Страхование путешественников' by xpath %s", headerXpath));

        travelInsurancePage.clickElement(travelInsurancePage.getIssueOnlineBtn());

        travelPage.clickElement(travelPage.getMinimalBtn());
        travelPage.clickElement(travelPage.getIssueBtn());

        //fill the form
        travelFormingPage.fillField(travelFormingPage.getInsSurnameInp(), INS_SURNAME);
        travelFormingPage.fillField(travelFormingPage.getInsNameInp(), INS_NAME);
        travelFormingPage.fillDateField(travelFormingPage.getInsBirthDateInp(), INS_BIRTH);
        travelFormingPage.clickElement(travelFormingPage.getRFCitizenBtn());
        travelFormingPage.fillField(travelFormingPage.getPersonLastNameInp(), LAST_NAME);
        travelFormingPage.fillField(travelFormingPage.getPersonFirstNameInp(), FIRST_NAME);
        travelFormingPage.fillField(travelFormingPage.getPersonMiddleNameInp(), MIDDLE_NAME);
        travelFormingPage.fillDateField(travelFormingPage.getPersonBirthDateInp(), BIRTH);
        travelFormingPage.clickElement(travelFormingPage.getFemaleBtn());
        travelFormingPage.fillField(travelFormingPage.getPassportSeriesInp(), PASS_SERIES);
        travelFormingPage.fillField(travelFormingPage.getPassportNumberInp(), PASS_NUMBER);
        travelFormingPage.fillDateField(travelFormingPage.getDocumentDateInp(), PASS_DATE);
        travelFormingPage.fillField(travelFormingPage.getDocumentIssueInp(), PASS_ISSUE);

        //assert input values
        assertEquals(INS_SURNAME, travelFormingPage.getInsSurnameInp().getAttribute("value"), String.format("Expected insurance surname %s is different", INS_SURNAME));
        assertEquals(INS_NAME, travelFormingPage.getInsNameInp().getAttribute("value"), String.format("Expected insurance name %s is different", INS_NAME));
        assertEquals(INS_BIRTH, travelFormingPage.getInsBirthDateInp().getAttribute("value"), String.format("Expected insurance birth date %s is different", INS_BIRTH));
        assertEquals(LAST_NAME, travelFormingPage.getPersonLastNameInp().getAttribute("value"), String.format("Expected last name %s is different", LAST_NAME));
        assertEquals(FIRST_NAME, travelFormingPage.getPersonFirstNameInp().getAttribute("value"), String.format("Expected first name %s is different", FIRST_NAME));
        assertEquals(MIDDLE_NAME, travelFormingPage.getPersonMiddleNameInp().getAttribute("value"), String.format("Expected middle name %s is different", MIDDLE_NAME));
        assertEquals(BIRTH, travelFormingPage.getPersonBirthDateInp().getAttribute("value"), String.format("Expected birth date %s is different", BIRTH));
        assertEquals(PASS_SERIES, travelFormingPage.getPassportSeriesInp().getAttribute("value"), String.format("Expected passport series %s is different", PASS_SERIES));
        assertEquals(PASS_NUMBER, travelFormingPage.getPassportNumberInp().getAttribute("value"), String.format("Expected passport number %s is different", PASS_NUMBER));
        assertEquals(PASS_DATE, travelFormingPage.getDocumentDateInp().getAttribute("value"), String.format("Expected passport date %s is different", PASS_DATE));
        assertEquals(PASS_ISSUE, travelFormingPage.getDocumentIssueInp().getAttribute("value"), String.format("Expected passport issue %s is different", PASS_ISSUE));

        //submit button to continue
        travelFormingPage.clickElement(travelFormingPage.getContinueBtn());

        //check if not validated fields are present
        travelFormingPage.isAllFieldsValidated();

    }


}
