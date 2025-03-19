package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api1")
public class HelloController1 {
	private HashMap<String,String> user=new HashMap<>();
	@GetMapping("/hello1")
	public String sayHello()
	{
		return "hello spring";
	}
	
	@GetMapping("/hello1/{name}")
	public String greetUser(@PathVariable String name)
	{
		return "hello"+name+"!";
	}
	
	@GetMapping("/user1")
	public Map<String,String> getUser()
	{
		return user.isEmpty() ? Map.of("Message","No user found"):user;
	}
	
	@PostMapping("/user2")
	public String createUser(@RequestBody Map<String,String> newUser)
	{
		user.put("name", newUser.get("name"));
		user.put("email", newUser.get("email"));
		
		return "user created successfully";
	}
	
	@PutMapping("/user")
    public String updateUser(@RequestBody Map<String, String> updatedUser) {
        if (user.isEmpty()) {
            return "No user found to update.";
        }
        user.put("name", updatedUser.getOrDefault("name", user.get("name")));
        user.put("email", updatedUser.getOrDefault("email", user.get("email")));
        return "User updated successfully!";
    }
	
	@DeleteMapping("/delete")
	public String deleteUser()
	{
		if(user.isEmpty())
		{
			return "no user found to delete";
		}
		user.clear();
		return "user cleared";
	}
}
