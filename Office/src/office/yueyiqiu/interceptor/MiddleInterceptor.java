package office.yueyiqiu.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MiddleInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		int right=0;
		
		Map session=invocation.getInvocationContext().getSession();
		Object rightObj=session.get("right");
		
		if(rightObj!=null){
			right=(int) rightObj;
		}
		
		Object userObj=session.get("user");
		
		if(right>1&&rightObj!=null&&userObj!=null){
			return invocation.invoke();
		}
		
		return Action.LOGIN;
		
		
	}
	
}
