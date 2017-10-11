package br.gov.prodemge.prodigio.cursoprodigio.test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class CursoProdigioBaseFunctionalTest {
		protected static WebDriver driver;
		private WebElement elementoEsperado;
		private static String baseUrl;
		
		
		protected void waitAndClickByXPATH(String path){
			WebDriverWait wait = new WebDriverWait(driver,10);
			elementoEsperado = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
			driver.findElement(By.xpath(path)).click();
		}
		
		protected void waitAndClickById(String component){
			WebDriverWait wait = new WebDriverWait(driver,10);
			elementoEsperado = wait.until(ExpectedConditions.elementToBeClickable(By.id(component)));
			driver.findElement(By.id(component)).click();
		}

		protected WebElement findElementById(String component) {
			elementoEsperado = null;
			WebDriverWait wait = new WebDriverWait(driver,10);
			elementoEsperado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(component)));
			return elementoEsperado;
		}

		
		protected WebElement findElementByXPath(String path) {
			elementoEsperado= null;
			WebDriverWait wait = new WebDriverWait(driver,10);
			elementoEsperado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
			return elementoEsperado;
		}
		
		@AfterClass
		public static void tearDown() throws Exception {
			driver.quit();
		}
		

		@BeforeClass
		public  static void setUp() throws Exception {
			baseUrl = "http://127.0.0.1:8080/";
			startApplication("curso-web/");
		}
		
		public static void startApplication(String contexto) {
			System.setProperty("webdriver.chrome.driver", "C:/Prodemge/webdriver/chrome/2.25/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(baseUrl + contexto);
		}


}