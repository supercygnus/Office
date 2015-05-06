package office.yueyiqiu.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date d = null;
//		try {
//			d=dateFormat.parse("2014-01-09");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(d);
		
		
//		Date d=new Date();
//		
//		int year=d.getYear()+1900;
//		int month=d.getMonth()+1;
//		int date=d.getDate();
//		int hour=d.getHours();
//		int minute=d.getMinutes();
//		int sec=d.getSeconds();
//		
//		String strMonth=month<10?"0"+month:""+month;
//		String strDate=date<10?"0"+date:""+date;
//		String strHour=hour<10?"0"+hour:""+hour;
//		String strMin=minute<10?"0"+minute:""+minute;
//		String strSec=sec<10?"0"+sec:""+sec;
//		
//		System.out.println(year);
//		System.out.println(month);
//		System.out.println(date);
//		System.out.println(hour);
//		System.out.println(minute);
//		System.out.println(sec);
//		
//		System.out.println(strMonth);
//		System.out.println(strDate);
//		System.out.println(strHour);
//		System.out.println(strMin);
//		System.out.println(strSec);
		
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//int ptr=br.readLine();
		
		for(int i=1;i<=4;i++){
			for(int j=1;j<=i;j++)
				System.out.print("*");
			System.out.println();	
		}
		
		for(int k=4-1;k>=1;k--){
			for(int l=0;l<k;l++)
				System.out.print("*");
			System.out.println();	
		}
		
		
		
		
	}

}
