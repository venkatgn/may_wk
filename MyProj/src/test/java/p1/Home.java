package p1;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class Home 
{
	
	{
		System.setProperty("atu.reporter.config", "E:\\betasoft6\\Myproj\\atu.properties");
	}
  WebDriver driver;
  public Home(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  public void open_url()
  {
	  driver.manage().window().maximize();
	  driver.get("http://www.yahoomail.com");
  }
  public void validate_HomeLinks() throws Exception
  {
	   open_url();
	  Thread.sleep(5000);
	  String exlinks[]={"About Mail","Features","Get the App","Help"};
	  WebElement hmlink=driver.findElement(By.xpath("//*[@class='Fl(end) Mend(10px) Lts(-0.31em) Tren(os) Whs(nw) My(6px)']"));
	  List<WebElement> lst=hmlink.findElements(By.tagName("a"));
	  int cnt=0;
	  Reporter.log("===========Validating Links in Home Page===========");
	  for(WebElement lnk : lst)
	  {
		 if(exlinks[cnt].matches(lnk.getText().trim()))
			Reporter.log("Link is matching "+exlinks[cnt]);
		 else
			 Reporter.log("Link is NOT matching "+exlinks[cnt]);
		 
	  cnt++;	 
	  }	  	  
  }
  public void signup() throws Exception
  {
	  open_url();
	  Reporter.log("=============Account creation===============");
	  driver.findElement(By.id("login-signup")).click();
   	  driver.findElement(By.name("firstname")).sendKeys("abcd");
				
		
		
	  driver.findElement(By.xpath("//*[@class='country-code-arrow']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@data-code='91']")).click();
	  driver.findElement(By.id("mobile")).sendKeys("8767876789");
		
		//select value in drop down list
	  new Select(driver.findElement(By.id("month"))).selectByVisibleText("May");
	  new Select(driver.findElement(By.id("day"))).selectByVisibleText("20");
	  new Select(driver.findElement(By.id("year"))).selectByVisibleText("1987");
	  driver.findElement(By.id("male")).click();
  }
  public void login() throws Exception
  {
	  open_url();
	  Reporter.log("=================Login===============");
	  driver.findElement(By.name("username")).sendKeys("venkat123456a");
	  driver.findElement(By.name("passwd")).sendKeys("mq123456");
	  driver.findElement(By.name("signin")).click();
	  Reporter.log("Login is success");
	  
  }
	
}
