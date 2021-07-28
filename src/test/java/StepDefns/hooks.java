package StepDefns;

import cucumber.api.java.*;

public class hooks {

	@Before("@tag2")
	public void setUp() {
		System.out.println("In SetUp Process now");
	}

	@After("@tag2")
	public void tearDown() {
		System.out.println("In teardown Process now");
	}

}
