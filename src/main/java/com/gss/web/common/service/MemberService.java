package com.gss.web.common.service;

import com.gss.web.api.dto.MemberCreateDto.MemberCreateRequest;
import com.gss.web.common.domain.Member;

public interface MemberService {

	int joinUp(MemberCreateRequest dto);

	Member checkEmail(String email);
}
