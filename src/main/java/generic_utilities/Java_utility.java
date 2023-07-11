package generic_utilities;

import java.sql.Date;
import java.util.Random;

public class Java_utility {
	
	public int randomNumber() {
		Random r=new Random();
		int ranNum = r.nextInt(1000);
		return ranNum;
	}
	
	

}
