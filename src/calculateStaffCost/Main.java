package calculateStaffCost;
import calculateStaffCost.ManageFile;

public class Main {
	private static String file = "D:\\Sutasa\\Documents\\grade3\\ข้อสอบฝึกงาน\\1.working_time.log";
	private static Float moneyPerHour = 290f/8f ;
	private static ManageFile manageFile ;
	
	public static void main(String[] args) {
		manageFile = new ManageFile(file,moneyPerHour);
	}
}
