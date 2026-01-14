package jenkinsPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOrgTest  {
	@Test(groups="ST")
	public void createOrg() {
		Assert.assertEquals(false, true);
		System.out.println("orgnization created");
	}
	
	@Test(groups="RT")
	public void createOrgWthDate() {
		System.out.println("orgnization created with date");
	}
}
