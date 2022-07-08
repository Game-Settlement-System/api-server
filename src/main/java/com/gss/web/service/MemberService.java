package com.gss.web.service;

import com.gss.web.domain.Member;

public interface MemberService {

	void joinUp(Member member);

	Member checkEmail(String email);
}
