package com.gss.web.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;


class MemberTest {

	@Test
	void 멤버_생성_성공() {
		
		final Member member = new Member("test@naver.com", "1234", "01012345678");
		
		assertThat(member.getEmail()).isEqualTo("test@naver.com");
		assertThat(member.getUserpassword()).isEqualTo("1234");
		assertThat(member.getUserphone()).isEqualTo("01012345678");
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void 멤버_생성_실패__이메일이_null_이거나_빈값(String email) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Member(email, "1234", "01012345678"));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void 멤버_생성_실패__패스워드가_null_이거나_빈값(String password) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Member("test@naver.com", password, "01012345678"));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void 멤버_생성_실패__휴대전화번호가_null_이거나_빈값(String userphone) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Member("test@naver.com", "1234", userphone));
	}
	
	@Test
	void 멤버_생성_실패__이메일이_공백() {
		String email = " ";
		assertThatIllegalArgumentException().isThrownBy(() -> new Member(email, "1234", "01012345678"));
	}
	
	@Test
	void 멤버_생성_실패__패스워드가_공백() {
		String password = " ";
		assertThatIllegalArgumentException().isThrownBy(() -> new Member("test@naver.com", password, "01012345678"));
	}
	
	@Test
	void 멤버_생성_실패__휴대전화번호가_공백() {
		String userphone = " ";
		assertThatIllegalArgumentException().isThrownBy(() -> new Member("test@naver.com", "1234", userphone));
	}
}