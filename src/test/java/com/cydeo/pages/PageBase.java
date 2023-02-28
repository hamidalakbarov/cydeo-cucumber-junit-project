package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    /*
    Super / parent class of all pages that were created by using POM design pattern
     */
    public PageBase() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
