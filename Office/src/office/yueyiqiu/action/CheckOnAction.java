package office.yueyiqiu.action;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import office.yueyiqiu.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckOnAction extends ActionSupport{
	
	private int type;
	private SearchDB searchDB;
	private InsertDB insertDB;
	
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
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
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		int user=(int) ActionContext.getContext().getSession().get("user");
		
		String sql="select * from oa_attendtime";
		List list=this.searchDB.getArrayList(sql, -1, -1);
		
		Object[] obj=(Object[]) list.get(0);
		
		Date d=new Date();
		
		int year=d.getYear()+1900;
		int month=d.getMonth()+1;
		int date=d.getDate();
		int hour=d.getHours();
		int minute=d.getMinutes();
		int sec=d.getSeconds();
		
		String strMonth=month<10?"0"+month:""+month;
		String strDate=date<10?"0"+date:""+date;
		
		String strHour=hour<10?"0"+hour:""+hour;
		String strMin=minute<10?"0"+minute:""+minute;
		String strSec=sec<10?"0"+sec:""+sec;
		
		
		if(type==0){
			//上午考勤
			int attHour=((int)obj[0]);
			int attMinute=((int)obj[1]);
			
			if(hour<attHour||(hour==attHour)&&(minute<=attMinute)){
				String sqlontimemorning="update oa_attinfo"+ 
						" set att_startstate='2',att_starttime='"+strHour+":"+strMin+":"+strSec+"'"+
						" where att_user='"+user+"' and date_format(att_time,'%Y-%m-%d')='"+year+"-"+strMonth+"-"+strDate+"'";
			this.insertDB.update(sqlontimemorning);		
			}
			else{
				String sqllatemorning="update oa_attinfo"+ 
						" set att_startstate='1',att_starttime='"+strHour+":"+strMin+":"+strSec+"'"+
						" where att_user='"+user+"' and date_format(att_time,'%Y-%m-%d')='"+year+"-"+strMonth+"-"+strDate+"'";
				
				this.insertDB.update(sqllatemorning);		
				
			}
			
		}
		else{
			
			//下午考勤
			int attHour=((int)obj[2]);
			int attMinute=((int)obj[3]);
			
			if(hour>attHour||(hour==attHour)&&(minute>=attMinute)){
				String sqlontimeafternoon="update oa_attinfo"+ 
						" set att_endstate='2',att_starttime='"+strHour+":"+strMin+":"+strSec+"'"+
						" where att_user='"+user+"' and date_format(att_time,'%Y-%m-%d')='"+year+"-"+strMonth+"-"+strDate+"'";
			this.insertDB.update(sqlontimeafternoon);		
			}
			else{
				String sqllateafternoon="update oa_attinfo"+ 
						" set att_endstate='1',att_starttime='"+strHour+":"+strMin+":"+strSec+"'"+
						" where att_user='"+user+"' and date_format(att_time,'%Y-%m-%d')='"+year+"-"+strMonth+"-"+strDate+"'";
				this.insertDB.update(sqllateafternoon);		
				
			}
			
		}
		
		return this.SUCCESS;
	}
	
	
	
	
	
	

}
