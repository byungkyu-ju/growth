package me.bk.memberservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String nickname;

	@Builder(builderMethodName = "createMember")
	public Member(String email, String password, String nickname) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}

	public boolean isEqualPassword(String confirmPassword) {
		return this.password.equals(confirmPassword);
	}

	public void checkPassword(String password) {
		if (!this.password.equals(password)) {
			throw new IllegalArgumentException("비밀번호 오류");
		}
	}
}