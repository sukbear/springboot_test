package cn.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.pojo.Users;
import cn.test.service.UsersService;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UsersService usersService;

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

	@RequestMapping("/addUser")
	public String addUser(Users users) {
		this.usersService.addUser(users);
		return "ok";
	}
	
	@RequestMapping("/findUserAll")
	public String findUserAll(Model model){
		List<Users> list = this.usersService.findUserAll();
		model.addAttribute("list", list);
		return "show";
	}
	
	@RequestMapping("/findUserById")
	public String findUserById(Integer id,Model model){
		Users user = this.usersService.findUserById(id);
		model.addAttribute("user", user);
		return "updateUsers";
	}
	
	@RequestMapping("/editUser")
	public String editUser(Users users){
		this.usersService.updateUser(users);
		return "ok";
	}
	
	@RequestMapping("/delUser")
	public String delUser(Integer id){
		this.usersService.deleteUserById(id);
		return "redirect:/users/findUserAll";
	}


}
