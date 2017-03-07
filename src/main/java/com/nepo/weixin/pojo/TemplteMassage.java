package com.nepo.weixin.pojo;

import java.util.Map;


public class TemplteMassage {
	public String touser;
	public String template_id;
	public String url;
	public Map<String, TemplateContent> data;
	
	public TemplteMassage(String touser, String template_id, String url,
			Map<String, TemplateContent> data) {
		super();
		this.touser = touser;
		this.template_id = template_id;
		this.url = url;
		this.data = data;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, TemplateContent> getData() {
		return data;
	}
	public void setData(Map<String, TemplateContent> data) {
		this.data = data;
	}
	
	
}
