package com.gss.web.service;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.domain.Member;

@Mapper
public interface MemberService {

	void joinUp(Member member);

	Member checkEmail(String email);
}
