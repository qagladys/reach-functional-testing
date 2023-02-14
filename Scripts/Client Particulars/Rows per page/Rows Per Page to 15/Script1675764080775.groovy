import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://reach-dev.embreo.global/')

WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Log in page/Input_Email'), GlobalVariable.email2)

WebUI.setText(findTestObject('Log in page/Input_Password'), GlobalVariable.password2)

WebUI.click(findTestObject('Log in page/Button_Sign In'))

WebUI.waitForElementVisible(findTestObject('Dashboard page/Unique_Agent Panel Dashboard'), 5)

WebUI.click(findTestObject('Sidebar/Button_Sidebar_Client Particulars'))

WebUI.waitForElementVisible(findTestObject('Client particulars page/Dashboard/Unique_Dashboard_Client Particulars'), 5)

WebUI.scrollToElement(findTestObject('Client particulars page/Dashboard/Rows per page/Text_Rows per page'), 5)

WebUI.click(findTestObject('Client particulars page/Dashboard/Rows per page/Button_Rows per page'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Client particulars page/Dashboard/Rows per page/Option_Rows per page_15'))

WebUI.scrollToElement(findTestObject('Client particulars page/Dashboard/Rows per page/Text_Rows per page'), 5)

WebUI.verifyElementText(findTestObject('Client particulars page/Dashboard/Rows per page/Button_Rows per page'), '15')

rpp = WebUI.getText(findTestObject('Client particulars page/Dashboard/Rows per page/Button_Rows per page'), FailureHandling.STOP_ON_FAILURE)

println(rpp)

row = '//*[@id=\'root\']/div/div[2]/div[2]/div/div[3]/div/div[4]/div/div[1]/div/div/div/div/div/table/tbody/tr'

for (int i = 1; i <= rpp.toInteger(); i++) {
    row = (((row + '[') + i.toString()) + ']')

    WebUI.modifyObjectProperty(findTestObject('Client particulars page/Dashboard/Rows per page/Element_Row'), 'xpath', 'equals', 
        row, false)

    WebUI.verifyElementVisible(findTestObject('Client particulars page/Dashboard/Rows per page/Element_Row'))
}

