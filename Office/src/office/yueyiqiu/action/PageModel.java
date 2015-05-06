package office.yueyiqiu.action;

import java.util.Map;

import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PageModel{
	
	
	private int currentPage=1;
	private int pageSpan=5;
	private int maxPage;
	private int totalMessage;
	
	
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}



	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	/**
	 * @return the pageSpan
	 */
	public int getPageSpan() {
		return pageSpan;
	}



	/**
	 * @param pageSpan the pageSpan to set
	 */
	public void setPageSpan(int pageSpan) {
		this.pageSpan = pageSpan;
	}



	/**
	 * @return the maxPage
	 */
	public int getMaxPage() {
		return maxPage;
	}



	/**
	 * @param maxPage the maxPage to set
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}



	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
}
