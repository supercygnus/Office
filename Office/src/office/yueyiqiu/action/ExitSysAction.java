package office.yueyiqiu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExitSysAction extends ActionSupport{

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		ActionContext.getContext().getSession().clear();
		return this.SUCCESS;
	}
	
	
	
}
