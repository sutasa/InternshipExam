package calculateStaffCost;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculate {
	private final Float  moneyPerHourNormal;
	private Float ot ;
	private Float nonOT ;
		
	public Calculate(Float moneyPerHour) {
		this.moneyPerHourNormal = moneyPerHour;
	}
		
	public Float getCost(String name, String startDate, String startTime, String endTime) {
		float money = 0f ;
		String textDate = getDate(startDate);
		if(textDate.equals("Sat") || textDate.equals("Sun")) {
			nonOT = 1.5f;
			ot = 2f ;
		}else {
			nonOT = 1f;
			ot = 1.5f;
		}
		
		String twoTime = getHour(startTime,endTime);
		int i = 0 ;
		String workinghour = "";
		String hourOT = "";
		String[] splitTime = twoTime.split(":");
		
		for(String string : splitTime) {
			if(i == 0) {
				workinghour = string;
			}
			if(i == 1) {
				hourOT = string ;
			}
			i++;
		}
		
		money = (Float.parseFloat(workinghour)* moneyPerHourNormal * nonOT) + (Float.parseFloat(hourOT) * moneyPerHourNormal * ot);
		System.out.printf("%s ชั่วโมงการทำงาน  %.2f ชม. ทำ OT %.2f ได้ค่าแรง %.2f บาท", name , Float.parseFloat(workinghour), Float.parseFloat(hourOT),money);
		System.out.println();
		return null ;
	}

	public String getDate(String startDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String textDate = null;
		
		try {
			Date date = simpleDateFormat.parse(startDate);
			textDate = date.toString();
			textDate = textDate.substring(0,3);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return textDate;
	}
	
	public String getHour(String startTime, String endTime) {
		float workinghour = 0f;
		float hourOT = 0f;
		float lateMinute = 0f;
		int i = 0 ;
		
		String hourStart = "" ;
		String minuteStart = "" ;
				
		String[] splitTime = startTime.split(":");
		for(String string : splitTime) {
			if(i == 0) {
				hourStart = string;
			}
			if(i == 1) {
				minuteStart = string;
			}
			i++;
		}
		i = 0 ;
		String hourEnd = "" ;
		String minuteEnd = "" ;
				
		splitTime = endTime.split(":");
		for(String string : splitTime) {
			if(i == 0) {
				hourEnd = string;
			}
			if(i == 1) {
				minuteEnd = string;
			}
			i++;
		}
		
		if((Float.parseFloat(hourStart) * 60 + Float.parseFloat(minuteStart)) > (8f * 60 + 5f)) {
			lateMinute = (Float.parseFloat(hourStart) * 60 + Float.parseFloat(minuteStart)) - (8f * 60 + 5f);
		}
		if((Float.parseFloat(hourEnd) * 60 + Float.parseFloat(minuteEnd))> (17f * 60 + 30f)) {
			workinghour = (17f * 60) - (8f * 60);
			hourOT = (Float.parseFloat(hourEnd) * 60 + Float.parseFloat(minuteEnd)) - (17f * 60 + 30f);
		}else {
			workinghour = (17f * 60) - (8f * 60);
		}
		
		workinghour = workinghour - lateMinute ;
		workinghour = minuteTohour(workinghour);
		hourOT = minuteTohour(hourOT);
		
		return String.valueOf(workinghour);
	}

	public Float minuteTohour(float workinghour) {
		float hour = 0f ;
		int fullHour = 0 ;
		
		fullHour = (int)workinghour/60 ;
		hour = workinghour - fullHour * 60 ;
		hour = (float)fullHour + workinghour/100;
		return hour;
	}

}
