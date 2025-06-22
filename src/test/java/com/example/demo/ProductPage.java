package com.example.demo;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

// page_url = https://vk.com/club225299895?w=product-225299895_10044406
public class ProductPage {
    private final SelenideElement price = $x("//h2[@data-testid='market_item_page_price']");

    public ProductPage checkPrice(){
        price.shouldBe(visible.because("На странице с товаром должна быть цена")
                ).shouldHave(text("бесплатно"));
        return this;
    }
}
