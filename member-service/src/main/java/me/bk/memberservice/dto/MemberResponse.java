package me.bk.memberservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : byungkyu
 * @date : 2021/02/10
 * @description :
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberResponse {
	private Long id;
	private String email;
	private String nickName;

}
