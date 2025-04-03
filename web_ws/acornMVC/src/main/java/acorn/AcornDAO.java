package acorn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//테이블(acorntbl) 하나당  DAO 한 개 만든다
public class AcornDAO {

	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	
	public Connection dbcon() {		
		Connection con=null;
		try {
			Class.forName(driver);
			con  =DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println("db ok");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;		
	}		
	//학생정보 조회	
	public  ArrayList<Acorn> selectAll(){		
		ArrayList<Acorn> list= null;
		list = new ArrayList<>();		
		//db연결
		 Connection con  =dbcon();
		 PreparedStatement pst= null;
		 ResultSet  rs = null;
		 
		 try {
			//sql작성
			 String sql="select * from acorntbl";
			 pst= 	con.prepareStatement(sql);
			 rs= pst.executeQuery();
			 
			 while( rs.next()) {
				 System.out.println( rs.getString(1));
				 String id = rs.getString(1);
				 String pw = rs.getString(2);
				 String name = rs.getString(3);
				 Acorn acorn = new Acorn( id, pw, name);
				 list.add(acorn);				 
			 }			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//실행된 결과 	 
		 close( rs, pst, con);
		return list;		
	}
	
	
	//등록 
	public void  insertMember(Acorn newAcorn) {		 		
		Connection  con =dbcon();	
		PreparedStatement pst= null;
		
		//sql
		String sql=" insert  into  acorntbl(id, pw, name)  values(?,?,?) ";	
		
		try {
			   pst =con.prepareStatement(sql);
			
			pst.setString(1,  newAcorn.getId());
			pst.setString(2,  newAcorn.getPw());
			pst.setString(3,  newAcorn.getName());			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close( pst, con);
		
		
	}	
	
	
	
	// 
	public Acorn selectOne( String id) {		
		//연결
		Connection con  =dbcon();
		PreparedStatement pst  =null;
		ResultSet   rs  = null;
		
		
		//sql
		String  sql=" select * from acorntbl where id  =? ";		
		Acorn acorn = null;
		try {
			 pst=con.prepareStatement(sql);
			pst.setString(1, id);			
			 rs = pst.executeQuery();			
			
			if( rs.next()) {
				//id 존재하면
				String id_tmp  = rs.getString(1);
				String pw =  rs.getString(2);
				String name = rs.getString(3);				
				acorn = new Acorn( id_tmp , pw, name);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		close(rs, pst, con);
		return acorn;		
	}
	
		
	public void update( String id, String newpw) {
		Connection  con  =dbcon();		
		PreparedStatement pst = null;
		
		
		String sql= " update  acorntbl set  pw =?  where id= ? ";		
		try {
			 pst  =con.prepareStatement(sql);
			pst.setString(1, newpw);
			pst.setString(2, id);
			
			pst.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		close( pst, con);
	}		
	
	
	
	
	public void delete( String id ) {
		Connection  con  =dbcon();		
		String sql= " delete   acorntbl where  id= ? ";		
		PreparedStatement pst  = null;
		try {
			 pst  =con.prepareStatement(sql);		 
			pst.setString(1, id);
			
			pst.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		close( pst, con);
	}		
	//변경	
	public static void main(String[] args) {
		AcornDAO  dao = new AcornDAO();
		//dao.dbcon();
		ArrayList<Acorn> list  =dao.selectAll();
		for( Acorn acorn : list) {
			System.out.println( acorn);
		}
		//Acorn acorn = new Acorn("zzz","0000","고길동");
		//dao.insertMember(acorn);		
		Acorn a = dao.selectOne("sj");
		System.out.println( a);		
		//dao.update("sj", "4545");
	 
	}
	
	

	public void close( AutoCloseable ...a) {
		for( AutoCloseable  item : a) {
		   try {
			item.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		
	}
	
}
