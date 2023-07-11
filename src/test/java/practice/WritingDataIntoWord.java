package practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class WritingDataIntoWord {

	public static void main(String[] args) throws Throwable {

		Properties p=new Properties();
		p.setProperty("url"," https://demo.actitime.com/login.do");
		p.setProperty("username","admin");
		p.setProperty("password","manager");
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/commondata2.properties");
		p.store(fos,"common data");
		fos.close();
	}

}
