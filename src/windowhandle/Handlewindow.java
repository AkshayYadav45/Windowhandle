package windowhandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Handlewindow {
public static void main(String[] args)  {
	
	System.setProperty("webdriver.chrome.driver","D:\\Selenium setup\\chromedriver_win32\\chromedriver.exe");
	 RemoteWebDriver d=new ChromeDriver();
	 d.get("http://demo.automationtesting.in/Windows.html");
	 d.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[1]/a")).click();
	 String parent =d.getWindowHandle();
	 d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 d.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
	 Set<String> s=d.getWindowHandles();
	 for (String s1 : s)
	 {
      if(!parent.equals(s1))
      {
    	  d.switchTo().window(s1);
    	  System.out.println(s1);
    	  d.findElement(By.xpath("//*[@id=\"container\"]/header/div/div/div[2]/ul/li[3]/a")).click();
    	 
    	 // d.switchTo().defaultContent();
    
      }
	}
	 d.switchTo().window(parent);
	 
	//hi
	
}
	
}
