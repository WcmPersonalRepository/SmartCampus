package com.nepo.weixin.pojo.message;
/**
 * 发送客服消息基础类
 * @author xpeng
 */
public class BaseMessage {
	private String touser;
	private String msgtype;
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
