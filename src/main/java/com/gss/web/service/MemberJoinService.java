package com.gss.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberJoinService {

	@Autowired
	MemberService memberService;
}
