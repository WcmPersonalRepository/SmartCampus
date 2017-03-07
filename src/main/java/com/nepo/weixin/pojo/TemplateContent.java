package com.nepo.weixin.pojo;

public class TemplateContent {
	public String value;
	public String color="#173177";
	
	public TemplateContent(String value) {
		super();
		this.value = value;
	}
	public TemplateContent(String value, String color) {
		super();
		this.value = value;
		this.color = color;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
