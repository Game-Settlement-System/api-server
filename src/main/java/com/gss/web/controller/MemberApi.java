package com.gss.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberApi {
	
	@GetMapping
	public String test() {
		return "Hello! World!";
	}
}
