package office.yueyiqiu.action;

import office.yueyiqiu.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TopAction extends ActionSupport{
	
	
	private User user;
	private int right;
	
	
	/**
	 * @return the right
	 */
	public int getRight() {
		return right;
	}




	/**
	 * @param right the right to set
	 */
	public void setRight(int right) {
		this.right = right;
	}




	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}




	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}




	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		this.right=(int) ActionContext.getContext().getSession().get("right");
		this.user=(User) ActionContext.getContext().getSession().get("userdetail");
		
		return this.SUCCESS;
	}
	
}
