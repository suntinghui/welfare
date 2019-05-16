package com.welfare.model;

/**
 * id (integer, optional): id ,
idAcct (string, optional),
nickName (string, optional): 微信昵称 ,
openid (string, optional): 微信openid ,
sex (integer, optional): 性别 ,
status (integer, optional)
 * @author SunTH
 *
 */

public class Member {

	private int id;
	private String idAcct;
	private String openid;
	private int sex;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdAcct() {
		return idAcct;
	}
	public void setIdAcct(String idAcct) {
		this.idAcct = idAcct;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", idAcct=" + idAcct + ", openid=" + openid + ", sex=" + sex + ", status=" + status
				+ "]";
	}
	
	
	
}
