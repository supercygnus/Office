package office.yueyiqiu.action;

import java.util.List;

import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendDoc2Action extends ActionSupport{
	
	private SearchDB searchDB;
	private InsertDB insertDB;
	private List firstList;
	private List secondList;
	private String type;
	private String topic;
	private String content;
	private String result;
	
	
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
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
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
//		for(int i=0;i<this.firstList.size();i++){
//			System.out.println(this.firstList.get(i)+"  ");
//		}
		
		int from=(int) ActionContext.getContext().getSession().get("user");
		int docnum=this.searchDB.getDocMax();
				
		String sql="insert into oa_doc (doc_num,doc_from,doc_title,doc_content,doc_type) values "+
		" ('"+docnum+"','"+from+"','"+this.topic+"','"+this.content+"','"+this.type+"')";
		
		boolean b=this.insertDB.saveDoc(sql, docnum, firstList, secondList, type);
		
		if(b==true)
			this.setResult("發送成功");
		if(b==false)
			this.setResult("發送失敗");
		
		return this.SUCCESS;
		
	}
	
	
	
	
}
