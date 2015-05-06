package office.yueyiqiu.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import office.yueyiqiu.model.DocDept;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class DocProAction extends ActionSupport{
	
	private SearchDB searchDB;
	private int docNum;
	private List firstList;
	private List secondList;
	private int type;
	private int state;
	private String topic;
	
	
	
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
	 * @return the docNum
	 */
	public int getDocNum() {
		return docNum;
	}
	/**
	 * @param docNum the docNum to set
	 */
	public void setDocNum(int docNum) {
		this.docNum = docNum;
	}
	/**
	 * @return the firstList
	 */
	public List getFirstList() {
		return firstList;
	}
	/**
	 * @param firstList the firstList to set
	 */
	public void setFirstList(List firstList) {
		this.firstList = firstList;
	}
	/**
	 * @return the secondList
	 */
	public List getSecondList() {
		return secondList;
	}
	/**
	 * @param secondList the secondList to set
	 */
	public void setSecondList(List secondList) {
		this.secondList = secondList;
	}
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
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String sql="select doc_title,doc_type,doc_state from oa_doc where doc_num='"+this.docNum+"'";
		
		List list=this.searchDB.getArrayList(sql, -1, -1);
		Object[] obj=(Object[]) list.get(0);
		
		this.topic=(String)obj[0];
		this.type=(int)obj[1];
		this.state=(int)obj[2];
		
		this.firstList=new ArrayList();
		this.secondList=new ArrayList();
		
		String sqlOne="select oa_dept.dept_name,oa_docdept.dept_state "
					+ " from oa_dept,oa_docdept "
					+ " where oa_docdept.dept_num=oa_dept.dept_number and oa_docdept.doc_num='"+this.docNum+"' "
					+ " and oa_docdept.doc_type='1'";
		
		List listOne=this.searchDB.getArrayList(sqlOne, -1, -1);
		
		for(int i=0;i<listOne.size();i++){
			Object[] o=(Object[]) listOne.get(i);
			DocDept dd=new DocDept((String)o[0],(int)o[1]);
			firstList.add(dd);
		}
		
		if(this.type==2){
		String sqlTwo="select oa_dept.dept_name,oa_docdept.dept_state "
					+" from oa_docdept,oa_dept "
					+" where oa_docdept.dept_num=oa_dept.dept_number"
					+" and oa_docdept.doc_type='2' and oa_docdept.doc_num='"+this.docNum+"'";
		
		List listTwo=this.searchDB.getArrayList(sqlTwo, -1, -1);
		
		for(int i=0;i<listTwo.size();i++){
			Object[] o=(Object[]) listTwo.get(i);
			DocDept dd=new DocDept((String)o[0],(int)o[1]);
			secondList.add(dd);
		}		
		
		}
		
		//System.out.println(((DocDept)this.secondList.get(2)).getDeptName());
		
		return this.SUCCESS;
	}
	
}
