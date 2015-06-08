package p1;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class Test_prog 
{
	{
		System.setProperty("atu.reporter.config", "E:\\betasoft6\\Myproj\\atu.properties");
	}
	   
    WebDriver driver;
	@Test
	@Parameters({"browser"})
	public void run_method(String br) throws Exception
	{
		if(br.matches("ie"))
		{
		
		System.setProperty("webdriver.ie.driver","c:\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		}
		if(br.matches("firefox"))
		{
			
			driver=new FirefoxDriver();
		}
		
		Home hm=new Home(driver);
		hm.validate_HomeLinks();
		 
		hm.signup();
		hm.login();
		
		Compose cmp=new Compose(driver);
		cmp.sendmail();
		cmp.signout();
		
	}
}
