package com.flipkart.qa.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.flipkart.qa.util.TestUtil;
import com.flipkart.qa.util.WebEventListener;

public class TestBase {
public static	WebDriver driver;
public static Properties prop;
public static FileInputStream fi;
public static EventFiringWebDriver e_driver;
public static WebEventListener eventlistener;
public static String port=null;
public TestBase(){
		 prop= new Properties();
		 
		
		try {
			fi = new FileInputStream("C:\\Users\\soura\\eclipse-workspace\\FlipkartTest\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//@Parameters("port")
	public  static void  initialization() throws MalformedURLException {
		String browsername= prop.getProperty("browser");
		if (browsername.equals("chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soura\\eclipse-workspace\\FlipkartTest\\WebdriverDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\soura\\eclipse-workspace\\FlipkartTest\\WebdriverDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		else if(browsername.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\soura\\eclipse-workspace\\FlipkartTest\\WebdriverDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		
			 
		}
		
	/*	if (port.equalsIgnoreCase("4401")) {
		DesiredCapabilities cap= DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.LINUX);
		ChromeOptions option= new ChromeOptions();
		option.merge(cap);
		URL url=new URL("http://192.168.137.1:4444/wd/hub");
		 driver= new RemoteWebDriver(url, option);
		}
		else if (prop.getProperty("port").equalsIgnoreCase(port)) {
			DesiredCapabilities cap= DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			ChromeOptions option= new ChromeOptions();
			option.merge(cap);
			URL url=new URL("http://192.168.137.1:4444/wd/hub");
			 driver= new RemoteWebDriver(url, option);
			}
			
		
		e_driver =new EventFiringWebDriver(driver);
		eventlistener= new WebEventListener();
		e_driver.register(eventlistener);
		driver= e_driver;
	

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));	
		}
	
		*/
	}
	}


