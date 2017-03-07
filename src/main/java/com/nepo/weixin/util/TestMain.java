package com.nepo.weixin.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.nepo.weixin.pojo.Data;
import com.nepo.weixin.pojo.TemplateContent;
import com.nepo.weixin.pojo.TemplteMassage;

public class TestMain {

	public static void main(String[] args) {
		/*System.out.println(getDateStr(1440127347000l));
		System.out.println(getDateStr(1440128459596l));
		
		System.out.println(new Date().getTime())*/;
		
		
	}

	private static String getDateStr(long millis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(millis);
		Formatter ft = new Formatter(Locale.CHINA);
		return ft.format("%1$tY年%1$tm月%1$td日%1$tA，%1$tT %1$tp", cal).toString();
	}
}
