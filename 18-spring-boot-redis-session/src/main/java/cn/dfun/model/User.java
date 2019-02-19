package cn.dfun.model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nickName;
    private String loginBy;
    private String token;

    public User() {
		super();
	}

	public User(String nickName, String loginBy, String token) {
        this.nickName = nickName;
        this.loginBy = loginBy;
        this.token = token;
    }

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLoginBy() {
		return loginBy;
	}

	public void setLoginBy(String loginBy) {
		this.loginBy = loginBy;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
