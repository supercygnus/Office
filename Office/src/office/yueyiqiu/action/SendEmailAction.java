package office.yueyiqiu.action;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.opensymphony.xwork2.ActionSupport;

public class SendEmailAction extends ActionSupport{
	
	private String topic;
	private String toEmail;
	private String content;
	private String result;
	private MailSender mailSender;
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
	 * @return the toEmail
	 */
	public String getToEmail() {
		return toEmail;
	}
	/**
	 * @param toEmail the toEmail to set
	 */
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
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
	 * @return the mailSender
	 */
	public MailSender getMailSender() {
		return mailSender;
	}
	/**
	 * @param mailSender the mailSender to set
	 */
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		SimpleMailMessage msg=new SimpleMailMessage();
		
		msg.setFrom("abc@abc.cin");
		msg.setTo(this.getToEmail());
		msg.setSubject(this.getTopic());
		msg.setText(this.getContent());
		
		try{
		this.mailSender.send(msg);
		}
		catch(MailException e){
			
			e.printStackTrace();
			this.result="發送失敗,請重試";
			return this.SUCCESS;
		}
		
		this.result="發送成功";
		return this.SUCCESS;
	}
	
	
}
