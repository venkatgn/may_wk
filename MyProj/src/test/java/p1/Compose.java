package p1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


public class Compose 
{
		
  
	
  WebDriver driver;
  public Compose(WebDriver driver)
  {
	  this.driver=driver;
  }
  public void sendmail() throws Exception
  {
	  Thread.sleep(6000);
	  Reporter.log("==========Compose mail========");
	  driver.findElement(By.xpath("//*[@class='composeicon']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.id("to")).sendKeys("abcd@gmail.com");
	  driver.findElement(By.id("Subj")).sendKeys("test mail");
	  driver.findElement(By.name("Content")).sendKeys("this is test mail sample");
	  Thread.sleep(5000);  
	  Reporter.log("Test is passsed , send mail");
  }
  public void signout()
  {
	  driver.findElement(By.linkText("Sign Out")).click();
	  driver.close();
  }
  
}
