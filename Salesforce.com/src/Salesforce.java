import org.testng.annotations.Test;
public class Salesforce extends SalesforceSelector{
	
	
	ISalesforceSelector sfSelector = new SalesforceSelector();
	
	
	
	@Test
    public void SalesForceTest() throws Exception {
		sfSelector.Login("sandbox");
		sfSelector.selectApplication("Sales");
		
		sfSelector.showAllTabClickingPlus();
		
        
	}
	
	
	
}