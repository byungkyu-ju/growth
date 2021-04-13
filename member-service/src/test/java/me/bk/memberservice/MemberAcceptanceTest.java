package me.bk.memberservice;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import me.bk.memberservice.dto.MemberCreateRequest;
import me.bk.memberservice.dto.MemberLoginInfoRequest;

/**
 * @author : byungkyu
 * @date : 2021/04/12
 * @description :
 **/
public class MemberAcceptanceTest extends AcceptanceTest{
	public static final String EMAIL = "test@gmail.com";
	public static final String PASSWORD = "password";
	public static final String PASSWORD_CONFIRM = "password";
	public static final String NICK_NAME = "tester";

	@DisplayName("사용자는 회원가입을 할 수 있다.")
	@Test
	void 사용자는_회원가입을_할_수_있다() {
		// when
		ExtractableResponse<Response> createResponse = 회원_생성(EMAIL, PASSWORD, PASSWORD_CONFIRM, NICK_NAME);
		// then
		회원이_등록됨(createResponse);
	}

	private void 회원이_등록됨(ExtractableResponse<Response> response) {
		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

	private ExtractableResponse<Response> 회원_생성(String email, String password, String passwordConfirm, String nickName) {
		MemberCreateRequest request = MemberCreateRequest.builder()
			.email(email)
			.password(password)
			.passwordConfirm(passwordConfirm)
			.nickName(nickName)
			.build();

		return RestAssured
			.given().log().all()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(request)
			.when().post("/member")
			.then().log().all()
			.extract();
	}

	@DisplayName("사용자는 로그인 기본정보를 확인할 수 있다.")
	@Test
	void 사용자는_자신의_정보를_관리할_수_있다(){
		// given
		ExtractableResponse<Response> createResponse = 회원_생성(EMAIL, PASSWORD, PASSWORD_CONFIRM, NICK_NAME);
		회원이_등록됨(createResponse);
		// when
		ExtractableResponse<Response> findResponse = 로그인_기본_정보_조회(EMAIL, PASSWORD);
		// then
		로그인_기본_정보가_조회된다(findResponse);
	}

	private void 로그인_기본_정보가_조회된다(ExtractableResponse<Response> findResponse) {
		assertThat(findResponse.statusCode()).isEqualTo(HttpStatus.OK.value());
	}

	private ExtractableResponse<Response> 로그인_기본_정보_조회(String email, String password) {
		MemberLoginInfoRequest request = new MemberLoginInfoRequest(email, password);
		return RestAssured
			.given().log().all()
			.body(request)
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.when().post("/member/loginInfo")
			.then().log().all().extract();
	}


}
