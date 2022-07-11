package com.gss.web.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.gss.web.api.dto.MemberCreateDto.MemberCreateRequest;
import com.gss.web.api.support.BaseApi;

class MemberApiTest extends BaseApi {
	
	@Test
	void 멤버_회원가입_성공() throws Exception {
		MemberCreateRequest req = new MemberCreateRequest("test1@naver.com", "1234", "01012345678",0);
			
		mockMvc.perform(post("/singup/join")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req)))
		.andExpect(status().isOk());
	}
}
