package me.bk.memberservice.dto;

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
	private String email;
	private String password;
	private String confirmPassword;
	private String nickName;
}