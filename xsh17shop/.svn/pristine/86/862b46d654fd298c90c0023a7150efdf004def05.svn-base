package com.bdqn.web.smsValidate;

import java.util.Random;

import org.apache.struts2.ServletActionContext;

import com.bdqn.web.smsValidate.common.Config;
import com.bdqn.web.smsValidate.common.HttpUtil;


/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	static int code=new Random().nextInt(9000)+1000;
	static String s = String.valueOf(code);
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String smsContent = "【北大青鸟】您的验证码为"+s+"，请于1分钟内正确输入，如非本人操作，请忽略此短信。";

	/**
	 * 验证码通知短信
	 */
	public static String execute(String phone)
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + phone + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
		return s;
	}
}
