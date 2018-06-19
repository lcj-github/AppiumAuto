package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lcj.deom.base.TestUnit;
import com.lcj.deom.service.AndroidXmlParseService;
import com.lcj.deom.service.RunUnitService;

public class LoginInTest {
	
	private static RunUnitService runService;
		
	@BeforeTest
	private void stup() throws Exception{
		TestUnit testunit = AndroidXmlParseService.parse("src/test/java/TestCaseXml/LoginInTest.xml");
		runService = new RunUnitService(testunit);
		System.out.println("-----------------------------------【LoginIn的测试场景点】-----------------------------------");
	}
	
	@Test
	public void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("打开app后，弹出公告，提示您已成功登录test");
	}

	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("点击交易按钮，进入交易登录界面");
	}
	
	@Test
	public void case3() throws Exception{
		runService.runCase("case3");
		runService.TestReportRemarks("输入账号密码，正常登录交易系统");
	}
	
	@Test
	public void case4() throws Exception{
		runService.runCase("case4");
		runService.TestReportRemarks("普通交易-买入");
	}

	
	@AfterTest
	public void TearDown(){
		runService.closeApp();
	}
}
