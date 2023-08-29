package com.seclore.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seclore.main.domain.UserDetails;
import com.seclore.main.service.UserDetailsServiceInterface;

@Controller
@RequestMapping("loginapplication")
public class LoginController {

	@Autowired
	private UserDetailsServiceInterface userDetailsService;

	@RequestMapping("dologin")
	public ModelAndView showLoginPage() {
		// Model object
		UserDetails userDetails = new UserDetails();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetails", userDetails);
		modelAndView.setViewName("login");

		return modelAndView;

	}

	@RequestMapping("loginaction")
	public ModelAndView validateLogin(UserDetails userDetails) {
		System.out.println(userDetails);
		UserDetails details = userDetailsService.validate(userDetails);
		System.out.println("From DB");
		System.out.println(details);
		ModelAndView modelAndView = new ModelAndView();
		if (details != null) {
			modelAndView.addObject("userDetails", userDetails);
			modelAndView.setViewName("success");
			return modelAndView;
		} else {
			modelAndView.setViewName("failure");
			return modelAndView;
		}
	}
}
