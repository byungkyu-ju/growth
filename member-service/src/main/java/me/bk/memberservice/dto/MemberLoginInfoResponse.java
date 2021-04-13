package me.bk.memberservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : byungkyu
 * @date : 2021/04/12
 * @description :
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberLoginInfoResponse{
	private Long id;
	private String email;
	private String nickName;

}
