package com.gss.web.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.gss.web.domain.Member;
import com.gss.web.mapper.MemberMapper;

@MybatisTest
//실제 DB에 연결 시 필요한 어노테이션
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(replace =Replace.NONE)
class MemberServiceImplTest {

	private Member member;
	@Autowired
	private MemberMapper memberMapper;

	@BeforeEach
	void beforeEach() {
		member = new Member("test@naver.com", "1234", "01012345678");
	}

	@Test
	void memberJoinService_search_mail_return_null() {// 회원정보 테이블에 정보가 없을때
		Member member2 = memberMapper.checkEmail("fsafgasd@naver.com");
		assertNull(member2);
	}

	@Test
	void memberJoinService_insert_user_data_case_overlap(Member member) {// 회원가입시 입력 값이 pk로 존재할때
		Assertions.assertThrows(IllegalStateException.class, () -> {
			memberMapper.joinUp(member);// duplication name join
		});
	}

	@Test
	void memberJoinService_insert_user_data_case_not_overlap() {// 회원가입시 입력값이 pk로 없을때
		Member member = new Member("testNotOverlap@naver.com", "1234", "01098765432");
		memberMapper.joinUp(member);
		Member member2 = memberMapper.checkEmail(member.getEmail());
		assertNotNull(member2.getEmail());
	}
}
