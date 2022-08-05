package com.mid.common;

import java.util.Objects;

public class OAuthToken {
	private String access_token;
	private String token_type;
	private String refresh_token;
	private int expires_in;
	private String scope;
	private int refresh_token_expires_in;
	
	
	@Override
	public String toString() {
		return "OAuthToken [access_token=" + access_token + ", token_type=" + token_type + ", refresh_token="
				+ refresh_token + ", expires_in=" + expires_in + ", scope=" + scope + ", refresh_token_expires_in="
				+ refresh_token_expires_in + "]";
	}
	public OAuthToken() {
		super();
	}
	public OAuthToken(String access_token, String token_type, String refresh_token, int expires_in, String scope,
			int refresh_token_expires_in) {
		super();
		this.access_token = access_token;
		this.token_type = token_type;
		this.refresh_token = refresh_token;
		this.expires_in = expires_in;
		this.scope = scope;
		this.refresh_token_expires_in = refresh_token_expires_in;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(access_token, expires_in, refresh_token, refresh_token_expires_in, scope, token_type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OAuthToken other = (OAuthToken) obj;
		return Objects.equals(access_token, other.access_token) && expires_in == other.expires_in
				&& Objects.equals(refresh_token, other.refresh_token)
				&& refresh_token_expires_in == other.refresh_token_expires_in && Objects.equals(scope, other.scope)
				&& Objects.equals(token_type, other.token_type);
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public int getRefresh_token_expires_in() {
		return refresh_token_expires_in;
	}
	public void setRefresh_token_expires_in(int refresh_token_expires_in) {
		this.refresh_token_expires_in = refresh_token_expires_in;
	}
	
	
}
