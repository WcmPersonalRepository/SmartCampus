package com.nepo.weixin.constants;

import java.util.List;
import java.util.Properties;


public class GlobalConfig {
	/**-------------------------------------------升级前必须检查---------------------------------------------*/
	//映射地址
	//public static String MAPPING_ADDRESS="http://s15n298903.imwork.net";
	public static String MAPPING_ADDRESS="http://15n894841q.iask.in";
	/**----------------------------------------------------------------------------------------*/
	
	
	//查看公告测试数据
	public static final String REDMES="{\"code\":\"0\",\"ggmsg\":\"这里是公告的内容这里是公告的内容这里是公告的内容这里是公告的内容这里是公告的内容这里是公告的内容这里是公告的内容这里是公告的内容这里是公告的内容这里是公告的内容这里是公告的内容\",\"title\":\"这里是公告的标题\"}";
	public static final String ACCOUNT="{\"code\":\"0\",\"goldenEggsCount\":\"0\",\"myGoldenEggs\":\"5\",\"real\":\"0\"}";
	public static final String INDEX="{\"code\":\"0\",\"msg\":\"登录成功!\",\"investment\":1,\"noviceArea\":\"0\",\"userInfo\":{\"userId\":\"481\",\"userName\":\"smile\"},\"announcements\":[{\"id\":\"50\",\"title\":\"蛋粉给力，我要金蛋首标纪录诞生\"},{\"id\":\"54\",\"title\":\"热烈庆祝我要金蛋网正式上线\"}],\"recommend\":[{\"pid\":\"1000\",\"zhl\":\"14\",\"startjy\":\"\",\"typecode\":\"001\",\"xydj\":\"1\",\"name\":\"投资测试\",\"qx\":\"1个月\",\"tzjy\":0.01}]}";
	public static final String INVESTDETAIL="{\"code\":\"0\",\"zhl\":\"16\",\"typecode\":\"002\",\"investmentRecord\":[],\"borrower\":[],\"syfs\":\"每月还息，到期还本\",\"pid\":\"853\",\"code\":\"0\",\"tzjy\":300,\"startjy\":\"50\",\"xydj\":\"\",\"name\":\"企业资金周转\",\"qx\":\"3个月\",\"blancetzjy\":\"3000000\"}";
	
	//错误提示语
	public static final String ERROR_LOGING_NOUSERNAME = "请输入用户名或手机号";
	public static final String ERROR_LOGIN_NOPWD = "请输入不小于6位的密码";
	public static final String ERROR_REGIST_NOUSERNAME = "请输入正确的手机号";
	public static final String ERROR_REGIST_VERIFICATIONCODE ="验证码错误，请重新输入";
	
	//模板消息内容
	public static final String TEMPLETE_MASSAGE_RECHARGE_SUCCESS="恭喜您充值成功！";
	public static final String CORPORATE_NAME="深圳市伯利滋财富管理有限公司";
	
	
	//界面上的优化数据，自定义数据均包含在daffyData层里。
	/*这里是api       banner:[{img:name,url:address}]*/
	public static final String DATA_DAFFY_INDEX ="{\"daffyData\":{\"banner\":[{\"name\":\"img1\",\"url\":\"img/user/main_banner1.png\"},{\"name\":\"img2\",\"url\":\"img/user/main_banner1.png\"}]}}";
	
	/**
	 * 返回成功编码
	 */
	public static final String SUCCESS_CODE = "0";
	/**
	 * 异常提示信息Key
	 */
	public static final String MSG_EXCEPTION_KEY = "msg";
	/**
	 * 异常信息提示
	 */
	public static final String MSG_EXCEPTION_VALUE = "网络错误,请再次尝试!";
	/**
	 * 验证码错误提示
	 */
	public static final String MSG_SAFE_CODE_ERROR = "验证码错误，请重新输入!";
	/**
	 * 功能待开发界面提示
	 */
	public static final String MSG_TO_DEVELOPED = "正在进行中。。。";
	/**
	 * 待回款
	 */
	public static final String PAYMENT_TYPE_WAIT = "1";
	/**
	 * 已回款
	 */
	public static final String PAYMENT_TYPE_ALREADY = "2";
	
