package com.gss.web.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.common.domain.Member;

@Mapper
public interface MemberMapper {

	int joinUp(Member member);

	int checkEmail(String email);
	
	Member findByEmail(String email);
}
