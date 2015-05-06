package office.yueyiqiu.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AttOnlineAction extends ActionSupport{
	
	private SearchDB searchDB;
	private String attUser;
	private String attDept;
	private int attStart;
	private int attEnd;
	private String start;
	private String end;
	private String cIp;
	
	
	
	
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
	 * @return the attUser
	 */
	public String getAttUser() {
		return attUser;
	}




	/**
	 * @param attUser the attUser to set
	 */
	public void setAttUser(String attUser) {
		this.attUser = attUser;
	}




	/**
	 * @return the attDept
	 */
	public String getAttDept() {
		return attDept;
	}




	/**
	 * @param attDept the attDept to set
	 */
	public void setAttDept(String attDept) {
		this.attDept = attDept;
	}




	/**
	 * @return the attStart
	 */
	public int getAttStart() {
		return attStart;
	}




	/**
	 * @param attStart the attStart to set
	 */
	public void setAttStart(int attStart) {
		this.attStart = attStart;
	}




	/**
	 * @return the attEnd
	 */
	public int getAttEnd() {
		return attEnd;
	}




	/**
	 * @param attEnd the attEnd to set
	 */
	public void setAttEnd(int attEnd) {
		this.attEnd = attEnd;
	}




	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}




	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}




	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}




	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}




	/**
	 * @return the cIp
	 */
	public String getcIp() {
		return cIp;
	}




	/**
	 * @param cIp the cIp to set
	 */
	public void setcIp(String cIp) {
		this.cIp = cIp;
	}




	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		int usernumber=(int) ActionContext.getContext().getSession().get("user");
		
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
		
		
		String sql="select oa_attinfo.att_startstate,oa_attinfo.att_endstate"+
					",oa_user.user_realname,oa_dept.dept_name,oa_attendtime.att_starthour,oa_attendtime.att_startmin"+
					",oa_attendtime.att_endhour,oa_attendtime.att_endmin"+
					" from oa_attinfo,oa_user,oa_attendtime,oa_dept"+
					" where date_format(att_time,'%Y-%m-%d')='"+year+"-"+strmonth+"-"+strdate+"' and oa_user.user_number='"+usernumber+"'"+
						"and oa_attinfo.att_user=oa_user.user_number and oa_user.dept_number=oa_dept.dept_number";
		List list=this.searchDB.getArrayList(sql, -1, -1);
		
		Object[] obj=(Object[]) list.get(0);
		
		this.attUser=(String)obj[2];
		this.attDept=(String)obj[3];
		this.attStart=(int)obj[0];
		this.attEnd=(int)obj[1];
		this.start=obj[4]+"點"+obj[5]+"分";
		this.end=obj[6]+"點"+obj[7]+"分";
		this.cIp=this.getcIp();
		
		return this.SUCCESS;
	}
	
	
	public String getIP(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String ip=request.getHeader("x-forwarded-for");
		return ip;
	}
	
}
