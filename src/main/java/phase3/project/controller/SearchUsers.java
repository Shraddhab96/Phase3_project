package phase3.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import phase3.project.dao.DAO;
import phase3.project.model.User;


@Controller
public class SearchUsers {

	@Autowired
	DAO dao;
	
	@PostMapping("/listUsers")
	public String listUser(Model model) {
		List<User> users =  dao.getUsers();
		model.addAttribute("users",users);
		
		return "listUser";		
	}
	
	
	@PostMapping("/searchUser")
	public String searchUser(@ModelAttribute("user") User user, Model model) {
		String userName = user.getSearchName();
		
		String u =  dao.searchUser(userName);
		
		if(u.equals(userName)) {
			model.addAttribute("userFound", "User " + user.getSearchName()+" found");
		}else {
			model.addAttribute("userFound", "User " + user.getSearchName() +" not found");
		}
		
		return "searchUser";		
	}
}