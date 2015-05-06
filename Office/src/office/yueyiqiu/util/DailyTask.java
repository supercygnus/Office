package office.yueyiqiu.util;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.opensymphony.xwork2.ActionContext;



public class DailyTask extends TimerTask{
	
	
	private SearchDB searchDB;
	private InsertDB insertDB;
	
	
	
	/**
	 * @return the searchDB
	 */
	public SearchDB getSearchDB() {
		return searchDB;
	}



	/**
	 * @param searchDB the searchDB to set
	 */
	public void setSearchDB(SearchDB searchDB) {
		this.searchDB = searchDB;
	}



	/**
	 * @return the insertDB
	 */
	public InsertDB getInsertDB() {
		return insertDB;
	}



	/**
	 * @param insertDB the insertDB to set
	 */
	public void setInsertDB(InsertDB insertDB) {
		this.insertDB = insertDB;
	}



	@Override
	public void run() {
		
		//int usernumber=(int) ActionContext.getContext().getSession().get("user");
		
		Date d=new Date();
		
		String strmonth;
		String strdate;
		
		int year=d.getYear()+1900;
		int month=d.getMonth()+1;
		int day=d.getDate();
		
		if(month<10)
			strmonth="0"+month;
		else
			strmonth=month+"";
		
		if(day<10)
			strdate="0"+day;
		else
			strdate=day+"";
		
		String sql="select * from oa_attinfo where "+
				   "date_format(att_time,'%Y-%m-%d')='"+year+"-"+strmonth+"-"+strdate+"'";
		
		//String sqlinsert="insert into oa_attinfo (att_user,att_time) values("+usernumber+","+d+")";
		String sqlinsert="insert into oa_attinfo(att_user) select user_number from oa_user";
		List list=this.searchDB.getArrayList(sql, -1, -1);
		
		if(list.size()==0){
			this.insertDB.update(sqlinsert);
		}
		
		System.out.println("daily task");	
		
	}
	
	
	public static void main(String[] args){
		
		Date d=new Date();
		System.out.println(d.getYear()+1900);
		System.out.println(d.getMonth());
		System.out.println(d.getDate());
	}
	
}
