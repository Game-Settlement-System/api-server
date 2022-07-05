package com.gss.common;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class GssUserDTO {
	private String email;
	private String userPassword;
	private String userPhone;
}
