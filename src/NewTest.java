import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	

	@BeforeClass 
	public void launchBrowser() {
		
		System.out.println("Launch Browser");
		
	}
	
	@BeforeMethod
	public void enterURL() {
		
	}
		
  @Test
  public void f() {
  }
}
