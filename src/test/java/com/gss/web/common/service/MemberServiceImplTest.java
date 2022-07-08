package com.gss.web.common.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gss.web.api.dto.MemberCreateDto.MemberCreateRequest;
import com.gss.web.common.domain.Member;
import com.gss.web.common.suppot.BaseService;


class MemberServiceImplTest extends BaseService{
	
	@Autowired
	private MemberService MemberService;

	@Test
	void 회원가입_성공() {
		final MemberCreateRequest req = new MemberCreateRequest("admin@naver.com", "123", "1818");

		int result = MemberService.joinUp(req);
		
		assertThat(result).isEqualTo(1);
	}

}
