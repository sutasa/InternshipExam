package calculateStaffCost;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ManageFile {
	private HashMap<String, Float> person = new HashMap<String, Float>();
	private FileReader fileperson = null ;
	private BufferedReader buffReader = null ;
	private Calculate calculate ;
	
	public ManageFile(String file, Float moneyPerHour) {
		
		person.clear();
		readFile(file);
		calculate = new Calculate(moneyPerHour);
		
	}
	
	public void readFile(String file) {
		try {
			fileperson = new FileReader(file);
			buffReader = new BufferedReader(new FileReader(file));
			String strline ;
			boolean noName = true ;
			
			while ((strline = buffReader.readLine()) != null) {
				String name = splitString(0,strline);
				
				if(person.isEmpty()) {
					person.put(name, 0f);
				}else {
					for(String mapName : person.keySet()) {
						if(mapName.equals(name)) {
							noName = false ;
						}
					}
					if(noName) {
						person.put(name, 0f);
					}						
				}
			
				//Float money = calculate.getCost(name, splitString(1,strline),splitString(2,strline),splitString(4,strline));
				calculate.getCost(name, splitString(1,strline),splitString(2,strline),splitString(4,strline));
				//System.out.println(name);
				/*for(String mapName : person.keySet()) {
					if(mapName.equals(name)) {
						Float setMoney = person.get(mapName) + money ;
						person.replace(mapName, setMoney);
						System.out.println(name +  " " + person.get(mapName));
					}
				}*/
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(buffReader != null) {
				try {
					buffReader.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(fileperson != null) {
				try {
					fileperson.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String splitString(int state, String strline) {
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
