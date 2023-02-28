package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    // Creating constructor to initialize driver instance with this object
    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Locating web element
    @FindBy(name = "q")
    public WebElement searchBox;
}
