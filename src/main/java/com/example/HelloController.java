package com.example;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/api")
public class HelloController {
	@GetMapping("/hello")
	public String sayHello()
	{
		return "hello,springboot";
	}
	@GetMapping("/hello/{name}")
	public String greetUser(@PathVariable String name)
	{
		return "Hello, "+name+"!";
	}
	@GetMapping("/user")
	public Map<String,String> getUser()
	{
		Map<String,String> user=new HashMap<>();
		user.put("name","sanjay");
		user.put("email", "sanjay@gmail.com");
		return user;
	}
}
