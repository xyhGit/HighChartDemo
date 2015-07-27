package jsonAction;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxLoginAction extends ActionSupport {

	// 用户Ajax返回数据
	private String result;

	// struts的属性驱动模式，自动填充页面的属性到这里
	private String loginName;
	private String password;

	@Override
	public String execute() {

		// 用一个Map做例子
		Map<String, String> map = new HashMap<String, String>();

		// 为map添加一条数据，记录一下页面传过来loginName
		map.put("name", this.loginName);

		// 将要返回的map对象进行json处理
		JSONObject jo = JSONObject.fromObject(map);

		// 调用json对象的toString方法转换为字符串然后赋值给result
		this.result = jo.toString();

		// 可以测试一下result
		System.out.println(this.result);

		return SUCCESS;

	}

	//getter  setter 方法省略
}
