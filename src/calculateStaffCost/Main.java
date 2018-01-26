package calculateStaffCost;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	private static HashMap<String, Float> map_of_person = new HashMap<String, Float>();
	public static void main(String[] args) throws IOException {
		
		String file = "D:\\Sutasa\\Documents\\grade3\\ข้อสอบฝึกงาน\\1.working_time.log";
		Float moneyPerHour = 290f/8f ;
		
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String strline;
		boolean no_have_name = true;
		
		while ((strline = buffReader.readLine()) != null) {
			String name = splitString(0, strline);
            if(map_of_person.isEmpty()){
                map_of_person.put(name, 0f);
            }else {
                for (String map_name : map_of_person.keySet()) {
                    if(map_name .equals(name)){ no_have_name = false; }
                }
                if(no_have_name){
                    map_of_person.put(name, 0f);
                }
            }
						
			Person person = new Person(splitString(0,strline), splitString(1,strline),splitString(2,strline),splitString(3,strline),splitString(4,strline), moneyPerHour);		
			float money = person.calculate();
			
			for (String map_name : map_of_person.keySet()) {
                if(map_name.equals(name)){
                    Float set_money = map_of_person.get(map_name) + money;
                    map_of_person.replace(map_name, set_money);
                }
            }
		
		}
		 System.out.println();
         System.out.println("----รวมรายได้ของแต่ละคน----");
         for (String map_name : map_of_person.keySet()) {
             System.out.printf("%s ได้เงิน %.2f บาท", map_name, map_of_person.get(map_name));
             System.out.println();
         }
	}
	
	public static String splitString(int state, String strline) {
		String[] splitstrline = strline.split("\\|");
		String data = null ;
		int i=0 ;
		
		for(String string : splitstrline) {
			if(state == 0 && i == 0) {
				data = string ;
			}
			if(state == 1 && i == 1) {
				data = string ;
			}
			if(state == 2 && i == 2) {
				data = string ;
			}
			if(state == 3 && i == 3) {
				data = string ;
			}
			if(state == 4 && i == 4) {
				data = string ;
			}
			i++;
		}
		return data;		
	}
}


