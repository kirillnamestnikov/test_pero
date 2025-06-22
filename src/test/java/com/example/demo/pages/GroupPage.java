package com.example.demo.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

// page_url = https://vk.com/club225299895
public class GroupPage {
    private SelenideElement name = $x("//h1[@class='page_name']");
    private SelenideElement productPrice = $x("//div[contains(@class, 'EcommPreviewProductCardProductPrice__main')]");

    public GroupPage checkName(){
        name.shouldBe(visible.because("На странице с сообществом должно отображаться его имя")
        ).shouldHave(text("Test public for test"));
        return this;
    }

    public GroupPage checkPrice(){
        productPrice.shouldBe(visible.because("На странице с сообществом должен быть товар с ценой")
        ).shouldHave(text("300"));
        return this;
    }

    public int getPriceCount(){
        String text = productPrice.getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }
}