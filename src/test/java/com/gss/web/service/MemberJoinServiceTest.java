package com.gss.web.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.dao.DataAccessException;

import com.gss.web.domain.Member;

@MybatisTest
//실제 DB에 연결 시 필요한 어노테이션
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(replace =Replace.NONE)
class MemberJoinServiceTest {

	MemberJoinService memberJoinService;
	Member member = new Member("test@naver.com", "1234", "01012345678");
	@Autowired
	MemberService memberService;

	@Test
	void memberJoinService_search_mail_return_null() {// 회원정보 테이블에 정보가 없을때
		Member member2 = memberService.checkEmail(member.getEmail());
		assertThrows(NullPointerException.class, () -> {
			member2.getEmail();
		}, "null 아님");
	}

	@Test
	void memberJoinService_insert_user_data_case_overlap() {// 회원가입시 입력 값이 pk로 존재할때
		try {
			memberService.joinUp(member);
		} catch (DataAccessException e) {
			System.out.println("존재 email");
		}
	}

	@Test
	void memberJoinService_insert_user_data_case_not_overlap() {// 회원가입시 입력값이 pk로 없을때
		Member member = new Member("testNotOverlap@naver.com", "1234", "01098765432");
		memberService.joinUp(member);
		Member member2 = memberService.checkEmail(member.getEmail());
		assertNotNull(member2.getEmail());
	}
}
