package com.gss.web.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class MemberTest {

	@Test
	void ���_����_����() {
		final Member member = new Member("test@naver.com", "1234", "01012345678");
		
		assertThat(member.getEmail()).isEqualTo("test@naver.com");
		assertThat(member.getUserpassword()).isEqualTo("1234");
		assertThat(member.getUserphone()).isEqualTo("01012345678");
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void ���_����_����__�̸�����_null_�̰ų�_��(String email) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Member(email, "1234", "01012345678"));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void ���_����_����__�н����尡_null_�̰ų�_��(String password) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Member("test@naver.com", password, "01012345678"));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void ���_����_����__�޴���ȭ��ȣ��_null_�̰ų�_��(String userphone) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Member("test@naver.com", "1234", userphone));
	}
	
	@Test
	void ���_����_����__�̸�����_����() {
		String email = " ";
		assertThatIllegalArgumentException().isThrownBy(() -> new Member(email, "1234", "01012345678"));
	}
	
	@Test
	void ���_����_����__�н����尡_����() {
		String password = " ";
		assertThatIllegalArgumentException().isThrownBy(() -> new Member("test@naver.com", password, "01012345678"));
	}
	
	@Test
	void ���_����_����__�޴���ȭ��ȣ��_����() {
		String userphone = " ";
		assertThatIllegalArgumentException().isThrownBy(() -> new Member("test@naver.com", "1234", userphone));
	}
}