	/**
	 * 登录
	 */
	public static final String TRANSID_LOGIN = "LOGIN";
	/**
	 * 注册
	 */
	public static final String TRANSID_REGISTER = "REGISTER";
	/**
	 * 我的账户
	 */
	public static final String TRANSID_MYACCOUNTDETAIL = "MYACCOUNTDETAIL";
	/**
	 * 查看公告
	 */
	public static final String TRANSID_REDMES = "REDMES";
	/**
	 * 账户详情
	 */
	public static final String TRANSID_ACCOUNTDETAIL = "ACCOUNTDETAIL";
	/**
	 * 个人设置
	 */
	public static final String TRANSID_PERSONALSTETTING = "PERSONALSTETTING";
	/**
	 * 银行卡认证
	 */
	public static final String TRANSID_BANKCHECK = "BANKCHECK";
	/**
	 * 银行卡列表
	 */
	public static final String TRANSID_GOMYBANKS = "GOMYBANKS";
	/**
	 * 重置密码
	 */
	public static final String TRANSID_FINDLPASS = "FINDLPASS";
	/**
	 * 修改登录密码
	 */
	public static final String TRANSID_UPDATELPASS = "UPDATELPASS";
	/**
	 * 修改交易密码
	 */
	public static final String TRANSID_UPDATEPPASS = "UPDATEPPASS";
	/**
	 * 发送短信验证码
	 */
	public static final String TRANSID_SENTPHONEMSG = "SENTPHONEMSG";
	/**
	 * 写人充值记录
	 */
	public static final String TRANSID_RECEIVERPAY="RECEIVERPAY";
	/**
	 * 我的投资
	 */
	public static final String TRANSID_GOMYTB = "GOMYTB";
	/**
	 * 资金明细
	 */
	public static final String TRANSID_GOMYSY = "GOMYSY";
	/**
	 * 新手标
	 */
	public static final String TRANSID_GETNEWPRO = "GETNEWPRO";
	/**
	 * 投资理财详情
	 */
	public static final String TRANSID_INVESTDETAILS = "INVESTDETAILS";
	/**
	 * 投资理财列表
	 */
	public static final String TRANSID_INVESTPOCKET = "INVESTPOCKET";
	/**
	 * 投标
	 */
	public static final String TRANSID_TBPROTRAN = "TBPROTRAN";
	/**
	 * 实名认证
	 */
	public static final String TRANSID_CHECKPHONEMSG = "REALVERIFICATION";
	/**
	 * 申请提现
	 */
	public static final String TRANSID_GOTXAPPLY = "GOTXAPPLY";
	/**
	 * 提交提现
	 */
	public static final String TRANSID_TXCOMMIT = "TXCOMMIT";
	
	/**
	 * 充值记录
	 */
	public static final String TRANSID_GOCZLIST = "GOCZLIST";
	/**
	 * 提现记录
	 */
	public static final String TRANSID_GOTXLIST = "GOTXLIST";

