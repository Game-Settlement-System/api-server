package com.gss.web.common.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.gss.web.common.domain.Member;
import com.gss.web.common.mapper.MemberMapper;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class MemberDAOTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	void 회원가입_성공() {
		final Member member = new Member("admin@naver.com", "123", "1818");
		
		int result = memberMapper.joinUp(member);
		
		Member foundMember = memberMapper.findByEmail(member.getEmail());
		
		assertThat(result).isEqualTo(1);
		assertThat(foundMember.getUserpassword()).isEqualTo(member.getUserpassword());
		assertThat(foundMember.getUserphone()).isEqualTo(member.getUserphone());
		
	}
}
