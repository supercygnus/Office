package office.yueyiqiu.util;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

public class SearchDB {
	
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
	
//	public List getArrayListNative(String sql){
//		Session session=sf.openSession();
//		//Query query=session.cre;
//		List list=query.list();
//		session.close();
//		System.out.println("hello!!");
//		return list;
//	}
	
	
	public List getArrayList(String sql,int first,int max){
		Session session=sf.openSession();
		Query query=session.createSQLQuery(sql);
		if(first!=-1&&max!=-1){
			query.setFirstResult(first);
			query.setMaxResults(max);
		}
		List list=query.list();
		session.close();
		System.out.println("hello!!!world!");
		System.out.println("listsize="+list.size());
		return list;
	}
	
	public List getInstanceList(String hql){
		Session session=sf.openSession();
		Query query=session.createQuery(hql);
		List list=query.list();
		session.close();
		return list;
	}
	
	public String getRealNameByUsernumber(int number){
		
		String sql="select user_realname from oa_user where user_number='"+number+"'";
		Session session=sf.openSession();
		Query query=session.createSQLQuery(sql);
		List list=query.list();
		session.close();
		
		if(list.size()>0){
			String realname=(String) list.get(0);
			return realname;
		}
		else
			return "";
	}
	
	public int getDocMax(){
		
		Session session=sf.openSession();
		
		String sql="select max(doc_num) from oa_doc";
		Query query=session.createSQLQuery(sql);
		List list=query.list();
		session.close();
		if(list.get(0)==null)
			return 1;
		else
			return ((Integer)list.get(0)).intValue()+1;
		
	}
	
}
