package com.wgmf.temporyjob.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wgmf.temporyjob.connectionFactory.JdbcConnectionFactory;
import com.wgmf.temporyjob.connectionFactory.JmsConnectionFactory;

public class sendArticle {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String sql = "select openid from  mv_biz_customer t where t.cus_mobile=?";
			con = JdbcConnectionFactory.getConnection();
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, "15710758608");
			ResultSet result = pre.executeQuery();
			List<String> openids = new ArrayList<String>();
			while(result.next()){
				openids.add(result.getString(1));
				pre.setString(1, "13923868531");
				result = pre.executeQuery();
				while(result.next()){
					openids.add(result.getString(1));
					JmsConnectionFactory.sendTojms(openids, "n8iyHZ4lYFI7N4X9NTECOku7RINH6QLgt7di1qMZ5X8");
					System.out.println("sendMsgTo:"+result.getString(1)+"...");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
