package com.gss.web.common.service;

import org.springframework.stereotype.Service;

import com.gss.web.api.dto.MemberCreateDto.MemberCreateRequest;
import com.gss.web.common.dao.MemberDAO;
import com.gss.web.common.domain.Member;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberDAO memberDAO;

	@Override
	public int joinUp(MemberCreateRequest dto) {
		// TODO Auto-generated method stub
		final Member member = new Member(dto.getEmail(), dto.getPassword(), dto.getPhoneNumber());
		return memberDAO.joinMember(member);
	}

	@Override
	public Member checkEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
