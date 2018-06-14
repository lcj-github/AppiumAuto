package com.lcj.deom.handler;

import java.util.Map;

import com.lcj.deom.base.TestStep;
import com.lcj.deom.util.HttpRequestUtil;
import com.lcj.deom.util.SeleniumUtil;

/**
 * http请求动作处理类
 */
public class HttpRequestHandler {
	
	/**
	 *指定API接口URL,获取Cookie
	 * @param map
	 * @param step
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	public void getCookie(TestStep step) throws Exception{
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
//		String ApiUrl = ConfigUtil.getProperty("test.api."+step.getUrl()+"", Constants.CONFIG_COMMON);
		String ApiUrl = step.getUrl();
		String Param = "{\"userId\": \"666666\",\"password\": \"612426\",\"type\": \"string\",\"version\": \"string\",\"identification\": \"string\"}";
        Map<String, String> CookieVal =HttpRequestUtil.GetPostCookie(ApiUrl,Param);
	}
	
	/**
	 * 指定API接口URL,发送POST请求
	 * @param map
	 * @param step
	 * @throws Exception 
	 */
	public void sendPost(TestStep step) throws Exception{
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
//		String ApiUrl = ConfigUtil.getProperty("test.api."+step.getUrl()+"", Constants.CONFIG_COMMON);
		String ApiUrl = step.getUrl();
		String Param = "{\""+step.getBody()+"\": \""+SeleniumUtil.parseStringHasEls(step.getValue())+"\"}";
         HttpRequestUtil.SendPost(ApiUrl,Param);
//         System.out.println("接口详情:" + ApiUrl+"  "+Param);
	}

}
