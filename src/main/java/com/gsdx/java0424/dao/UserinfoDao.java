package com.gsdx.java0424.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gsdx.java0424.entity.Userinfo;

public class UserinfoDao extends BaseDao {
	public int insertUser(Connection conn,Userinfo user){
		String sql="insert into userinfo(username,password,realname)values(?,?,?)";

		int row= super.exeUpdate(conn, sql, user.getUsername(),user.getPassword(),user.getRealname());
		
		return row;
	}
	public Userinfo selUserByUsername(Connection conn,String username){
		String sql="select * from userinfo where username=?";
		 ResultSet rs= super.exeQuery(conn, sql, username);
		 Userinfo user=null;
		 if(rs!=null){
			 try {
				if(rs.next()){
					user=new Userinfo(); 
					user.setPassword(rs.getString("password"));
					user.setUsername(username);
					user.setRealname(rs.getString("realname"));
					user.setUserid(rs.getInt("userid"));
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 return user;
	}

}
