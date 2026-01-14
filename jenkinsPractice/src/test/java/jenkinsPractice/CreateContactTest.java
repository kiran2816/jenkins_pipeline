package jenkinsPractice;

import org.testng.annotations.Test;

import com.practice.configue_utility.BaseClass;

public class CreateContactTest extends BaseClass{
	@Test(groups="ST")
	public void createContact() {
		System.out.println("contact created");
	}
	
	@Test(groups="RT")
	public void createOrgWthDate() {
		System.out.println("conatact created with date");
	}
}
