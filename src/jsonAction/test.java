package jsonAction;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class test extends ActionSupport{

	private String responseJson;
	private String[] names = {"bj","sh","gz"};
	
	public String getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(String responseJson) {
		this.responseJson = responseJson;
	}
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	
	public String execute()
	{
		System.out.println(Arrays.toString(names));
		List<line> response = new ArrayList<line>();
		Random random = new Random();
		
		//生成数据
		for( int i = 0; i < names.length; i++ )
		{
			line temp = new line();
			temp.setName(names[i]);
			int[] k = new int[10];
			for( int j = 0; j < 10; j++ )
			{
				k[j] = random.nextInt(150);
			}
			temp.setData(k);
			response.add(temp);
		}
		
		JSONArray json = JSONArray.fromObject(response);
		this.setResponseJson(json.toString());
		System.out.println(getResponseJson());
		
		return "success";
	}
	
}
