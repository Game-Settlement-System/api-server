package com.gss.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singup")
public class MemberApi {

	@GetMapping
	public String singUpPage() {
		return "Hello! World!";
	}
}
