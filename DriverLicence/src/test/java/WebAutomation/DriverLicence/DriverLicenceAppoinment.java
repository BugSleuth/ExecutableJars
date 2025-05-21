package WebAutomation.DriverLicence;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DriverLicenceAppoinment {
	 WebDriver driver;
	@BeforeClass
	public void setup() {
		 System.setProperty("webdriver.chromedriver", "C:\\Users\\smit0\\Downloads\\chrome-win32\\chrome-win32\\chrome.exe");
		 driver	 =new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://public.txdpsscheduler.com/");
         System.out.println("Title of the Page:"+driver.getTitle());//Get the title method
         System.out.println("Current URL of the:"+driver.getCurrentUrl()); //Get the CurrentUrl
         WebElement languageButton =driver.findElement(By.className("v-btn__content"));
         languageButton.click();
	}
	
	@Test(dataProvider="Login")
	public void Login(String FirtName,String LasName,String dateofbirth,String ssn,String emai,String confirmEmail,String pincode) {
      //  WebElement languageButton =driver.findElement(By.className("v-btn__content"));
      //  languageButton.click();
       
        WebElement FirstName =driver.findElement(By.id("input-55"));
        FirstName.sendKeys(FirtName);
       
        WebElement LastName=driver.findElement(By.id("input-58"));
        LastName.sendKeys(LasName);
       
        WebElement dob=driver.findElement(By.id("dob"));
        dob.sendKeys(dateofbirth);
       
        WebElement LastSSN=driver.findElement(By.id("last4Ssn"));
        LastSSN.sendKeys(ssn);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        WebElement logonButton =driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/div/form/div[2]/div[4]/button/span"));
        logonButton.click();
       
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        
        WebElement NewAppoinmentButton =driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/div/div[3]/div/button/span"));
        NewAppoinmentButton.click();
        
        WebElement ApplyFirstTimeDriverButton =driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/main/div/div/div[1]/div[1]/button"));
        ApplyFirstTimeDriverButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        WebElement email=driver.findElement(By.id("input-134"));
        email.sendKeys(emai);
        
        WebElement Verifyemail=driver.findElement(By.id("input-137"));
        Verifyemail.sendKeys(confirmEmail);
        
        WebElement Zipcode=driver.findElement(By.id("input-160"));
        Zipcode.sendKeys(pincode);        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement NextButton =driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/form/div/div[2]/div[2]/div/div[2]/button"));
        NextButton.click();      
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement DateButton =driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/div[3]/table/tbody/tr/td[2]/div/div[1]/div/div[2]"));
        DateButton.click();
        
        WebElement TimeButton =driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/div[2]/table/tbody/tr/td[2]/div/div[1]/div/div"));
        TimeButton.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement NextButtonAfterTime =driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/div[4]/div/div[2]/button/span/i"));
        NextButtonAfterTime.click();
	}
	
	
	@DataProvider(name="Login")
	public String[] []  getData() throws IOException{
	/*	String loginData[][]= {
				{"Deena","Ambani","12/04/1998","9086","patelsmit.1997v@gmail.com","patelsmit.1997v@gmail.com","75407"}
		};

		return loginData;
		}  */
		
		String path="C:\\Users\\smit0\\eclipse-workspace\\DriverLicence\\target\\Data.xlsx";
		
		
		XLUtlity xlutils=new XLUtlity(path);
		int totalrows=xlutils.getRowCount("Sheet1");
		int totalcolom=xlutils.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[totalrows][totalcolom];
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcolom;j++) {
				loginData[i-1][j]=xlutils.getCellData("Shee1", i, j);
			}
		}
	  return loginData;
	}
}
     /* @AfterClass
      void tearDown() {
    	  driver.close();
      
      }*/
      

