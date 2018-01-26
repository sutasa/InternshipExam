package calculateStaffCost;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String file = "D:\\Sutasa\\Documents\\grade3\\ข้อสอบฝึกงาน\\1.working_time.log";
		Float moneyPerHour = 290f/8f ;
		
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(
					    new FileInputStream(file), "UTF8"));
		
		String strline;
		while ((strline = buffReader.readLine()) != null) {
						
			Person person = new Person(splitString(0,strline), splitString(1,strline),splitString(2,strline),splitString(3,strline),splitString(4,strline), moneyPerHour);		
			person.calculate();
		
		}
		
	}
	
	public static String splitString(int state, String strline) {
		String[] splitstrline = strline.split("\\|");
		String data = null ;
		int i=0 ;
		
		for(String string : splitstrline) {
			if(state == 0 && i == 0) {
				//System.out.println(string);
				data = string ;
				//break;
			}
			if(state == 1 && i == 1) {
				//System.out.println(string);
				data = string ;
				//break;
			}
			if(state == 2 && i == 2) {
				//System.out.println(string);
				data = string ;
				//break;
			}
			if(state == 3 && i == 3) {
				data = string ;
				//break;
			}
			if(state == 4 && i == 4) {
				//System.out.println(string);
				data = string ;
				//break;
			}
			i++;
		}
		return data;		
	}
}


