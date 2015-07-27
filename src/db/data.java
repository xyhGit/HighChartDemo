package db;


import java.util.Date;
import java.util.List;

import javaBean.node;
import javaBean.nodeValue;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class data {

    /**
     * @param args
     */
    public List<nodeValue> getDataList(String args) {
        // TODO Auto-generated method stub
        Configuration conf = new Configuration();
        // 下面的方法默认加载hibernate.cfg.xml文件
        conf.configure("hibernate.cfg.xml");
        
        // 创建sessionFactory
        @SuppressWarnings("deprecation")
		SessionFactory sf = conf.buildSessionFactory();
        // 创建session
        Session sess = sf.openSession();
        // 开始事务,Hibernate必须显式的手动提交事务
        Transaction tx = sess.beginTransaction();
        
		Date date = new Date(1992-01-02);
		node aNode = new node();
		Query query = sess.createQuery("select date,pm2_5 from node n where n.address=? order by date asc");
		query.setString(0, args);
		List l = query.list();
		///*
		//List<node> list = query.list();
		
		for( Object d : l)
		{
			Object[] obj = (Object[])d;
			//System.out.println(obj[0]+":"+obj[1]);
			//System.out.println();
		}
		///*/
        // 提交事务
        tx.commit();
        
        // 关闭session
        sess.flush();
        sess.close();
        sf.close();
        return l;
    }

}