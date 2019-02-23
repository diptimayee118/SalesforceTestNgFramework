import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Commonmethods {
	
	public static WebDriver driver;
	
	
   public  Commonmethods(WebDriver driver){
		
		this.driver=driver;

}
   
    public void selectAppMenu(){
    	
    	String  appMenuExpected= "BPM Configuration";
    	WebElement appMenuCurrent = driver.findElement(By.xpath("//div[@title='App Menu']/div/span"));
    	String appMenuCurrentText=appMenuCurrent.getText();
    	System.out.println("Current app Selectd as :" + appMenuCurrentText);
    	
    	if(appMenuCurrentText.equalsIgnoreCase(appMenuExpected)){
    		
    		System.out.println("I am already on :"+appMenuExpected +"Page");
    	}
    	else{
    		
    		selectAppfromDropdown();
    		
    	}
    	
    	
    }
    
    public void selectAppfromDropdown(){
    	
    	String  appMenuExpected= "BPM Configuration";
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