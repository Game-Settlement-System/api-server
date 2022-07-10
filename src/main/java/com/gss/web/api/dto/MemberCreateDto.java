package com.gss.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberCreateDto {
	@Getter
	@AllArgsConstructor
	public static class MemberCreateRequest {
		private String email;
		private String password;
		private String phoneNumber;
	}
}
