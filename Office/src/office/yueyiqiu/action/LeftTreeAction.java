package office.yueyiqiu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LeftTreeAction extends ActionSupport{
	
	private int right;
	
	/**
	 * @return the right
	 */
	public int getRight() {
		return (int) ActionContext.getContext().getSession().get("right");
	}




	/**
	 * @param right the right to set
	 */
	public void setRight(int right) {
		this.right = right;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}
}
