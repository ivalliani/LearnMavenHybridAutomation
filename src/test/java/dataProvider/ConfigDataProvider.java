package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
			
			
		} catch (Exception e) {
			System.out.println("Exception Is "+e.getMessage());
		}
	}
	
	public String getIEPath()
	{
		String url = pro.getProperty("IEPath");
		
		return url;
	}
	
	public String getChromePath()
	{
		String url = pro.getProperty("chromePath");
		
		return url;
	}
	
	public String getApplicationUrl()
	{
		String url = pro.getProperty("url");
		
		//String url = "http://demo.avactis.com/5.0.1/";
		
		return url;
	}
	
	public String getusername()
	{
	String usernames=pro.getProperty("usernames");
	
	return usernames;

}
	
	public String getpassword()
	{
	String passwords=pro.getProperty("passwords");
	
	return passwords;

}
}
