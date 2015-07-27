package jsonAction;

import java.util.ArrayList;
import java.util.List;
import javaBean.nodeValue;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

import db.data;
 
public class JsonAction extends ActionSupport implements ServletRequestAware{
    private static final long serialVersionUID = 1L;
     
    private HttpServletRequest request;
    private String result;
 
    public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
     
    /**
     * ����ajax����
     * @return SUCCESS
     */
    public String excuteAjax(){
         
        try {
            //��ȡ����
        	
            String name = request.getParameter("addr");
            //int age = Integer.parseInt(request.getParameter("age"));
            //String position = request.getParameter("position");
            System.out.println("request:");
            System.out.println(">>name:"+name);
            //System.out.println(">>age:"+age);
            //System.out.println(">>position:"+position);
            List<nodeValue> list = new ArrayList<nodeValue>();
            /*
            data d = new data();
            d.setAge(Integer.toString(age));
            d.setName(name);
            d.setPosition(position);
            list.add(d);
            //�����ݴ洢��map���ת����json�������ݣ�Ҳ�����Լ��ֶ�����json��������
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("name", name);
            map.put("age",age);
            map.put("position", position);
            System.out.println("map:"+map.toString());
            System.out.println("list:"+list.toString());
            JsonGenerator jsonGenerator = null;
            ObjectMapper mapper = new ObjectMapper(); 
            String jsonfromList = mapper.writeValueAsString(list);
            
            System.out.println("jsonfromList:"+jsonfromList);
            
            String jsonfromMap =  mapper.writeValueAsString(map);
            System.out.println("jsonfromMap:"+jsonfromMap);
            */
            db.data ad = new data();
            list = ad.getDataList(name);
            JsonGenerator jsonGenerator = null;
            
            ObjectMapper mapper = new ObjectMapper(); 
            String jsonfromList = mapper.writeValueAsString(list);
            //result = jsonfromList.substring(1, jsonfromList.length()-1);//��result��ֵ�����ݸ�ҳ��
            result = jsonfromList.toString();//.substring(1, jsonfromList.length()-1);//��result��ֵ�����ݸ�ҳ��
            //System.out.println();
            
            System.out.print("result:"+result);System.out.println("|");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
 
 
     
}