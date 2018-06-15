package com.lcj.deom.handler;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.lcj.deom.base.TestStep;
import com.lcj.deom.util.AppiumUtil;
import com.lcj.deom.util.SeleniumUtil;

public class InputActionHandler {
	
	/**
	 * <br>Web端输入操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void webInput(TestStep step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getWebDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement e = SeleniumUtil.getElement(step);
		e.clear();
		e.sendKeys(SeleniumUtil.parseStringHasEls(step.getValue()));	
	}
	
	/**
	 * <br>Android端输入操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void androidInput(TestStep step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement e = AppiumUtil.getElement(step);
		e.clear();
		String inputVal = step.getValue();
		//对验证码的处理
		if (inputVal.equalsIgnoreCase("com.caidazq.dzhNew:id/tv_yzm"))
		{
			String valGet = step.getAndroidDriver().findElement(By.id(inputVal)).getText();			
			e.sendKeys(valGet);					
		}
		else{
			e.sendKeys(AppiumUtil.parseStringHasEls(inputVal));	
		}
		
	}
	
	/**
	 * <br>Android-ADB指令输入操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void adbInput(TestStep step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		AppiumUtil.getElement(step).click(); 
		Runtime.getRuntime().exec("adb shell input text "+step.getValue());
	}
}
