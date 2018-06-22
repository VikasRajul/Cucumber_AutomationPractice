package pages_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBaseClass {
	public static WebDriver driver;
	public Properties prop;
	
	public TestBaseClass()
	{
		prop = new Properties();
		try {
			FileInputStream IP = new FileInputStream("src/main/java/config/config");
			prop.load(IP);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
