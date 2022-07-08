package com.gss.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.domain.Member;

@Mapper
public interface MemberMapper {

	void joinUp(Member member);

	Member checkEmail(String email);
}
