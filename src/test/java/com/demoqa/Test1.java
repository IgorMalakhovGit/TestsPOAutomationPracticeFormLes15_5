package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

public class Test1 {
    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true; //for test for debag
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Igor");
        $("#lastName").setValue("Malakhov");
        $("#userEmail").setValue("test@mail.com");
        $("#userNumber").setValue("7779379992");
        $("#currentAddress").setValue("test Adress");
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/Img1Test.jpg"));
        $("#genterWrapper").$(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--029:not(.react-datepicker__day--selected").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#state").hover().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Igor Malakhov"),
                text("test@mail.com"),
                text("7779379992"),
                text("test Adress"),
                text("male"),
                text("29 July,1991"),
                text("English"),
                text("Reading"),
                text("Img1Test.jpg"),
                text("test Adress"),
                text("NCR Noida"));
        $("#closeLargeModal").click();
    }
}
