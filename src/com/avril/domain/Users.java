package com.avril.domain;
/**
 * 用户类
 */
import java.util.Date;

public class Users {

	private Games game;		//指定一个game（主要用到的属性）
	private Long userid;	
	private String username;
	private String userpwd;
	private Date userbirthday;
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public Date getUserbirthday() {
		return userbirthday;
	}
	public void setUserbirthday(Date userbirthday) {
		this.userbirthday = userbirthday;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", userbirthday="
				+ userbirthday + "]";
	}
	public Users(Long userid, String username, String userpwd, Date userbirthday) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.userbirthday = userbirthday;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Games getGame() {
		return game;
	}
	public void setGame(Games game) {
		this.game = game;
	}
	
	
	
	
}
