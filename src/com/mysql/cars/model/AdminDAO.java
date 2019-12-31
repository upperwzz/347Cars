package com.mysql.cars.model;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * 这里是管理员模块的dao类，里面提供管理员操作数据库的方�?
 * @author Administrator
 *
 */
public class AdminDAO {
	
	/**
	 * 登录的方�?
	 * @param username
	 * @param password
	 * @return
	 */
	public  Adminuser   login(String username,String password) {
		Adminuser  adminuser=null;
		  try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cars?useUnicode=true&characterEncoding=UTF8","root","root");
				QueryRunner run = new QueryRunner();
				ResultSetHandler<Adminuser> h = new BeanHandler<Adminuser>(Adminuser.class);
				adminuser= run.query(connection, "select * from adminuser where  username=? and password=?", h,username,password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return adminuser;
		
	}

}
