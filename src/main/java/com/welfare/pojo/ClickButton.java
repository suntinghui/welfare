package com.welfare.pojo;

public class ClickButton extends Button{
	
	//Click类型菜单key
	private String key;
	
	public ClickButton(String name, String type, String key) {
		this.setName(name);
		this.setType(type);
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
