package com.gss.web.domain;

import org.apache.logging.log4j.util.Strings;

import com.google.common.base.Preconditions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	private String email;
	private String userpassword;
	private String userphone;
	
	public Member(String email, String userpassword, String userphone) {
		Preconditions.checkArgument(Strings.isNotBlank(email));
		Preconditions.checkArgument(Strings.isNotBlank(userpassword));
		Preconditions.checkArgument(Strings.isNotBlank(userphone));
		
		this.email = email;
		this.userpassword = userpassword;
		this.userphone = userphone;
	}
}	
