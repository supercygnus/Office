package office.yueyiqiu.action;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainManageAction extends ActionSupport{
	
	private SearchDB searchDB;
	private int president=0;
	private int marketing=0;
	private int technology=0;
	private int publicrelation=0;
	private int finance=0;
	private int logistic=0;
	private int right;
	
	
	
	/**
	 * @return the right
	 */
	public int getRight() {
		int right=(int) this.getSession().get("right");
		return right;
	}




	/**
	 * @param right the right to set
	 */
	public void setRight(int right) {
		this.right = right;
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
	 * @return the president
	 */
	public int getPresident() {
		return president;
	}




	/**
	 * @param president the president to set
	 */
	public void setPresident(int president) {
		this.president = president;
	}




	/**
	 * @return the marketing
	 */
	public int getMarketing() {
		return marketing;
	}




	/**
	 * @param marketing the marketing to set
	 */
	public void setMarketing(int marketing) {
		this.marketing = marketing;
	}




	/**
	 * @return the technology
	 */
	public int getTechnology() {
		return technology;
	}




	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(int technology) {
		this.technology = technology;
	}




	/**
	 * @return the publicrelation
	 */
	public int getPublicrelation() {
		return publicrelation;
	}




	/**
	 * @param publicrelation the publicrelation to set
	 */
	public void setPublicrelation(int publicrelation) {
		this.publicrelation = publicrelation;
	}




	/**
	 * @return the finance
	 */
	public int getFinance() {
		return finance;
	}




	/**
	 * @param finance the finance to set
	 */
	public void setFinance(int finance) {
		this.finance = finance;
	}



	/**
	 * @return the logistic
	 */
	public int getLogistic() {
		return logistic;
	}




	/**
	 * @param logistic the logistic to set
	 */
	public void setLogistic(int logistic) {
		this.logistic = logistic;
	}




	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String sql="select alarm_dept,count(*) from oa_alarm where alarm_state='0' group by alarm_dept";
		List list=searchDB.getArrayList(sql,-1,-1);
		int size=list.size();
		for(int i=0;i<size;i++){
			Object[] o=(Object[]) list.get(i);
			int dept=(int) o[0];
			System.out.println("dept="+dept);
			if(dept==10000)
				this.president=((BigInteger) o[1]).intValue();
			if(dept==10001)
				this.marketing=((BigInteger) o[1]).intValue();
			if(dept==10002)
				this.technology=((BigInteger) o[1]).intValue();
			if(dept==10003)
				this.publicrelation=((BigInteger) o[1]).intValue();
			if(dept==10004)
				this.finance=((BigInteger) o[1]).intValue();
			if(dept==10005)
				this.logistic=((BigInteger) o[1]).intValue();
		}
		
		return this.SUCCESS;
	}
	
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
	
}
