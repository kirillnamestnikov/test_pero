package com.example.demo.tests;

import com.codeborne.selenide.Configuration;
import com.example.demo.pages.GroupPage;
import com.example.demo.tags.GroupTag;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class GroupPageTest {
    private GroupPage groupPage = new GroupPage();
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895");
    }

    @ParameterizedTest(name = "Проверка на то, что цена положительная")
    @ValueSource(ints = {0, 100, 200})
    @GroupTag
    public void testInfo(int price){
        groupPage.checkName();
        groupPage.checkPrice();
        int actualPrice = groupPage.getPriceCount();
        assertTrue(actualPrice > price, String
                .format("Цена товара должна быть больше %d",
                        price)
        );
    }
}
