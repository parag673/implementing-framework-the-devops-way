package mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import mvc.dao.ProductDao;
import mvc.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String start() {
		return "max";
	}

	@RequestMapping("/all")
	public String home(Model m) {
		
		List<Product> products=productDao.getProducts();
		m.addAttribute("products",products);
		return "index";
		
	}
	@RequestMapping("/add-product")
	public String addProduct()
	{
		return "add_product_form";
		
	}
	@RequestMapping(value="/handle-product",method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView=new RedirectView(); 
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//delete handler
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectView=new RedirectView(); 
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//update Handler
	
	@RequestMapping("get/update/{productId}")
	public String updateForm(@PathVariable("productId") int pid,Model model) {
		Product product=this.productDao.getProduct(pid);
		model.addAttribute("product",product);
		return "update_form";
		
	}
	
	@RequestMapping("/get/{productId}")
	public String get(@PathVariable("productId") int pid,Model model) {
		Product product=this.productDao.getProduct(pid);
		if(product==null) {
			return "redirect:/wrong";
			
		}
		model.addAttribute("product",product);
		return "single";
		
	}
	
	@RequestMapping("/met")
	public String met(Model m,HttpServletRequest request) {
		String id=request.getParameter("Id");
		System.out.println(id);
		m.addAttribute("Id",id);
		return "abc";
	}
	
	@RequestMapping("/wrong")
	public String wrong() {
		return "wrong";
	}
	
	@RequestMapping("/goback")
	public String goback() {
		return "max";
	}


	
}
