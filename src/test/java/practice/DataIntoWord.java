package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DataIntoWord {

	public static void main(String[] args) throws IOException {

		Properties p=new Properties();
		p.setProperty("username","admin");
		p.setProperty("password","manager");
		p.setProperty("url","https://demo.actitime.com/");
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/commondata2.properties");
		p.store(fos,"commondata");
		//fos.close();
		
	}

}
