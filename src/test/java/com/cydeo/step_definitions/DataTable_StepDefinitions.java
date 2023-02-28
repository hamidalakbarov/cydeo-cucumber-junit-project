package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DataTable_StepDefinitions {

    @When("user provides favorite list of favorite pets")
    public void user_provides_favorite_list_of_favorite_pets() {
        System.out.println("User enters favorite pets...");
    }

    @Then("user should see pets as a below list")
    public void user_should_see_pets_as_a_below_list(List<String> pets) {
        System.out.println(pets);
        pets.forEach(c -> System.out.println(c));
    }

    @Then("officer is able to see any data he wants")
    public void officer_is_able_to_see_any_data_he_wants(Map<String, String> contact) {
        System.out.println("contact.keySet() = " + contact.keySet());
        System.out.println("contact.values() = " + contact.values());
        for (Map.Entry<String, String> stringStringEntry : contact.entrySet()) {
            System.out.println("stringStringEntry.getKey() = " + stringStringEntry.getKey());
            System.out.println("stringStringEntry.getValue() = " + stringStringEntry.getValue());
        }
    }

}
