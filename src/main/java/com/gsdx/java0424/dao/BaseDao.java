package com.gsdx.java0424.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class BaseDao {
	private PreparedStatement pstms = null;
	private ResultSet rs = null;
	/**
	 * 通用的增删改方法
	 * @param conn 数据库连接
	 * @param sql  要执行的sql语句  insert update delete
	 * @param values  ?对应的参数值
	 * @return  返回影响的行数
	 */

	public int exeUpdate(Connection conn, String sql, Object  ... values) {
		int result = 0;
		try {
			pstms = conn.prepareStatement(sql);
			if(values!=null){
				for (int i = 0; i < values.length; i++) {
					pstms.setObject(i+1, values[i]);
				}
			}
			result= pstms.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 通用的查询方法
	 * @param conn 数据库连接
	 * @param sql  要执行的sql语句  select
	 * @param values  ?对应的参数值
	 * @return  返回结果集
	 */

	public ResultSet exeQuery(Connection conn, String sql, Object... values) {
		
		try {
			pstms = conn.prepareStatement(sql);
			if(values!=null){
				for (int i = 0; i < values.length; i++) {
					pstms.setObject(i+1, values[i]);
				}
			}
			rs=pstms.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
