package elementsAndActions;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.Constants;
import base.TestBase;

public class HomePage extends TestBase {

	private By revenueCalculatorOption = By.xpath("//div[text()='Revenue Calculator']");

	private By sliderSection = By
			.xpath("//p[text()='RPM and CCM Programs - CPT code reimbursement (Non-Facility Rates)']");

	private By sliderOption = By.xpath("//input[@type='range']");

	private By inputTextBox = By.xpath("//input[@type='number']");

	private By checkBoxOptions = By.xpath("//input[@type='checkbox']");

	private By totalRecurringReimbursement = By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[3]/p[2]");

	public void clickRevenueCalculatorOption() {
		WebElement element = driver.findElement(revenueCalculatorOption);
		element.click();
	}

	public void scrollingToSliderSection() {
		WebElement element = driver.findElement(sliderSection);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public int defaultValueOnTextBox() {
		WebElement textBox = driver.findElement(inputTextBox);
		return Integer.parseInt(textBox.getAttribute("value"));
	}

	public int enterValueOnTextBox() {
		WebElement textBox = driver.findElement(inputTextBox);
		StringSelection selection = new StringSelection(String.valueOf(Constants.targetSliderValueInTextBox));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Actions actions = new Actions(driver);
		actions.click(textBox).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
				.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		return Integer.parseInt(textBox.getAttribute("value"));
	}

	public int sliderMoveToTargetPosition() {
		WebElement element = driver.findElement(sliderOption);

		int defaultSliderPosition = Integer.parseInt(element.getAttribute("value"));

		for (int i = 0; i < (Constants.targetSliderPosition - defaultSliderPosition); i++) {
			element.sendKeys(Keys.ARROW_RIGHT);
		}

		return Integer.parseInt(element.getAttribute("value"));
	}

	public void clickCheckBoxOptions() {
		List<WebElement> checkBox = driver.findElements(checkBoxOptions);
		for (int i = 0; i < checkBox.size(); i++) {
			if (i == 0 || i == 1 || i == 2 || i == 7) {
				checkBox.get(i).click();
			}
		}

	}

	public int getTotalRecurringReimbursement() {
		WebElement element = driver.findElement(totalRecurringReimbursement);
		String value = element.getText();
		String[] parts = value.split("(?<=\\$)(?=\\d)");
		String numericValue = parts[1];
		return Integer.parseInt(numericValue);
	}
}
