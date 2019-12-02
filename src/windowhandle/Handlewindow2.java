package windowhandle;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Handlewindow2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\\\Selenium setup\\\\chromedriver_win32\\\\chromedriver.exe");
		RemoteWebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.get("http://demo.automationtesting.in/Windows.html");
		d.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		String parent =d.getWindowHandle();
		d.findElement(By.xpath("//*[@id=\"Multiple\"]/button")).click();
		d.switchTo().window(parent);
		ArrayList<String> alltab=new ArrayList<String>(d.getWindowHandles());
		String child1=d.switchTo().window(alltab.get(2)).getWindowHandle();
		String child2=d.switchTo().window(alltab.get(1)).getWindowHandle();
		d.switchTo().window(parent);
		d.switchTo().window(child1);
	}
	/*WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Windows.html");
	driver.findElement(By.xpath("//a/button[@class='btn btn-info']")).click();
	driver.manage().window().maximize();
	ArrayList<String> alltab=new ArrayList<String>(driver.getWindowHandles());
	
	driver.switchTo().window(alltab.get(0));*/

}




