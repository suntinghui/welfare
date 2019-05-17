package com.welfare.pojo;

public class ViewButton extends Button{
	//view类型菜单url
	private String url;
	
	public ViewButton() {
		
	}
	
	public ViewButton(String name, String type, String url) {
		this.setName(name);
		this.setType(type);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
