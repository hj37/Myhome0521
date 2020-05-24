package file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FileDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//커넥션풀(DataSource)을 얻은 후 ConnecionDB접속
		private Connection getConnection() throws Exception{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/jspbeginner");
			//커넥션풀에 존재하는 커넥션 얻기
			Connection con = ds.getConnection();
			//커넥션 반환
			return con;
		}
		
		
	public int upload(String fileName, String fileRealName,String id) {
		try {
			con = getConnection();
			String sql = "insert into file values(?,?,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileRealName);
			pstmt.setString(3,id);
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int hit(String fileRealName) {
		try {
			con = getConnection();
			String sql = "update file set downloadCount = downloadCount + 1 where fileRealName = ?";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileRealName);
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; 
	}
	
	public ArrayList<FileDTO> getList(){
		ArrayList<FileDTO> list = new ArrayList<FileDTO>();
		try {
			con = getConnection();
			String sql ="select * from file";

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				FileDTO file = new FileDTO();
				file.setFileName(rs.getString(1));
				file.setFileRealName(rs.getString(2));
				file.setDownloadCount(rs.getInt(3));
				file.setId(rs.getString(4));
				list.add(file);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
