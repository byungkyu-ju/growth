package me.bk.memberservice.application;

import static me.bk.memberservice.MemberAcceptanceTest.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import me.bk.memberservice.Member;
import me.bk.memberservice.dto.MemberCreateRequest;
import me.bk.memberservice.repository.MemberRepository;

/**
 * @author : byungkyu
 * @date : 2021/04/12
 * @description :
 **/
@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
	@Mock
	private MemberRepository memberRepository;

	private MemberService memberService;

	@BeforeEach
	void setUp() {
		this.memberService = new MemberService(memberRepository);
	}

	@Test
	void createMember() {
		// given
		MemberCreateRequest request = MemberCreateRequest.builder()
			.email(EMAIL)
			.password(PASSWORD)
			.passwordConfirm(PASSWORD_CONFIRM)
			.nickName(NICK_NAME)
			.build();

		when(memberRepository.findByEmail(request.getEmail())).thenReturn(Optional.empty());
		when(memberRepository.save(any())).thenReturn(new Member(EMAIL, PASSWORD, NICK_NAME));
		// when
		Long savedMemberId = memberService.createMember(request);

		// then
		assertThat(savedMemberId).isNotNull();
	}
}