package office.yueyiqiu.action;

import office.yueyiqiu.util.InsertDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OpDocAction extends ActionSupport{
	
	private InsertDB insertDB;
	private int type;
	private int docNum;
	
	
	
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
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		int user=(int)ActionContext.getContext().getSession().get("user");
		
		String updateSql="update oa_docdept set dept_state='"+this.type+"'"+
						" where doc_num='"+this.docNum+"'"+
						" and dept_num in (select dept_number from oa_user where user_number='"+user+"')";
		String typeSql="";
		
		if(type==1){
			typeSql="update oa_doc set doc_state=1"+
					" where doc_num='"+this.docNum+"' and (select count(*) from oa_docdept where doc_num='"+this.docNum+"' and dept_state='0')=0";
		}
		
		if(type==2){
			
			typeSql="update oa_doc set doc_state=2 where doc_num='"+this.docNum+"'";
		}
		
		this.insertDB.updateDoc(updateSql, typeSql);
		
		
		return this.SUCCESS;
	}
	
	
	
	
}
