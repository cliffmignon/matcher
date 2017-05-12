package com.cliff.entity;

import java.util.Date;
/**
 * 用户表
 * @author Cliff
 *
 */
public class User {
	private String userid;
	
	private String nickid;
	
	private Date adddate;//注册日期
	
	private Integer integral;//积分
	
	private String rank;//段位 青铜0 白银100 黄金300 白金600 钻石900 大师1200 王者1500
	
	private Integer continueWin;//连胜记录
	
	private Integer heronum;//英雄数
	
	private int mobilebind;//是否绑定手机 0未绑定1绑定
	
	private String mobileno;//手机号
}
