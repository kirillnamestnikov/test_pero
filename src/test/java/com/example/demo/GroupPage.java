package com.example.demo;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

// page_url = https://vk.com/club225299895
public class GroupPage {
    private SelenideElement name = $x("//h1[@class='page_name']");

    public GroupPage checkName(){
        name.shouldBe(visible.because("На странице с сообществом должно отображаться его имя")
        ).shouldHave(text("Test public for test"));
        return this;
    }
}