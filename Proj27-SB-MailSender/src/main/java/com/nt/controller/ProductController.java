package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.model.Product;
import com.nt.service.ProductService;
import com.nt.utility.EmailUtil;

@Controller
@RequestMapping("/prod")                                                                           //prod/save
public class ProductController {                                                                   //prod/show
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private EmailUtil util;

	@RequestMapping(value = "/show", method=RequestMethod.GET )
	public String showHome(@ModelAttribute("product") Product product) {
		
		return "product_frm";
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST )
	public String saveProduct(@ModelAttribute Product product, @RequestParam MultipartFile fileOb ,Model model) {
		Integer prodId = productService.saveProduct(product);
       //send mail
		boolean isSent = util.send(product.getEmail(), "Product Added", "Hello User", fileOb);
		model.addAttribute("message", "Product created");
		model.addAttribute("product", new Product());
		return "prodInfo";
	}
	
	/*@RequestMapping(value = "/showProdInfo", method=RequestMethod.GET )
	public String showProdInfo(@ModelAttribute("prod")Product prod,@RequestParam("prodId") Integer prodId, Model model) {
		System.out.println("prodId==="+prodId);
		model.addAttribute("product", product);
		//return "product_frm";
		return "prodInfo";
	}*/
	
	@RequestMapping(value = "/showAll", method=RequestMethod.GET )
	public String showAllProducts(Model model) {
		List<Product> listProds = productService.findAll();
		model.addAttribute("product", listProds);
		return "prodInfo";
	}
	
	@RequestMapping(value = "/delete", method=RequestMethod.GET )
	public String deleteProduct(@RequestParam("prodId")Integer id,Model model) {
		Integer Id = productService.deleteById(id);
	    if(id!=null) {
	    	model.addAttribute("successMsg", Id+"deleted Successfully!");
	    	return "prodInfo";
	    }else {
	    		model.addAttribute("errorMsg", Id+"Not Found");
		   return "prodInfo";
	    }
		
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.GET )
	public String editProductById(@RequestParam("prodId")Integer id,Model model) {
	Optional<Product> product = productService.editProductById(id);
		model.addAttribute("product", product);
		return "editProduct";
	}
}
