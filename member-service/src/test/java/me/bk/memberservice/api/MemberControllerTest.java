package me.bk.memberservice.api;

import static me.bk.memberservice.MemberAcceptanceTest.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import me.bk.memberservice.application.MemberService;
import me.bk.memberservice.dto.MemberCreateRequest;
import me.bk.memberservice.dto.MemberLoginInfoRequest;
import me.bk.memberservice.dto.MemberLoginInfoResponse;

/**
 * @author : byungkyu
 * @date : 2021/04/12
 * @description :
 **/
public class MemberControllerTest {

	private MemberController memberController;

	@Mock
	private MemberService memberService;

	@BeforeEach
	void setUp() {
		this.memberController = new MemberController(memberService);
	}

	@DisplayName("회원 생성")
	@Test
	void createMember() {
		// given
		MemberCreateRequest request = MemberCreateRequest.builder()
			.email(EMAIL)
			.password(PASSWORD)
			.passwordConfirm(PASSWORD_CONFIRM)
			.nickName(NICK_NAME)
			.build();

		// when
		when(memberService.createMember(request)).thenReturn(1L);
		ResponseEntity response = memberController.createMember(request);

		// then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

	@DisplayName("회원의 로그인 정보 조회")
	@Test
	void findMemberLoginInfo() {
		// given
		MemberLoginInfoRequest request = MemberLoginInfoRequest.builder()
			.email(EMAIL)
			.password(PASSWORD)
			.build();

		// when
		when(memberService.findMemberLoginInfo(any())).thenReturn(new MemberLoginInfoResponse(1L, EMAIL, NICK_NAME));
		ResponseEntity response = memberController.findMemberLoginInfo(request);

		// then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
