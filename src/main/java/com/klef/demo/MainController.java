package com.klef.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class MainController 
{ 
	@Autowired EmailService postman;
	@Autowired WeatherService cloud;
	CheckingUser check = new CheckingUser();
	@Autowired
	UserService userservice;
	@Autowired HttpSession session;
	// this is main
	@GetMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	// get sign up page
	@GetMapping("signup")
	public ModelAndView signup()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}
	
	@GetMapping("signin123")
	public ModelAndView signin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signin");
		return mv;
	}
	@GetMapping("/register")
	public ModelAndView register()
	{
		return new ModelAndView("signup1", "user", new Users());
	}
	@PostMapping("/submitregister")
	public ModelAndView submitregister(@ModelAttribute("user") Users user)
	{
		System.out.println(user);
		if (user.getCity() != "" && user.getCountry() != "" && user.getEmailid() != "" && user.getPassword() != "" && user.getEmailid() != "" && user.getUsername() != "")
		{
			userservice.adduser(user);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("registersuccess");
			//postman.sendMessage(user.getEmailid(), "Registered Successfully Welcome to the Weather family.\nFrom Mohan");
			mv.addObject("message", "Registered Successfully :)");
			return mv;
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registersuccess");
		mv.addObject("message", "Registration Not Successful Error:- field missing");
		return mv;
		
	}
	@GetMapping("/testingform")
	public ModelAndView register1()
	{
		return new ModelAndView("testingform", "user", new Users());
	}
	@GetMapping("signin")
	public ModelAndView logincheck()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("error","");
		return mv;
	}
	@PostMapping("/checkuser_delete")
	public String auth1(@RequestParam("emailid") String emailid,@RequestParam("password") String password,HttpServletRequest request)
	{
		//ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		System.out.println(emailid);
		System.out.println(password);
		try
		{
			if (check.checkUser(emailid, password))
			{
				List<Users> users = check.getUserObject(emailid, password);
				session.setAttribute("session_object", users.get(0));
			//	mv.setViewName("main");
				//mv.addObject("name", emailid);
				return "redirect:/homepage";
			}
			else if ((check.checkUser(emailid, password)) == false)
			{
				//mv.setViewName("login");
				//mv.addObject("error", "Invalid Username or password");
				session.setAttribute("error", "Invalid username or password");
				System.out.println("came error elsfi");
				return "signin";
			}		
		}
		catch (Exception e){
			System.out.println(e);
			//mv.setViewName("login");
			//mv.addObject("error", "Connection error Please try again..");
			session.setAttribute("error", "Connection error Please try again..");
			System.out.println("catch block connection error");
			return "redirect:/signin";
		}
		return "sign";
	}
	@PostMapping("/checkuser")
	public String validate(String emailid, String password, RedirectAttributes ra)
	{
		Users user = userservice.validateUser(emailid, password);
		if (user==null)
		{
			session.setAttribute("error", "Invalid");
			return "signin";
		}
		session.setAttribute("user", user);
		return "redirect:/homepage";
	}
	
	@GetMapping("/homepage")
	public String mainpage(Model model)
	{
		Users user = (Users)session.getAttribute("user");
		String country=user.getCountry();
		String city=user.getCity();
		Weather weather=cloud.getWeather(country, city);
		WeatherInfo winfo=new WeatherInfo(country,city,weather);
		model.addAttribute("info", winfo);
		WeatherForecast wfinfo=cloud.getWeatherForecast(country, city);
		model.addAttribute("finfo", wfinfo);
		return "main";
	}
	@GetMapping("forecast-weekly")
	public String forecastweekly(String country, String city, Model model)
	{
		Users user = (Users)session.getAttribute("user");
		String country1=user.getCountry();
		String city1=user.getCity();
		Weather weather=cloud.getWeather(country1, city1);
		WeatherInfo winfo=new WeatherInfo(country1,city1,weather);
		model.addAttribute("info", winfo);
		WeatherForecast wfinfo=cloud.getWeatherForecast(country1, city1);
		model.addAttribute("finfo", wfinfo);
		System.out.println(wfinfo);
		return "forecast-weekly";
	}
	@GetMapping("signout")
	public String signout()
	{
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("currentweather")
	public String current(String country, String city, Model model)
	{
		Users user = (Users)session.getAttribute("user");
		String country1=user.getCountry();
		String city1=user.getCity();
		model.addAttribute("city", city1);
		return "currentweather";
	}
	@GetMapping("searchcity")
	public String search(String country, String city, Model model)
	{
		if (country != null)
		{
			Weather weather = cloud.getWeather(country, city);
			WeatherInfo winfo = new WeatherInfo(country, city, weather);
			WeatherForecast wfinfo=cloud.getWeatherForecast(country, city);
			model.addAttribute("finfo", wfinfo);
			model.addAttribute("found", true);
			model.addAttribute("info", winfo);
		}
		return "searchcity";
		
	}
	
}
