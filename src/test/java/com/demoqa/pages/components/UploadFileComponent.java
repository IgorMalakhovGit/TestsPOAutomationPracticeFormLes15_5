package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class UploadFileComponent {
    public UploadFileComponent uploadFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }
}
