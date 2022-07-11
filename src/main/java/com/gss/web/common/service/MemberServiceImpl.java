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
		final Member member = new Member(dto.getEmail(), dto.getPassword(), dto.getPhoneNumber(), dto.getPrivilge());
		return memberDAO.joinMember(member);
	}

	@Override
	public Member findByEmail(String email) {
		Member member=memberDAO.findByEmail(email);
		System.out.println("181818181881"+member.getEmail());
		return member;
	}

	@Override
	public boolean checkEmail(String email) {
		boolean checkEmailStat=true;
		checkEmailStat=memberDAO.checkEmail(email);
		return checkEmailStat;
	}
}
