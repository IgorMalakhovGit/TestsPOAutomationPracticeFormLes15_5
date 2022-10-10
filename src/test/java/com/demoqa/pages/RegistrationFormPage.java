package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;
import com.demoqa.pages.components.SelectsComponents;
import com.demoqa.pages.components.UploadFileComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private UploadFileComponent uploadFileComponent = new UploadFileComponent();
    private SelectsComponents selectsComponents = new SelectsComponents();
    private SelenideElement closeModal = $("#closeLargeModal");
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbiesInTheCheckbox(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadFile(String value) {
        uploadFileComponent.uploadFile(value);
        return this;

    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setStateOnTheSelect(String value) {
        $("#state").click();
        selectsComponents.setValueInTheSelect(value);
        return this;
    }

    public RegistrationFormPage setCityOnTheSelect(String value) {
        $("#city").click();
        selectsComponents.setValueInTheSelect(value);
        return this;
    }

    public RegistrationFormPage clickOnButtonSubmit() {
        $("#submit").click();
        return this;
    }


}
