package windowhandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Handlewindow1 {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\\\Selenium setup\\\\chromedriver_win32\\\\chromedriver.exe");
	 RemoteWebDriver d=new ChromeDriver();
	 
	 d.get("http://demo.automationtesting.in/Windows.html");
	 d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 d.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
	 String parent =d.getWindowHandle();

	 d.findElement(By.xpath("//*[@id=\"Seperate\"]/button")).click();
	 Set<String> s =d.getWindowHandles();
	 for (String s1 : s) {
		 if(!parent.equals(s1))
		 {
			 d.switchTo().window(s1);
	    	  d.findElement(By.xpath("//*[@id=\"container\"]/header/div/div/div[2]/ul/li[3]/a")).click();
	    	  d.switchTo().window(parent);
		 }
		
	}
}
}
