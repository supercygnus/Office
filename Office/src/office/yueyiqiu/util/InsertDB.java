package office.yueyiqiu.util;

import java.util.List;

import office.yueyiqiu.model.Alarm;
import office.yueyiqiu.model.SendMsg;
import office.yueyiqiu.model.ShareFile;
import office.yueyiqiu.model.Transfile;
import office.yueyiqiu.model.Users;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class InsertDB {
	
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
	
	public void saveTransFile(List list){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		
		for(int i=0;i<list.size();i++){
			
			Transfile tf=(Transfile) list.get(i);
			session.save(tf);
		}
		
		
		trans.commit();
		session.close();
	}
	
	public void saveMsg(SendMsg msg){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		
		session.save(msg);
		
		
		trans.commit();
		session.close();
	}
	
	
	public void delTransFile(int usernumber,List<String> delList){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		String hql="delete from Transfile where fileName in (:list) and toUser=:user"; 
		Query query=session.createQuery(hql).setParameter("list", delList).setParameter("user", usernumber);
		int ptr=query.executeUpdate();
		trans.commit();
		session.close();
	}
	
	
	public void delShareFile(String name){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		String hql="delete ShareFile where share_name='"+name+"'";
		int i=session.createQuery(hql).executeUpdate();
		trans.commit();
		session.close();
		
	}
	
	public void saveShareFile(ShareFile sfile){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		
		session.save(sfile);
		
		trans.commit();
		session.close();
		
	}
	
	
	public void delMsgList(List<Integer> msgList){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		String hql="delete from SendMsg where msgNumber in (:list)";
		Query query=session.createQuery(hql).setParameterList("list", msgList);
		int ptr=query.executeUpdate();
		trans.commit();
		session.close();
	}
	
	
	public int update(String sql){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		
		Query query=session.createSQLQuery(sql);
		int ptr=query.executeUpdate();
		trans.commit();
		session.close();
		return ptr;
	}
	
	public boolean saveDoc(String sql,int docnum,List firstList,List secondList,String type){
		
		boolean b=false;
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		int total=0;
		int j=session.createSQLQuery(sql).executeUpdate();
		total++;
		
		for(int i=0;i<firstList.size();i++){
			String s="insert into oa_docdept values ('"+firstList.get(i)+"','"+docnum+"','1','0')";
			int k=session.createSQLQuery(s).executeUpdate();
			total++;
		}
		
		if(type.equals("2")){
			for(int i=0;i<secondList.size();i++){
				String s="insert into oa_docdept values ('"+Integer.parseInt((String) secondList.get(i))+"','"+docnum+"','2','0')";
				int k=session.createSQLQuery(s).executeUpdate();
				total++;
			}
		}
		
		if(type.equals("1")){
			if(1+firstList.size()==total)
			b=true;
		}
		
		if(type.equals("2")){
			if(1+firstList.size()+secondList.size()==total)
				b=true;
		}
		
		trans.commit();
		session.close();
		
		return b;
	}
	
	public void saveUser(Users user){
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		
		session.save(user);
		
		trans.commit();
		session.close();
		
	}
	
	
	public void saveAlarm(Alarm alarm){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		
		session.save(alarm);
		
		trans.commit();
		session.close();
		
	}
	
	
	public void delAlarmList(List<Integer> delList){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		
		String hql="delete from Alarm where alarmNumber in (:list)";
		Query query=session.createQuery(hql).setParameterList("list", delList);
		int num=query.executeUpdate();
		trans.commit();
		session.close();
		
	}
	
	
	public void updateDoc(String updateSql,String typeSql){
		
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		
		int i=session.createSQLQuery(updateSql).executeUpdate();
		int j=session.createSQLQuery(typeSql).executeUpdate();
		
		
		trans.commit();
		session.close();
	}
	
}
