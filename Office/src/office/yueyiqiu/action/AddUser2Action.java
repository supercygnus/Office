package office.yueyiqiu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import office.yueyiqiu.model.Users;
import office.yueyiqiu.util.InsertDB;

import com.opensymphony.xwork2.ActionSupport;

public class AddUser2Action extends ActionSupport{
	
	private InsertDB insertDB;
	private String savePath;
	private File headPic;
	private String headPicFileName;
	private String headPicContentType;
	private String name;
	private String pwd1;
	private String realName;
	private String gender;
	private String birth;
	private int dept;
	private int group;
	private int role;
	private String email;
	private String tel;
	private String jianli;
	private int salary;
	
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
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}
	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	/**
	 * @return the headPic
	 */
	public File getHeadPic() {
		return headPic;
	}
	/**
	 * @param headPic the headPic to set
	 */
	public void setHeadPic(File headPic) {
		this.headPic = headPic;
	}
	/**
	 * @return the headPicFileName
	 */
	public String getHeadPicFileName() {
		return headPicFileName;
	}
	/**
	 * @param headPicFileName the headPicFileName to set
	 */
	public void setHeadPicFileName(String headPicFileName) {
		this.headPicFileName = headPicFileName;
	}
	/**
	 * @return the headPicContentType
	 */
	public String getHeadPicContentType() {
		return headPicContentType;
	}
	/**
	 * @param headPicContentType the headPicContentType to set
	 */
	public void setHeadPicContentType(String headPicContentType) {
		this.headPicContentType = headPicContentType;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pwd2
	 */
	public String getPwd1() {
		return pwd1;
	}
	/**
	 * @param pwd2 the pwd2 to set
	 */
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * @return the dept
	 */
	public int getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(int dept) {
		this.dept = dept;
	}
	/**
	 * @return the group
	 */
	public int getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(int group) {
		this.group = group;
	}
	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the jianli
	 */
	public String getJianli() {
		return jianli;
	}
	/**
	 * @param jianli the jianli to set
	 */
	public void setJianli(String jianli) {
		this.jianli = jianli;
	}
	
	
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String filename="";
		if(this.headPicFileName!=null&&!this.headPicFileName.equals("")){
			
			filename=this.name+".jpg";
			System.out.println(filename);
			FileOutputStream fos=null;
			FileInputStream fis=null;
			
			try{
			//fos=new FileOutputStream(this.getSavePath()+"\\"+filename);
			fos=new FileOutputStream("D:\\JavaEEProject\\Office\\WebContent\\"+this.getSavePath()+"\\"+filename);
			fis=new FileInputStream(this.getHeadPic());
			byte[] buffer=new byte[1024];
			int legngth;
			
			while((legngth=fis.read(buffer))>0){
				fos.write(buffer, 0, legngth);
			}
			
			}
			catch(Exception e){
				System.out.println("¤W¶Ç¥¢±Ñ");
				
			}
			finally{
				
				fos.close();
				fis.close();
			}
			
			
		}
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d=dateFormat.parse(this.birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Users user=new Users();
		
		
		user.setDeptNumber(this.dept);
		user.setGroupNumber(this.group);
		user.setRoleNumber(this.role);
		user.setUserPwd(this.pwd1);
		user.setSalary(this.salary);
		user.setUserGender(this.gender);
		user.setUserEmail(this.email);
		user.setUserPhone(this.tel);
		user.setUserName(this.name);
		user.setUserRealName(this.realName);
		user.setUserBirth(d);
		user.setImgpath(filename);
		user.setJianli(this.jianli);
		
		this.insertDB.saveUser(user);
		
		return this.SUCCESS;
	}
	
	
	
}
