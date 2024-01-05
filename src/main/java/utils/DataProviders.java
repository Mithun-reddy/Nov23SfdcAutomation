package utils;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider
	public String[][] loginTestData(){
		// to read file
		return new String[][] {{"email1@gmail.com","1234"},{"email2@gmail.com","1234"}, {"email3@gmail.com","1234"}};
	}
	
	@DataProvider
	public String[] accountsTestData(){
		// to read file
		return new String[] {"acc1", "acc2"};
	}

}
