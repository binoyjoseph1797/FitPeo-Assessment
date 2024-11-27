package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	protected static WebDriver driver;
	
	public void getDriver(String browserName) {

		if (browserName.equalsIgnoreCase(Constants.chromeBrowser)) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase(Constants.firefoxBrowser)) {
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase(Constants.edgeBrowser)) {
			driver = new EdgeDriver();
		} else {
			System.err.println(Constants.warningMessage);
			throw new IllegalArgumentException();
		}
	}
	
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	
	public void implicitlyWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
	}
	
	public void get()
	{
		driver.get(Constants.pageURL);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
}
