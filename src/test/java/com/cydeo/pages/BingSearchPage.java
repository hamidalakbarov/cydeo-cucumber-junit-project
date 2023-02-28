package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingSearchPage {

    // Initializing driver instance with the object of this class
    public BingSearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Locating web elements
    @FindBy(name = "q")
    public WebElement bingSearchBox;
}
