package me.bk.memberservice.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.bk.memberservice.Member;
import me.bk.memberservice.dto.MemberCreateRequest;
import me.bk.memberservice.dto.MemberLoginInfoRequest;
import me.bk.memberservice.dto.MemberLoginInfoResponse;
import me.bk.memberservice.repository.MemberRepository;

/**
 * @author : byungkyu
 * @date : 2021/04/12
 * @description :
 **/
@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public Long createMember(MemberCreateRequest request) {
		Optional<Member> findMember = memberRepository.findByEmail(request.getEmail());

		if(!findMember.isEmpty()){
			throw new IllegalArgumentException("존재하는 회원");
		}
		Member newMember = Member.createMember()
			.email(request.getEmail())
			.password(request.getPassword())
			.nickName(request.getNickName())
			.build();

		Member savedMember = memberRepository.save(newMember);

		return savedMember.getId();
	}

	public MemberLoginInfoResponse findMemberLoginInfo(MemberLoginInfoRequest request) {
		Member findMember = findByEmail(request.getEmail());
		if (!findMember.isEqualPassword(request.getPassword())) {
			throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");
		}
		return new MemberLoginInfoResponse(findMember.getId(), findMember.getEmail(), findMember.getNickName());
	}

	private Member findByEmail(String email) {
		return memberRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
	}
}
