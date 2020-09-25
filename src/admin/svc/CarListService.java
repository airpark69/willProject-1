package admin.svc;

import static member.db.JdbcUtill.close;
import static member.db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import admin.dao.AdminDAO;
import admin.vo.CarBean;
import member.vo.MemberBean;

public class CarListService {

	public int getListCount(String taget,String table) {
		System.out.println("CarListService - getListCount()");
		System.out.println(table);
		int listCount = 0;
		
		
		Connection con = getConnection();
		
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
	
		listCount = adao.selectListCount(taget,table);
		
		close(con);
		
		return listCount;	
	}

	public ArrayList<CarBean> getArticleList(int page, int limit) {
		System.out.println("CarListService - getArticleList()");
		ArrayList<CarBean> memberList = null;
		
		
		Connection con = getConnection();
		
		AdminDAO adao = AdminDAO.adao;
		
		
		adao.setConnection(con);
		
		
		memberList = adao.selectCarList(page, limit);
		
		
		close(con);
		
		return memberList;
	}
	
//	public ArrayList<CarBean> getArticleList(int page, int limit) {
//		System.out.println("CarListService - getArticleList()");
//		ArrayList<CarBean> memberList = null;
//		
//		
//		Connection con = getConnection();
//		
//		AdminDAO adao = AdminDAO.adao;
//		
//		
//		adao.setConnection(con);
//		
//		
//		memberList = adao.selectgrap(page, limit);
//		
//		
//		close(con);
//		
//		return memberList;
//	}

	

}
