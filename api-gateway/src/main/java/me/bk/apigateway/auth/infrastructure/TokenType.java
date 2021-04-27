package me.bk.apigateway.auth.infrastructure;

/**
 * @author : byungkyu
 * @date : 2021/04/27
 * @description :
 **/
public enum TokenType {

	//(days/1) (hours/day) (minutes/hour) (seconds/minute) (miliseconds/second)
	ACCESS_TOKEN(60*60*1000),
	REFRESH_TOKEN(7*24*60*60*1000);

	private int expireTime;

	TokenType(int expireTime) {
		this.expireTime = expireTime;
	}

	public int getExpireTime() {
		return expireTime;
	}
}
