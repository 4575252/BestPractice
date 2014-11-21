package net.linzhihui.bestPractice.itxdlInAction.JavaWeb01.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

	private Connection conn = null;

	public Connection initDbConnection(Connection conn){
		if(conn!=null){
			this.conn = conn;
		}else{
			this.conn = DBUtils.getConnection();
		}
		return this.conn;
	}
	
	/**
	 * 实现增删改的抽象
	 * @param sql
	 * @param args
	 */
	public int update(String sql,Object...args){
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(sql);
			//设置占位符的参数
			if(args!=null){
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i+1, args[i]);
				}
			}
			return ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}finally{
//			DBUtils.close(null, ps, null);
		}
	}
	/**
	 * 查询方法的抽象
	 * @param sql
	 * @param handler
	 * @param args
	 * @return
	 */
	public Object query(String sql,ResultSetHandler handler,Object...args){
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			if(args!=null){
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i+1, args[i]);
				}
			}
			rs = ps.executeQuery();
			return handler.doHandler(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(rs, ps, null);
		}
	}
}



















