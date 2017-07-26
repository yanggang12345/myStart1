package com.bdqn.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * <p>Title:MailUitls<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 123456
 * <p>杨刚</p>
 */
public class MailUitls {
	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 * @param code	:激活码
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void  sendMail(String to,String code) throws AddressException, MessagingException{
		/**
		 * 1.获得一个Session对象.
		 * 2.创建一个代表邮件的对象Message.
		 * 3.发送邮件Transport
		 */
		// 1.获得连接对象
		/*Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "accp");
			}
			
		});
		// 2.创建邮件对象:
		Message message = new MimeMessage(session);
		// 设置发件人:
		try {
			message.setFrom(new InternetAddress("service@shop.com"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 抄送 CC   密送BCC
			// 设置标题
			message.setSubject("来自购物天堂传智商城官方激活邮件");
			// 设置邮件正文:
			message.setContent("<h1>购物天堂传智商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://192.168.80.1:8080/shop/user_active.action?code="+code+"'>http://192.168.80.1:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}*/
		/*try {  
            Properties props = new Properties();  
            props.put("username", "1101384589@qq.com");   
            props.put("password", "qazqaz520520");   
            props.put("mail.transport.protocol", "smtp" );  
            props.put("mail.smtp.host", "smtp.qq.com");  
            props.put("mail.smtp.port", "465" );  

            Session mailSession = Session.getDefaultInstance(props);  

            Message msg = new MimeMessage(mailSession);     
            msg.setFrom(new InternetAddress("1101384589@qq.com"));  
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));   
            msg.setSubject("激活邮件");   
            msg.setContent("<h1>此邮件为官方激活邮件！请点击下面链接完成激活操作！</h1><h3><a href='http://localhost:8080/SendMail/servlet/ActiveServlet?code="+code+"'>http://localhost:8080/SendMail/servlet/ActiveServlet</a></h3>","text/html;charset=UTF-8");
            msg.saveChanges();  

            Transport transport = mailSession.getTransport("smtp");  
            transport.connect(props.getProperty("mail.smtp.host"), props  
                    .getProperty("username"), props.getProperty("password"));   
            transport.sendMessage(msg, msg.getAllRecipients());  
            transport.close();     
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println(e);  
        }  
		
	}*/
	
		   Properties properties = new Properties();
		   properties.put("mail.transport.protocol", "smtp");// 连接协议        
		   properties.put("mail.smtp.host", "smtp.qq.com");// 主机名        
		   properties.put("mail.smtp.port", 465);// 端口号        
		   properties.put("mail.smtp.auth", "true");        
		   properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用        
		   properties.put("mail.debug", "true");//设置是否显示debug信息  true 会在控制台显示相关信息        
		 //得到回话对象        
		 Session session = Session.getInstance(properties);        
		 // 获取邮件对象        
		 Message message = new MimeMessage(session);        
		 //设置发件人邮箱地址       
		  message.setFrom(new InternetAddress("1101384589@qq.com"));       
		  //设置收件人地址        
		  message.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress(to) });       
		  //设置邮件标题        
		 message.setSubject("来自购物天堂xxx商城官方激活邮件");        
		 //设置邮件内容        
		 message.setContent("<h1>购物天堂xxx商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://192.168.80.1:8080/xsh17shop/user_active.action?code="+code+"'>http://192.168.80.1:8080/xsh17shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");       
		  //得到邮差对象        
		 Transport transport = session.getTransport();        
		 //连接自己的邮箱账户        
		 transport.connect("1101384589@qq.com", "mgthvjdircnlhfcf");//密码为刚才得到的授权码        
		 //发送邮件        
		 transport.sendMessage(message, message.getAllRecipients());    
		 }
	
	public static void main(String[] args) throws AddressException, MessagingException {
		sendMail("2171732405@qq.com","qwe");
	}
}
