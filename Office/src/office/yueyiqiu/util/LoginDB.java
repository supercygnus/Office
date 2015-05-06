package office.yueyiqiu.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoginDB {
	private SessionFactory sf;
	
	/**
	 * @return the sf
	 */
	public SessionFactory getSf() {
		return sf;
	}



	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}



	public List getUser(String hql){
		
		Session session=sf.openSession();
		Query q=session.createQuery(hql);
		List list=q.list();
		session.clear();
		return list;
	}
}
