package com.bdqn.web.smsValidate;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// 获取开发者账号信息
		//AccountInfo.execute();

		// 验证码通知短信接口
		IndustrySMS.execute("18716667528");

		// 会员营销短信接口
		// AffMarkSMS.execute();

		// 短信邮验证码通知短信接口
		// IndustryEmailSMS.execute();

		// 短信邮验证码通知短信接口
		// AffMarkEmailSMS.execute();

		// 语音验证码
		// VoiceCode.execute();

	}
}
