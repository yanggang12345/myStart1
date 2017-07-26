package com.bdqn.web.order;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.bdqn.common.PageBean;
import com.bdqn.entity.Order;
import com.bdqn.entity.OrderItem;
import com.bdqn.entity.Product;
import com.bdqn.entity.User;
import com.bdqn.service.OrderItemService;
import com.bdqn.service.OrderService;
import com.bdqn.web.cart.vo.Cart;
import com.bdqn.web.cart.vo.CartItem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.utils.PaymentUtil;

public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
	User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");

	// 支付方式，支付通道
	private String pd_FrpId;
	// 接收付款成功后的参数:
	private String r3_Amt;
	private String r6_Order;

	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	private Integer page = 1;


	public void setPage(Integer page) {
		this.page = page;
	}

	private Order order = new Order();

	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	private OrderItemService orderItemService;

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}

	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	private Integer itemId;
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	/**
	 * 保存订单
	 * @return
	 */
	public String save() {

		order = new Order();
		order.setTotal(cart.getTotal());

		Date date = new Date();
		String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//格式化日期
		Timestamp timestamp = Timestamp.valueOf(sdf);//与数据库日期类型匹配
		order.setOrdertime(timestamp);

		order.setUser(user);
		order.setState(1);
		orderService.save(order);
		Set<OrderItem> orderItems = new LinkedHashSet<OrderItem>();
		//遍历购物车
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			order.setOid(order.getOid());
			orderItem.setOrder(order);
			orderItemService.saveOrUpdate(orderItem);
			orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);
		return "saveOrder";

	}
	//支付
	public String payOrder() throws IOException {
		order.setState(1);
		order.setTotal(cart.getTotal());
		order.setUser(user);
		Date date = new Date();
		String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		Timestamp timestamp = Timestamp.valueOf(sdf);
		order.setOrdertime(timestamp);
		orderService.update(order);

		// 2.完成付款:
		// 付款需要的参数:
		String p0_Cmd = "Buy"; // 业务类型:
		String p1_MerId = "10001126856";// 商户编号:
		String p2_Order = order.getOid().toString();// 订单编号:
		String p3_Amt = "0.01"; // 付款金额:
		String p4_Cur = "CNY"; // 交易币种:
		String p5_Pid = ""; // 商品名称:
		String p6_Pcat = ""; // 商品种类:
		String p7_Pdesc = ""; // 商品描述:
		String p8_Url = "http://192.168.80.1:8080/xsh17shop/order_callBack.action"; // 商户接收支付成功数据的地址:
		String p9_SAF = ""; // 送货地址:
		String pa_MP = ""; // 商户扩展信息:
		String pd_FrpId = this.pd_FrpId;// 支付通道编码:
		String pr_NeedResponse = "1"; // 应答机制:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// 向易宝发送请求:
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);

		// 重定向:向易宝出发:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		cart.clearCart();
		/*ServletActionContext.getRequest().getRequestDispatcher(sb.toString());*/
		return NONE;
		/*PageBean<Order> pageBean = orderService.findByPageWithUid(page, user.getUid());
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "orderList";*/

	}

	// 付款成功后跳转回来的路径:
		public String callBack(){
			// 修改订单的状态:
			Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
			// 修改订单状态为2:已经付款:
			currOrder.setState(2);
			orderService.update(currOrder);
			this.addActionMessage("支付成功!订单编号为: "+r6_Order +" 付款金额为: "+r3_Amt);
			
			return "msg";
		}
		int i=3;
		// 修改订单的状态:
		public String updateState(){
			i++;
			Order currOrder = orderService.findByOid(order.getOid());
			currOrder.setState(i);
			i=i==4?2:3;
			orderService.update(currOrder);
			return "updateStateSuccess";
		}
		// 查询我的订单:
		public String findByUid() {
			// 获得用户的id.
			User existUser = (User) ServletActionContext.getRequest().getSession()
					.getAttribute("existUser");
			// 获得用户的id
			Integer uid = existUser.getUid();
			// 根据用户的id查询订单:
			PageBean<Order> pageBean = orderService.findByPageWithUid(page, uid);
			// 将PageBean数据带到页面上.
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			return "findByUid";
		}
		/**
		 * 删除订单
		 * @return
		 */
		public String delete(){
			Set<OrderItem> orderItems = orderItemService.findByOid(order.getOid());
			//如果订单下没得商品就删除订单
			if (orderItems.size()==0) {
				orderService.delete(order.getOid());
				return "findByUid";
			}else{
				for (OrderItem orderItem : orderItems) {
					if (orderItem.getItemid().equals(itemId)) {
						orderItemService.delete(itemId);
						orderItems.remove(orderItem);
					}
				}
				
				if(orderItems.size()==0){
					orderService.delete(order.getOid());
				}
				return "list";
			}
		}
}
