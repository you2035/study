package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;
/**
 * 
 * @author 刘新
 * 这是一个操作数据库的工具类
 */
public class SqlHelper {
	
	//定义需要的变量
	private static Connection ct=null;
	//大多数情况下，我们使用的是PreparedStatement来替代Statement，可以防止sql注入
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static CallableStatement cs=null;
	
	//分页问题
	public static ResultSet execteQuery2(){
		return null;
	}
	
	//调用存储过程 又返回参数
	public static CallableStatement callPro2(String sql,String [] inparameters,Integer [] outparameters){
		try {
			ct=DBUtil.getConnection();
			cs=ct.prepareCall(sql);
			if(inparameters!=null){
				for(int i=0;i<inparameters.length;i++){
					cs.setObject(i+1, inparameters[i]);
				}
			}
			//给out赋值
			if(outparameters!=null){
				for(int i=0;i<outparameters.length;i++){
					cs.registerOutParameter(inparameters.length+1+i, 0);
				}
			}
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			//不需要关闭
		}
		return cs;
	}
	//调用存储过程 无返回参数
	public static void callPro1(String sql,String [] parameters){
		try {
			ct=DBUtil.getConnection();
			cs=ct.prepareCall(sql);
			
			//?号赋值
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					cs.setObject(i+1, parameters[i]);
				}
			}
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs,cs,ct);
		}
	}
	//多个update/delete/insert
	public static void executeUpdate2(String sql,String [][]parameters){
		try {
			ct=DBUtil.getConnection();
			//因为这时，用户传入的可能是多个SQL语句
			ct.setAutoCommit(false);
			for(int i=0;i<sql.length();i++){
				if(parameters[i]!=null){
					ps=ct.prepareStatement(sql);
					for(int j=0;j<parameters.length;j++){
						ps.setString(j+1, parameters[i][j]);
					}
					ps.executeUpdate();
				}
			}
			ct.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs,ps,ct);
		}
	}
	
	//统一的curd操作
	public static void executeUpdate(String sql,String [] parameters){
		try {
			ct=DBUtil.getConnection();
			ps=ct.prepareStatement(sql);
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			//执行
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs,ps,ct);
		}
	}
	
	//对查询语句升级
	//这样我们可以满足这样的规则：哪里用资源，那里关闭资源
	public static ArrayList executeQuery3(String sql, String[] parameters) {
        ct=DBUtil.getConnection();//连接数据库
        ArrayList list = null;
        try {
            ps = ct.prepareStatement(sql);
            if (parameters!=null) {
                //    System.out.println(sql);
                for (int i = 0; i < parameters.length; i++) {
                    //  System.out.println(i+"    "+parameters[i]);
                    ps.setString((i + 1), parameters[i]);
                }
            }
            rs = ps.executeQuery();
            list = new ArrayList();

            ResultSetMetaData rmd = rs.getMetaData();
            int column = rmd.getColumnCount();
            while (rs.next()) {
                Object obj[] = new Object[column];
                for (int i = 0; i < column; i++) {
                    obj[i] = rs.getObject(i+1);
                }
                list.add(obj);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            //关闭资源
        	close(rs,ps,ct);
        }
        return list;
    }

	
	//写一个方法，完成查询任务
	//sql表示要执行的sql语句
	//sql select * from emp where ename=?
	public static ResultSet executeQuery(String sql,String[] parameters){
		try {
			//根据实际情况我们对sql语句?赋值
			//得到连接
			ct=DBUtil.getConnection();
			//创建ps对象，得到sql语句对象
			ps=ct.prepareStatement(sql);
			//如果parameters不为null，才赋值
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			//抛出运行异常
			throw new RuntimeException(e.getMessage());
		} finally{
			//close(rs,ps,ct);
		}
		return rs;
	}
	
	//把关闭资源写成函数
	public static void close(ResultSet rs,Statement ps,Connection ct){
		//关闭资源
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps=null;
		}
		if(ct!=null){
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct=null;
		}
	}
	
	public static Connection getCt() {
		return ct;
	}

	public static PreparedStatement getPs() {
		return ps;
	}
}
