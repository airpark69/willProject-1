package admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.GraphProService;
import admin.vo.CarBean;
import member.action.Action;
import member.vo.ActionForward;

public class GraphProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		String target1=request.getParameter("target1");
		String target2=request.getParameter("target2");
		
		GraphProService gps=new GraphProService();
		
		
		if(target1!=null && target2==null) {
			
		ArrayList<CarBean> cb=gps.GraphPro(target1);
		request.setAttribute("cb", cb);
		
		}else if(target1!=null && target2!=null){
			
		ArrayList<CarBean> cb=gps.GraphPro(target1,target2);
		request.setAttribute("cb", cb);
		
		}
		
		forward=new ActionForward();
		forward.setPath("/Admin/AdminPage.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
