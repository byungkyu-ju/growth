package me.bk.memberservice.api;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.bk.memberservice.Member;
import me.bk.memberservice.application.MemberService;
import me.bk.memberservice.dto.MemberCreateRequest;
import me.bk.memberservice.dto.MemberLoginInfoRequest;
import me.bk.memberservice.dto.MemberLoginInfoResponse;

/**
 * @author : byungkyu
 * @date : 2021/04/12
 * @description :
 **/
@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/member")
	public ResponseEntity<Long> createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
		Long savedMemberId = memberService.createMember(memberCreateRequest);
		return ResponseEntity.created(URI.create("/members/" + savedMemberId)).build();
	}

	@PostMapping("/member/loginInfo")
	public ResponseEntity<MemberLoginInfoResponse> findMemberLoginInfo(@RequestBody MemberLoginInfoRequest request) {
		return ResponseEntity.ok().body(memberService.findMemberLoginInfo(request));
	}
}
