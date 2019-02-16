package com.miaodiyun.httpApiDemo;

import java.net.URLEncoder;
import java.util.Random;

import com.miaodiyun.httpApiDemo.common.Config;
import com.miaodiyun.httpApiDemo.common.HttpUtil;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS {
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;

	/**
	 * 验证码通知短信
	 */
	public static void execute(String to, String smsContent) {
		smsContent = "【米苏科技】您的验证码为" + smsContent + "，请于30分钟内正确输入，如非本人操作，请忽略此短信。";
		String tmpSmsContent = null;
		try {
			tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
		} catch (Exception e) {

		}
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}

	/**
	 * 产生随机验证码
	 * 
	 * @param n
	 *            验证码的位数
	 * @return
	 */
	public static String getRandomNum(int n) {
		Random random = new Random();
		String str = "";
		for (int i = 0; i < n; i++) {
			int nextInt = random.nextInt(10);
			str += (nextInt + "");
		}
		return str;
	}
}
