package me.bk.memberservice.api;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
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

	@PostMapping("/members")
	public ResponseEntity<Long> createMember(@Valid @RequestBody MemberCreateRequest memberCreateRequest) {
		Long savedMemberId = memberService.createMember(memberCreateRequest);
		return ResponseEntity.created(URI.create("/members/" + savedMemberId)).build();
	}

	@PostMapping("/members/loginInfo")
	public ResponseEntity<MemberLoginInfoResponse> findMemberLoginInfo(@RequestBody MemberLoginInfoRequest request) {
		return ResponseEntity.ok().body(memberService.findMemberLoginInfo(request));
	}

	@GetMapping("/members")
	public ResponseEntity<MemberLoginInfoResponse> getTest() {
		return ResponseEntity.ok().body(new MemberLoginInfoResponse(1L, "dummy", "nick","password"));
	}

	@CrossOrigin("http://localhost:30000")
	@GetMapping("/members/{email}")
	public ResponseEntity<MemberLoginInfoResponse> findMemberByEmail(@PathVariable String email) {
		return ResponseEntity.ok().body(new MemberLoginInfoResponse(1L, "dummy", "nick", "password"));
	}
}
