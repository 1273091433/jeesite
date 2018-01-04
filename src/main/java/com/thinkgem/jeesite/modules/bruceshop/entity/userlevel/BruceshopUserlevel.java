/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.entity.userlevel;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 会员等级Entity
 * @author admin
 * @version 2017-11-14
 */
public class BruceshopUserlevel extends DataEntity<BruceshopUserlevel> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 会员等级编码
	private String name;		// 会员等级名称
	private Integer minscore;		// 最小积分
	private Integer maxscore;		// 最大积分
	/*private String scoreRange;*/
	
	/*public String getScoreRange() {
		return scoreRange;
	}

	public void setScoreRange(String scoreRange) {
		this.scoreRange = scoreRange;
	}*/

	public BruceshopUserlevel() {
		super();
	}

	public BruceshopUserlevel(String id){
		super(id);
	}

	@Length(min=1, max=15, message="会员等级编码长度必须介于 1 和 15 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=1, max=45, message="会员等级名称长度必须介于 1 和 45 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getMinscore() {
		return minscore;
	}

	public void setMinscore(Integer minscore) {
		this.minscore = minscore;
	}
	
	public Integer getMaxscore() {
		return maxscore;
	}

	public void setMaxscore(Integer maxscore) {
		this.maxscore = maxscore;
	}
	
}