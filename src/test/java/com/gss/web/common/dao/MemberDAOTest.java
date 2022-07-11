package com.gss.web.common.dao;

import static org.assertj.core.api.Assertions.assertThat;

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
		final Member member = new Member("admin@naver.com", "123", "1818", 0);

		int result = memberMapper.joinUp(member);

		Member foundMember = memberMapper.findByEmail(member.getEmail());

		assertThat(result).isEqualTo(1);
		assertThat(foundMember.getUserpassword()).isEqualTo(member.getUserpassword());
		assertThat(foundMember.getUserphone()).isEqualTo(member.getUserphone());

	}

	@Test
	void 회원가입_중복_확인() {
		final Member req = new Member("admin2@naver.com", "123", "1818", 0);

		memberMapper.joinUp(req);
		Member member2 = memberMapper.findByEmail(req.getEmail());
		assertThat(member2.getEmail()).isEqualTo("admin2@naver.com");
	}

	@Test
	void 이메일_중복_체크() {
		final Member req = new Member("test1@naver.com", "123", "1818", 0);
		// test1@naver.com db에 실제 있는 값

		assertThat(memberMapper.checkEmail(req.getEmail())).isTrue();
	}
}
