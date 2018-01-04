/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.entity.user;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 会员管理Entity
 * @author admin
 * @version 2017-11-14
 */
public class BruceshopUser extends DataEntity<BruceshopUser> {
	
	private static final long serialVersionUID = 1L;
	private String username;		// 会员名称
	private String usernickname;		// 会员昵称
	private String password;		// 会员密码
	private String email;		// 邮箱
	private String phone;		// 电话
	private String question;		// 找回密码问题
	private String answer;		// 找回密码答案
	private Date lastlogintime;		// 最后登录时间
	private String lastloginip;		// 最后登录IP
	private Date regeistdate;		// 注册时间
	private String userlevel;		// 会员等级
	private Integer islock;		// 是否锁定用户
	private String userLevelName;
	
	public String getUserLevelName() {
		return userLevelName;
	}

	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}

	public BruceshopUser() {
		super();
	}

	public BruceshopUser(String id){
		super(id);
	}

	@Length(min=1, max=50, message="会员名称长度必须介于 1 和 50 之间")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Length(min=0, max=50, message="会员昵称长度必须介于 0 和 50 之间")
	public String getUsernickname() {
		return usernickname;
	}

	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}
	
	@Length(min=1, max=50, message="会员密码长度必须介于 1 和 50 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=50, message="邮箱长度必须介于 0 和 50 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=20, message="电话长度必须介于 0 和 20 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=100, message="找回密码问题长度必须介于 0 和 100 之间")
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Length(min=0, max=100, message="找回密码答案长度必须介于 0 和 100 之间")
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	
	@Length(min=0, max=45, message="最后登录IP长度必须介于 0 和 45 之间")
	public String getLastloginip() {
		return lastloginip;
	}

	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRegeistdate() {
		return regeistdate;
	}

	public void setRegeistdate(Date regeistdate) {
		this.regeistdate = regeistdate;
	}
	
	@Length(min=0, max=64, message="会员等级长度必须介于 0 和 64 之间")
	public String getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}
	
	public Integer getIslock() {
		return islock;
	}

	public void setIslock(Integer islock) {
		this.islock = islock;
	}
	
}