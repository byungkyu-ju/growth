package me.bk.memberservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : byungkyu
 * @date : 2021/04/12
 * @description :
 **/
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class MemberCreateRequest {
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String nickname;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	private String confirmPassword;
}