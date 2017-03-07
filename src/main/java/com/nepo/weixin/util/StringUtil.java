package com.nepo.weixin.util;

import java.util.Random;

import net.sf.json.JSONObject;

public class StringUtil {
	/**
	 * 获取4位数字验证码
	 * 
	 * @return
	 */
	public static String get4Yzm() {
		Random mRandom = new Random();
		String yzm = "";
		for (int i = 0; i < 4; i++) {
			yzm = yzm + mRandom.nextInt(10);
		}
		return yzm;
	}

	public static String getJsonByKey(JSONObject jsonObj, String key) {
		try {
			String v = jsonObj.getString(key);
			return v;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
