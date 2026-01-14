package jenkinsPractice;

import org.testng.annotations.Test;

public class CreateContactTest {
	@Test(groups="ST")
	public void createContact() {
		System.out.println("contact created");
	}
	
	@Test(groups="RT")
	public void createOrgWthDate() {
		System.out.println("conatact created with date");
	}
}
