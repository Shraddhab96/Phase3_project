package phase3.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import phase3.project.dao.DAO;
import phase3.project.model.Product;
import phase3.project.model.User;

@Controller
public class Products {
	
	@Autowired
	DAO dao;
	
	@GetMapping("/manageProducts")
	public String listUser(Model model) {
		
		List<Product> products = dao.getProducts();
		model.addAttribute("products", products);
		model.addAttribute("product", new Product());
		
		return "Products";		
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("product") Product product, Model model) {
		
		String name = product.getName();
		String category = product.getCategory();
		
		int affected = dao.setProduct(name, category);
		
		if(affected == 1) {
			model.addAttribute("message", "Product added");
		}else {
			model.addAttribute("message", "Product not added");
		}
		
		return "Products";		
	}
	
	@PostMapping("/delProduct")
	public String delProduct(@ModelAttribute("product") Product product, Model model) {
		
		String name = product.getName();
		String category = product.getCategory();
		
		int affected = dao.delProduct(name, category);
		
		if(affected == 1) {
			model.addAttribute("message2", "Product deleted");
		}else {
			model.addAttribute("message2", "Product not deleted");
		}
		
		return "Products";		
	}
	

}