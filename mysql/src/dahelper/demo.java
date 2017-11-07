package dahelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class demo {

	 static String sql = null;  
	 static dbhelper db1 = null;  
	 static ResultSet ret = null;  
	
	 public static void main(String[] args) {  
	        sql = "select * from t01";//SQL语句  
	        db1 = new dbhelper(sql);//创建DBHelper对象  
	  
	        try {  
	            ret = db1.pst.executeQuery();//执行语句，得到结果集  
	            while (ret.next()) {  
	                String id = ret.getString(1); 
	                String name = ret.getString(2);
	                String pass = ret.getString(3);
	                System.out.println(id+ "\t"+name+"\t"+pass);  
	            }//显示数据  
	            ret.close();  
	            db1.close();//关闭连接  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }  
}