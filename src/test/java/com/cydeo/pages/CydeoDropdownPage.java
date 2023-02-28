package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class CydeoDropdownPage extends PageBase {

    @FindBy(id = "month")
    private WebElement monthDropdown;

    public static List<String> getMonthDropdown() {
        CydeoDropdownPage cydeoDropdownPage = new CydeoDropdownPage();
        Select select = new Select(cydeoDropdownPage.monthDropdown);
        return select.getOptions().stream().map(f -> f.getText()).collect(Collectors.toList());
    }

    // Overloaded method
    public static List<String> getMonthDropdown(WebElement monthDropdown) {
        Select select = new Select(monthDropdown);
        return select.getOptions().stream().map(f -> f.getText()).collect(Collectors.toList());
    }
}
/**
 Although we can make monthDropdown variable as a static and access it from our static method directly, without need
 to instantiate a class and call it though object, we will not do it in this case.
 Because for the implementation of POM design pattern we need to initialize our driver instance with the object of
 this class. Otherwise, POM design pattern will be broken and we will not be able to locate web element.
 Since the web element will be located by using instance of this class which is initialized with driver instance,
 if we do not have object of this class created we will get NullPointerException.
 */