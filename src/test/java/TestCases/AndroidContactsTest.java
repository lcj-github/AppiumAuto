package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lcj.deom.base.TestUnit;
import com.lcj.deom.service.AndroidXmlParseService;
import com.lcj.deom.service.RunUnitService;

public class AndroidContactsTest {
	
	private static RunUnitService runService;
		
	@BeforeTest
	private void stup() throws Exception{
		TestUnit testunit = AndroidXmlParseService.parse("src/test/java/TestCaseXml/AndroidContactsTest.xml");
		runService = new RunUnitService(testunit);
		System.out.println("-----------------------------------【微信登录流程的测试场景点】-----------------------------------");
	}
	
	@Test
	public void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("检查在Android系统中，首次启动通讯功能，点击添加按钮后，可以正常进入添加界面");
	}

	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("能正确添加通讯录信息");
	}
	
	@AfterTest
	public void TearDown(){
		runService.closeApp();
	}
}
