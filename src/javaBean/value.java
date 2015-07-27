package javaBean;

import java.util.Date;

public class value {

	private Date date;
	private int avalue;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAvalue() {
		return avalue;
	}
	public void setAvalue(int avalue) {
		this.avalue = avalue;
	}
	
	public String toString()
	{
		return getDate().toString()+","+getAvalue();
	}
}