	/********** 国付宝支付接口 **********/ 
	/**
	 * 网关版本号
	 */
	public static String GOPAY_VERSION = "2.1";
	/**
	 * 字符集GBK
	 */
	public static String GOPAY_CHARSET_GBK = "1";
	/**
	 * 字符集UTF8
	 */
	public static String GOPAY_CHARSET_UTF8 = "2";
	/**
	 * 网关语言中文
	 */
	public static String GOPAY_LANGUAGE_ZN = "1";
	/**
	 * 网关语言英文
	 */
	public static String GOPAY_LANGUAGE_EN = "2";
	/**
	 * 报文加密方式md5
	 */
	public static String GOPAY_SIGN_TYPE_MD5 = "1";
	/**
	 * 报文加密方式sha
	 */
	public static String GOPAY_SIGN_TYPE_SHA = "2";
	/**
	 * 交易代码支付网关接口必须为8888
	 */
	public static String GOPAY_TRAN_CODE = "8888";
	/**
	 * 币种人民币
	 */
	public static String GOPAY_CURRENCY_TYPE_CNY = "156";
	/**
	 * 商户前台通知地址
	 */
	public static String GOPAY_FRONT_MER_URL = "";
	/**
	 * 商户后台通知地址
	 */
	//public static final String GOPAY_BACKGROUND_MER_URL = "http://zp19827.xicp.net/p2p/account/resRecharge";
	//public static final String GOPAY_BACKGROUND_MER_URL = "http://co14997265.iok.la/system/account/resRecharge";
	public static String GOPAY_BACKGROUND_MER_URL = MAPPING_ADDRESS+"/blz/account/resRecharge";
	/**
	 * 成功返回地址刷新账户余额
	 */
//	public static final String GOPAY_JUMP_URL = "http://system/account/myAccount";
	//public static final String GOPAY_JUMP_URL = "http://co14997265.iok.la/system/account/myAccount";
	public static String GOPAY_JUMP_URL = MAPPING_ADDRESS+"/blz/account/myAccount";
	/** 
	 * 用户浏览器IP固定值
	 */
	public static String GOPAY_TRANIP = "127.0.0.1";
	/**
	 * 订单不允许重复提交
	 */
	public static String GOPAY_IS_NO_REPEAT_SUBMIT = "0";
	/**
	 * 订单允许重复提交
	 */
	public static String GOPAY_IS_REPEATSUBMIT = "1";
	/**
	 * 移动支付标记固定值
	 */
	public static String GOPAY_BUYER_NAME = "MWEB";
	/**
	 * 商户提取佣金金额固定值0.00
	 */
	public static String GOPAY_FEE_AMT = "0.00";
	/**
	 * 测试环境商户代码用户ID
	 */
	public static String GOPAY_TEST_MERCHANT_ID = "0000001502";
	/**
	 * 测试环境商户识别码
	 */
	public static String GOPAY_TEST_VERFICATION_CODE = "11111aaaaa";
	/**
	 * 测试环境国付宝转入账户
	 */
	public static String GOPAY_TEST_VIRCARD_NOIN = "0000000002000000257";
	/**
	 * 测试环境国付宝提交地址
	 */
	public static String GOPAY_TEST_URL = "https://gatewaymer.gopay.com.cn/Trans/MobileClientAction.do";
	/**
	 * 正式商户代码用户ID
	 */
	public static String GOPAY_PROD_MERCHANT_ID = "0000001292";
	/**
	 * 正式商户识别码
	 */
	public static String GOPAY_PROD_VERFICATION_CODE = "Blz20148881224";
	/**
	 * 正式国付宝转入账户
	 */
	public static String GOPAY_PROD_VIRCARD_NOIN = "0000000002000000180";
	/**
	 * 正式国付宝提交地址
	 */
	public static String GOPAY_PROD_URL = "https://gateway.gopay.com.cn/Trans/MobileClientAction.do";
	/**
	 * 交易成功
	 */
	public static String GOPAY_RESP_CODE_SUCCESS = "0000";
	/**
	 * 记录接口返回订单ID
	 */
	public static String GOPAY_ORDERID = null;
	/**
	 * 是否是正式环境模式
	 */
	public static boolean PROD_MODE = false;
	
	/**
	 * 资源文件对象
	 */
	public static Properties PROP = null;
	
	/**
	 * 测试JSON
	 */
	public static String TESTJSON= "{\"code\":\"0\",\"synthesis\":[{\"zhl\":\"15\",\"startjy\":\"50\",\"typecode\":\"001\",\"xydj\":\"3\",\"name\":\"开发测试标6\",\"qx\":\"5个月\",\"pid\":\"1041\",\"tzjy\":0.01},{\"zhl\":\"11\",\"startjy\":\"50\",\"typecode\":\"001\",\"xydj\":\"2\",\"name\":\"开发测试标4\",\"qx\":\"2个月\",\"pid\":\"1039\",\"tzjy\":0.01},{\"zhl\":\"13\",\"startjy\":\"50\",\"typecode\":\"001\",\"xydj\":\"2\",\"name\":\"开发测试标4\",\"qx\":\"4个月\",\"pid\":\"1039\",\"tzjy\":0.01}]}";
	
	/**
	 * 测试JSON1
	 */
	public static String TESTJSON1= "[{\"zhl\":\"15\",\"startjy\":\"50\",\"typecode\":\"001\",\"xydj\":\"3\",\"name\":\"开发测试标6\",\"qx\":\"5个月\",\"pid\":\"1041\",\"tzjy\":0.01},{\"zhl\":\"11\",\"startjy\":\"50\",\"typecode\":\"001\",\"xydj\":\"2\",\"name\":\"开发测试标4\",\"qx\":\"2个月\",\"pid\":\"1039\",\"tzjy\":0.01},{\"zhl\":\"13\",\"startjy\":\"50\",\"typecode\":\"001\",\"xydj\":\"2\",\"name\":\"开发测试标4\",\"qx\":\"6个月\",\"pid\":\"1039\",\"tzjy\":0.01}]";
	
	
}
