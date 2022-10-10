package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.components.ResultsModal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ResultsModal resultsModal = new ResultsModal();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Igor")
                .setLastName("Malakhov")
                .setEmail("Test@mail.test")
                .setGender("Male")
                .setNumber("1234567890")
                .setBirthDate("29", "July", "1991")
                .setSubjects("Arts")
                .setHobbiesInTheCheckbox("Reading");
        registrationFormPage.uploadFile("Img1_1Test.jpg")
                .setCurrentAddress("Test address ")
                .setStateOnTheSelect("Haryana")
                .setCityOnTheSelect("Panipat")
                .clickOnButtonSubmit();
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Igor" + " " + "Malakhov")
                .checkResult("Student Email", "Test@mail.test")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "29" + " " + "July,1991")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "Img1_1Test.jpg")
                .checkResult("Address", "Test" + " " + "address")
                .checkResult("State and City", "Haryana" + " " + "Panipat");


    }
}
