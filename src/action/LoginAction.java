package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.*;

import javax.servlet.http.*;

import java.util.Map;

public class LoginAction extends ActionSupport
							implements  ServletResponseAware {

	private String username;
	private String password;
	private String tip;
	private HttpServletResponse response; 
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	//ʵ��ServletResponseAware�ӿڱ���ʵ�ֵķ���
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}
	
	//���崦���û������execute����
	public String execute() throws Exception
	{
		/*
		this.counter();
		//��usernameΪqwe��passwordΪ123ʱ����¼�ɹ�
		if (getUsername().equals("qwe")
			&& getPassword().equals("123") )
		{
			ActionContext.getContext().getSession()
				.put("username" , getUsername());
			Cookie cookie = new Cookie("username",getUsername());
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			setTip("���ѳɹ���½��");
			return SUCCESS;
		}
		else
		{
			setTip("��¼ʧ�ܣ�");
			*/
			return ERROR;
		//}
	}

	//��¼������
	public void counter()
	{
		ActionContext ctx = ActionContext.getContext();
		Integer count = (Integer)ctx.getApplication().get("counter");
		if( count == null )
		{
			count = 1;
		}
		else
		{
			count = count + 1;
		}
		
		ctx.getApplication().put("counter", count);
		ctx.getSession().put(username, getUsername());
	}
	
	public String test() throws Exception
	{
		this.counter();
		//��usernameΪqwe��passwordΪ123ʱ����¼�ɹ�
		if (getUsername().equals("qwe")
			&& getPassword().equals("123") )
		{
			ActionContext.getContext().getSession()
				.put("username" , getUsername());
			Cookie cookie = new Cookie("username",getUsername());
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			setTip("���ѳɹ���½��");
			return SUCCESS;
		}
		else
		{
			setTip("��¼ʧ�ܣ�");
			return ERROR;
		}
	}
}
