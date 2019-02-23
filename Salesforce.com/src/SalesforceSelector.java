import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SalesforceSelector implements ISalesforceSelector{
	public WebDriver driver;
	public Properties properties;// = new Properties();
	public SalesforceSelector() {
		 properties = new Properties();
		try {
			properties.load(new FileReader(new File("salesforcetestdata.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String exePath = "C:\\Debasis\\Testing tools\\chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver", exePath);
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	@Override
	public void selectApplication(String appMenuExpected) {
	
    	WebElement appMenuCurrent = driver.findElement(By.xpath("//div[@title='App Menu']/div/span"));
    	String appMenuCurrentText=appMenuCurrent.getText();
    	System.out.println("Current app Selectd as :" + appMenuCurrentText);
    	
    	if(appMenuCurrentText.equalsIgnoreCase(appMenuExpected)){
    		
    		System.out.println("I am already on :"+appMenuExpected +"Page");
    	}
    	else{
    		
    
        	driver.findElement(By.xpath("//div[@id='tsidButton']")).click();
    		List<WebElement> appList=driver.findElements(By.xpath("//div[@class='menuButtonMenu menuWidthExtended']/div/a"));
    		
    		for(int i=0;i<appList.size();i++){
    			
    			if((appList.get(i).getText()).equals(appMenuExpected)){
    				
    				
    				appList.get(i).click();
    				break;
    		
    	          }
    		}
    	
    }
		
	}
	
	

	@Override
	public void Login(String environment) {
		          
		
		if(environment.equals("sandbox")){			
			 driver.get(properties.getProperty("URL"));	
			 WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement userElement = driver.findElement(By.xpath("//input[@id='username']"));
			userElement.sendKeys(properties.getProperty("username"));
	         passwordElement.sendKeys(properties.getProperty("password"));        
			
		}
		else if(environment.equals("production")){			
			 driver.get(properties.getProperty("UrlProd"));
			 WebElement passwordElement = driver.findElement(By.xpath("//input[@id='prodPassword']"));
				WebElement userElement = driver.findElement(By.xpath("//input[@id='prodUsername']"));
	         userElement.sendKeys(properties.getProperty("prodUsername"));
	         passwordElement.sendKeys(properties.getProperty("prodPassword")); 
		}
		driver.findElement(By.xpath("//input[@id='Login']")).click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	}
	
	public void showAllTabClickingPlus(){
	
	
	driver.findElement(By.xpath("//img[contains(@title,'All Tabs')]")).click();
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
