package calculateStaffCost;

public class Person {
	
	String name;
	String startDate;
	String startTime;
	String endDate;
	String endTime;
	Float moneyPerHour;
	
	public Person(String name, String startDate, String startTime, String endDate, String endTime, float moneyPerHour) {
	
		this.name = name;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.moneyPerHour = moneyPerHour;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public Float getMoneyPerHour() {
		return moneyPerHour;
	}

	public void setMoneyPerHour(Float moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}

	public float calculate() {
		
		if( startDate == null || startTime == null || endDate == null || endTime == null) {
			System.out.println(name + " ข้อมูลไม่ถูกต้อง");
		}else {
			Calculate cal = new Calculate(moneyPerHour);
			float money = cal.getCost(name,startDate,startTime,endTime);
			return money ;
		}	
		return 0 ;
	}
	

}
