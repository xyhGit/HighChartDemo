package jsonAction;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxLoginAction extends ActionSupport {

	// �û�Ajax��������
	private String result;

	// struts����������ģʽ���Զ����ҳ������Ե�����
	private String loginName;
	private String password;

	@Override
	public String execute() {

		// ��һ��Map������
		Map<String, String> map = new HashMap<String, String>();

		// Ϊmap���һ�����ݣ���¼һ��ҳ�洫����loginName
		map.put("name", this.loginName);

		// ��Ҫ���ص�map�������json����
		JSONObject jo = JSONObject.fromObject(map);

		// ����json�����toString����ת��Ϊ�ַ���Ȼ��ֵ��result
		this.result = jo.toString();

		// ���Բ���һ��result
		System.out.println(this.result);

		return SUCCESS;

	}

	//getter  setter ����ʡ��
}
