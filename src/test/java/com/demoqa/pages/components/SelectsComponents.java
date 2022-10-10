package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelectsComponents {
    public SelectsComponents setValueInTheSelect(String value) {
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
}
