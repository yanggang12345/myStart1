package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Pager;
import entity.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;
import sun.security.util.Length;
import util.Utils;

/**
 * 答题系统
 * <p>Title:ProductServlet<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @date 2017年7月26日 下午4:23:26
 * @author 123456
 * <p>杨刚</p>
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private ProductService service = new ProductServiceImpl();
	int count=1;
	ArrayList list=new ArrayList<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String id1 = null;
		int id = 0;
		//取参数
		id1 = req.getParameter("id1");

		Product product = null;
		int id2;
		if(id1!=null){
			//将页面传来的字符串转为数字
			id=Integer.parseInt(id1);
			product = service.findById(id).get(0);
			
		}else{
			//随机生成某一个题
			id2=(int) (1+Math.random()*5);
			product = service.findById(id2).get(0);
			//空值赋值
			if(list.isEmpty()){
				req.setAttribute("product2", product);
				list.add(id2);
			}
		}
		
		//去页面答题的回答
		String[] answer=req.getParameterValues("remark");
		if (answer != null && count > 1) {
			int total = 0;
			String asquestion = "";
			for (String string : answer) {
				asquestion += string + ",";
			}
			asquestion = asquestion.substring(0, asquestion.length() - 1);
			// 取成绩
			total = asquestion.equals(product.getAnwer()) ? 5 : 0;
			service.save(total + "", asquestion, id);
		}
		
		
		
		//第几题
		req.setAttribute("count", count);
		
		Product product3=null;
		boolean st=true;
		//如果题未做完就继续，已做完就重置，并跳转到成绩页面
		if(list.size()>=1&&count>1){
			while (st) {
				id2=(int) (1+Math.random()*5);
				boolean ss=true;
				for (Object object : list) {
					
					ss=!object.equals(id2);
					
				}
				if(ss){
					st=false;
					product = service.findById(id2).get(0);
					req.setAttribute("product2", product);
					//添加id2
					list.add(id2);
				}
				
			}
			
		}
		
		
		//count等于6时跳转到分数页面
		if(count==6){
			List<Product> list2 = service.find();
			int scope=0;
			for (Product product4 : list2) {
				scope += Integer.parseInt(product4.getTotal());
			}
			count=1;
			list=new ArrayList<>();
			req.setAttribute("scope", scope);
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
			return;
		}
		
		count++;
		req.getRequestDispatcher("/test.jsp").forward(req, resp);//内部跳转到list.jsp页面，显示结果
	}

	
}
