package StepDefns;

import cucumber.api.java.en.*;

public class StepDefFile {

	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Given("^some other precondition$")
	public void some_other_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^some other action$")
	public void some_other_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^yet another action$")
	public void yet_another_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Given("^I want to write a step with (.*)$")
	public void i_want_to_write_a_step_with_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("The Step Name is for:"+arg1);
	}

	/*@When("^I check for the (\\d+) in step$")*/
	@When("^I check for the (.*) in step$")
	public void i_check_for_the_in_step(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("The Check is for:"+arg1);
	}

	@Then("^I verify the success in step$")
	public void i_verify_the_success_in_step() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^I verify the Fail in step$")
	public void i_verify_the_Fail_in_step() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("^When I am with \"([^\"]*)\"$")
	public void when_I_am_with(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(arg1);
	}
	@Given("^I want to write a step with \"([^\"]*)\"$")
	public void i_want_to_write_a_step_with(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("in step for tag1 with passed parameter:"+arg1);
	    }

}
