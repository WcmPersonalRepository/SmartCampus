package com.nepo.weixin.manage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nepo.weixin.constants.WeiXinConstants;
import com.nepo.weixin.pojo.AccessToken;
import com.nepo.weixin.pojo.Button;
import com.nepo.weixin.pojo.CommonButton;
import com.nepo.weixin.pojo.ComplexButton;
import com.nepo.weixin.pojo.Menu;
import com.nepo.weixin.pojo.ViewButton;
import com.nepo.weixin.util.WeixinUtil;
public class MenuManager {
	private static Logger logger = LoggerFactory.getLogger(MenuManager.class);
	public static void main(String[] args) {
		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(WeiXinConstants.APP_ID, WeiXinConstants.APP_SECRET);
		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());
			// 判断菜单创建结果
			if (0 == result)
				logger.info("菜单创建成功！");
			else
				logger.info("菜单创建失败，错误码：" + result);
		}
	}
	/**
	 * 组装菜单数据
	 * @return
	 */
	private static Menu getMenu() {
		CommonButton btn11 = new CommonButton();
		btn11.setName("产品服务");
		btn11.setType("click");
		btn11.setKey("11");
		CommonButton btn12 = new CommonButton();
		btn12.setName("各方收益");
		btn12.setType("click");
		btn12.setKey("12");
		CommonButton btn13 = new CommonButton();
		btn13.setName("成功案例");
		btn13.setType("click");
		btn13.setKey("13");
		CommonButton btn14 = new CommonButton();
		btn14.setName("关于我们 ");
		btn14.setType("click");
		btn14.setKey("14");
		ViewButton btn15 = new ViewButton();
		btn15.setName("常见问题");
		btn15.setType("view");
		btn15.setUrl("http://www.finshare.cn/html/question.jsp");
		ViewButton btn21 = new ViewButton();
		btn21.setName("贷款查询 ");
		btn21.setType("view");
		btn21.setUrl("http://www.finshare.cn/");
		ViewButton btn22 = new ViewButton();
		btn22.setName("预存费用查询");
		btn22.setType("view");
		btn22.setUrl("http://www.finshare.cn/");
		ViewButton btn23 = new ViewButton();
		btn23.setName("可融资票据查询");
		btn23.setType("view");
		btn23.setUrl("http://www.finshare.cn/");
		ViewButton btn31 = new ViewButton();
		btn31.setName("会员申请");
		btn31.setType("view");
		btn31.setUrl("http://www.finshare.cn/");
		ViewButton btn32 = new ViewButton();
		btn32.setName("我要融资");
		btn32.setType("view");
		btn32.setUrl("http://www.finshare.cn/");
		ViewButton btn33 = new ViewButton();
		btn33.setName("我要还款");
		btn33.setType("view");
		btn33.setUrl("http://www.finshare.cn/");
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("了解飞象 ");
		mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14, btn15 });
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("我的飞象");
		mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23 });
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("飞象服务");
		mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33 });
		/**
		 * 这是公众号robot目前的菜单结构，每个一级菜单都有二级菜单项<br> 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是"更多体验"，而直接是"幽默笑话"，那么menu应该这样定义：<br> menu.setButton(new
		 * Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
		return menu;
	}
}
