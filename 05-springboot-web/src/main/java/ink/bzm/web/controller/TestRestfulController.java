package ink.bzm.web.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author: buzhengmiao    https://blogs.bzm.ink/
 * @time: 2021/9/17 下午4:47
 */
@RestController
public class TestRestfulController {

	@GetMapping("/user")
	public String getUser(){
		return "get user";
	}

	@PostMapping("/user")
	public String postUser(){
		return "post user";
	}

	@PutMapping("/user")
	public String putUser(){
		return "put user";
	}

	@PatchMapping("/user")
	public String patchUser(){
		return "patch user";
	}

	@DeleteMapping("/user")
	public String deleteUser(){
		return "delete user";
	}

}

