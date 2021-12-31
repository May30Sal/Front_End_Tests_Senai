package br.senai.sp.automacaoteste;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	private WebDriver driver;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TesteNavegarParaGoogle() {
		driver.get("https://online.sp.senai.br");
		
		WebElement input = driver.findElement(By.id("Busca1_txtFiltro"));
		
		input.sendKeys("gestão");
		input.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"MainContent_ListaCurso1_rptSegmArea_rptCursos_0_divCurso_0\"]/a")).click();
		
		//driver.findElement(By.id("Busca1_txtFiltro")).sendKeys("gestão");
		//driver.findElement(By.id("Busca1_btnBusca")).click();
		
	}
	
	//@After 
	//public void FecharNavegador() {
		//driver.close();
	//}
}
