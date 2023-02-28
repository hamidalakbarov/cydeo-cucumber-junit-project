package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikipediaResultPage extends PageBase{

    @FindBy(css = "h1#firstHeading")
    public WebElement mainHeader;

    @FindBy(className = "fn")
    public WebElement imageHeader;
}
