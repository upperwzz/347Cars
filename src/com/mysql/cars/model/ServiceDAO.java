package com.mysql.cars.model;

/**
 * �����ۺ����ģ��dao�ࣨ����ֻ�ܶ�����ۺ�������ݿ������صķ�����
 * @author Administrator
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ServiceDAO {
	
	
	/**
	 * ���Ǹ����û�id��ѯ�����һ���û���dao����
	 * @return
	 */
	public  Service getServiceDetailById(int userid){
		  Service service=null;
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/347Cars?useUnicode=true&characterEncoding=UTF8","root","root");
			
			QueryRunner run = new QueryRunner();
			ResultSetHandler<Service> h = new BeanHandler<Service>(Service.class);
			service= run.query(connection, "select * from service  where userid=?", h,userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return service;
	}
	
	/**
	 * ���ǲ�ѯ��������ۺ�����dao����
	 * @return
	 */
	public  List<Service>  listAllServices(){
		  List<Service>  services=new ArrayList<>();
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/347Cars?useUnicode=true&characterEncoding=UTF8","root","root");
			
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<Service>> h = new BeanListHandler<Service>(Service.class);
			services= run.query(connection, "select * from service order by userid desc", h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  return services;
	}
	/**
	 * ����ɾ��������Ϣ��dao����
	 * @param serviceid
	 * @return
	 */
	public boolean  deleteService(int serviceid) {
		boolean result=false;
		  try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/347Cars?useUnicode=true&characterEncoding=UTF-8","root","root");
				
				QueryRunner run = new QueryRunner();
				int count=run.update(connection,"delete from service where userid=?",serviceid);
				result=count>0?true:false;
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
		return result;
	}
	
	/**
	 * ������ӳ�����Ϣ��dao����
	 * @param serviceid
	 * @return
	 */
	public boolean  addService(Service c) {
		boolean result=false;
		  try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/347Cars?useUnicode=true&characterEncoding=UTF-8","root","root");
				
				QueryRunner run = new QueryRunner();
//				int count=run.update(connection,"insert into  service(pinpaiming,xilie,shoujia,pailiang,gonglishu,yanse)  values(?,?,?,?,?,?)",c.getPinpaiming(),c.getXilie(),c.getShoujia(),c.getPailiang(),c.getGonglishu(),c.getYanse());
				int count=run.update(connection,"insert into  service(username,zhaopian,pingpaiming,xilie,baoxian,fuzeren)  values(?,?,?,?,?,?,?)",c.getUsername(),c.getZhaopian(),c.getPingpaiming(),c.getXilie(),c.getBaoxian(),c.getFuzeren());
				result=count>0?true:false;
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
		return result;
	}
	/**
	 * �����޸ĳ�����Ϣ��dao����
	 * @param serviceid
	 * @return
	 */
	public boolean  updateService(Service c) {
		boolean result=false;
		  try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/347Cars?useUnicode=true&characterEncoding=UTF-8","root","root");
				
				QueryRunner run = new QueryRunner();
				int count=run.update(connection,"update   service  set  username=?,zhaopian=?,pingpaiming=?,xilie=?,baoxian=?,fuzeren=?  where serviceid=?",c.getUsername(),c.getZhaopian(),c.getPingpaiming(),c.getXilie(),c.getBaoxian(),c.getFuzeren(),c.getUserid());
				result=count>0?true:false;
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
		return result;
	}

}