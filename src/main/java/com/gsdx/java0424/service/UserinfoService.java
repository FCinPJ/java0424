package com.gsdx.java0424.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.gsdx.java0424.dao.DaoUtils;
import com.gsdx.java0424.dao.UserinfoDao;
import com.gsdx.java0424.entity.Userinfo;

public class UserinfoService {
	private UserinfoDao dao=new UserinfoDao();
	public boolean login(Userinfo user){
		boolean result=false;
		Connection conn=DaoUtils.getConn();
		Userinfo realuser=dao.selUserByUsername(conn, user.getUsername());
		if(realuser!=null){
			if(realuser.getPassword().equals(user.getPassword())){
				result=true;
			}
			
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	public int registerUser(Userinfo user){
		int result=0;
		Connection conn=DaoUtils.getConn();
		Userinfo realuser=dao.selUserByUsername(conn, user.getUsername());
		if(realuser==null){
			result=dao.insertUser(conn, user);
		}
		else{
			result=-1;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
