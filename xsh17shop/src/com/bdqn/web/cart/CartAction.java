package com.bdqn.web.cart;

import org.apache.struts2.ServletActionContext;

import com.bdqn.entity.Product;
import com.bdqn.service.ProductService;
import com.bdqn.web.cart.vo.Cart;
import com.bdqn.web.cart.vo.CartItem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CartAction extends ActionSupport{

	private Integer pid;
	private Integer count;
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	//注入商品服务
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//添加购物车
	public String addCart(){
		CartItem cartItem=new CartItem();
		cartItem.setCount(count);
		Product product=productService.findByPid(pid);
		cartItem.setProduct(product);
		Cart cart=getCart();
		cart.addCart(cartItem);
		ActionContext.getContext().getSession().put("cart", cart);
		return "addCart";
		
	}
	//取得购物车
	private Cart getCart() {
		
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		//首次添加商品时，购物车为空需要实例化一个
		if(cart==null){
			cart=new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	//购物车中移除商品
	public String removeCart(){
		Cart cart=getCart();
		cart.removeCart(pid);
		return "removeCart";
	}
	//清空购物车
	public String clearCart(){
		Cart cart=getCart();
		cart.clearCart();
		return "clearCart";
	}
	//查看购物车商品
	public String myCart(){
		return "myCart";
	}
}
