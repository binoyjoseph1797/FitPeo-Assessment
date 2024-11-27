package runner;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Constants;
import elementsAndActions.HomePage;

public class HomeRun extends HomePage {

	HomeRun page;

	@BeforeClass
	public void pageSetUp() {
		page = new HomeRun();

		page.getDriver("chrome");

		page.maximize();

		page.implicitlyWait();

		page.get();
	}

	@Test(priority = 1)
	public void getPageTitle() {
		String title = page.getTitle();
		System.out.println(title);
	}

	@Test(priority = 2)
	public void getPageUrl() {
		String currentUrl = page.getCurrentUrl();
		System.out.println(currentUrl);
	}

	@Test(priority = 3)
	public void verifyRevenueCalculatorOption() {
		page.clickRevenueCalculatorOption();
	}

	@Test(priority = 4)
	public void verifyscrollingToSliderSection() {
		page.scrollingToSliderSection();
	}

	@Test(priority = 5)
	public void verifyEnterValueOnTextBox() {
		int defaultValueOnTextBox = page.defaultValueOnTextBox();
		System.out.println("Default Value on TextBox Field is ::"+defaultValueOnTextBox);//200
		int enterValueOnTextBox = page.enterValueOnTextBox();
		Assert.assertEquals(enterValueOnTextBox,Constants.targetSliderValueInTextBox);
		System.out.println("After Entering the Value in the TextBox Field ::"+enterValueOnTextBox);// 560

	}

	@Test(priority = 6)
	public void verifySliderMoveToTargetPosition() {
		int currentValueOnTextBox = page.defaultValueOnTextBox();
		System.out.println("Current Value on TextBox Field is ::"+currentValueOnTextBox);//560
		int targetPosition = page.sliderMoveToTargetPosition();
		Assert.assertEquals(targetPosition,Constants.targetSliderPosition);
		System.out.println("After Moving the Slider to target Position ::"+targetPosition);// 820
	}

	@Test(priority = 7)
	public void verifyCheckBoxOptions()
	{
		page.clickCheckBoxOptions();
	}
	
	@Test(priority = 8)
	public void verifyTotalRecurringReimbursement()
	{
		int totalRecurringReimbursement = page.getTotalRecurringReimbursement();
		Assert.assertEquals(totalRecurringReimbursement,Constants.expectedTotalRecurringReimbursement);
		System.out.println("Total Recurring Reimbursement for all Patients Per Month:: "+totalRecurringReimbursement);
	}
}
