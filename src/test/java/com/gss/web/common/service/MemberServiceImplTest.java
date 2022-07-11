package com.gss.web.common.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gss.web.common.dao.MemberDAO;
import com.gss.web.common.domain.Member;
import com.gss.web.common.suppot.BaseService;

class MemberServiceImplTest extends BaseService {
	@Autowired
	private MemberDAO memberDAO;

	@Test
	void 회원가입_성공() {
		final Member req = new Member("admin@naver.com", "123", "1818", 0);

		int result = memberDAO.joinMember(req);

		assertThat(result).isEqualTo(1);
	}

	@Test
	void 중복_사용자_중복_예외() {
		final Member req = new Member("admin@naver.com", "123", "1818", 0);
		final Member req2 = new Member("admin@naver.com", "123", "1818", 0);

		memberDAO.joinMember(req);

		assertThat(memberDAO.findByEmail(req2.getEmail())).isNotEqualTo(null);
	}

	@Test
	void 이메일_중복_체크() {
		final Member req = new Member("test1@naver.com", "123", "1818", 0);

		assertThat(memberDAO.checkEmail(req.getEmail())).isNotEqualTo(null);
	}
}
