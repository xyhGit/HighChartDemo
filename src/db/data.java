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
        // ����ķ���Ĭ�ϼ���hibernate.cfg.xml�ļ�
        conf.configure("hibernate.cfg.xml");
        
        // ����sessionFactory
        @SuppressWarnings("deprecation")
		SessionFactory sf = conf.buildSessionFactory();
        // ����session
        Session sess = sf.openSession();
        // ��ʼ����,Hibernate������ʽ���ֶ��ύ����
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
        // �ύ����
        tx.commit();
        
        // �ر�session
        sess.flush();
        sess.close();
        sf.close();
        return l;
    }

}