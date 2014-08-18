package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.TLastLoc;

public class LastLocationDao {
	private static Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public TLastLoc getLastLoc(String phoneNum) {
		TLastLoc lastLoc = new TLastLoc();
		conn = DBConnection.getConnection();
		String sql = "";
		// System.out.println(sql);
		try {

			// sql =
			// "select * from T_Last_Loc where deviceId = (select deviceId from T_Device where DeviceName='"
			// + phoneNum + "')";
			sql = "select * from T_Last_Loc where deviceId = (select deviceId from T_Person where sim='" + phoneNum + "')";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				lastLoc.setLat(rs.getBigDecimal("lat"));
				lastLoc.setLng(rs.getBigDecimal("lng"));
				lastLoc.setOLat(rs.getBigDecimal("O_Lat"));
				lastLoc.setOLng(rs.getBigDecimal("O_Lng"));
				lastLoc.setGpstime(rs.getTimestamp("gpstime"));
				lastLoc.setId(Integer.valueOf(rs.getInt(rs.getInt("deviceid"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lastLoc;
	}

	public static void main(String[] args) {
		LastLocationDao lldao = new LastLocationDao();
		if (null != lldao.getLastLoc("18031130087")) {
			System.out.print("Success");
		} else
			System.out.print("Fail");
	}
}
