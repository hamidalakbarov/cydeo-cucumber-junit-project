package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikipediaHomePage extends PageBase{

    @FindBy(css = "input[id='searchInput']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[.='Search']")
    public WebElement searchButton;

}
