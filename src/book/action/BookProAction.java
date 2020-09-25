package book.action;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import book.svc.BookProService;
import book.svc.BookProService;
import book.vo.ActionForward;
import book.vo.BookBean;

public class BookProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		ActionForward forward = null;

		BookBean bb = new BookBean();
		Date date1 = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pickup")).getTime());
		Date date2 = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("end")).getTime());

		long rentday = (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000);

		bb.setPickup_date(date1);
		bb.setEnd_date(date2);
		bb.setCar_id(request.getParameter("car_id"));
		bb.setBook_state(1);
		bb.setBook_price((int) rentday * Integer.parseInt(request.getParameter("rentprice")));
		BookProService bps = new BookProService();
		boolean isWriteSuccess = bps.registBook(bb);

		if (isWriteSuccess) {
			System.out.println(bb.getBook_num());

			BookBean bookList = bps.selectBookNum(bb);
			request.setAttribute("bookList", bookList);
			forward = new ActionForward();
			forward.setPath("book/BookForm3.jsp");

		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 등록 실패!')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
