package br.senai.gamemania;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteLogin {
	private WebDriver driver;

	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestarFormLogin() {
		driver.get("http://localhost:4200/");
		driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[1]/div[3]/a")).click();
		
		//Teste com email e senha corretos
		//driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/div[1]/div/form/div[1]/input")).sendKeys("teste@teste.com");
		//driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/div[1]/div/form/div[2]/input")).sendKeys("1234");
		//driver.findElement(By.xpath("//*[@id=\"submit\"]")).sendKeys(Keys.ENTER);
		
		
		//Teste com email errado
		driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/div[1]/div/form/div[1]/input")).sendKeys("tete@teste.com");
		driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/div[1]/div/form/div[2]/input")).sendKeys("1234");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).sendKeys(Keys.ENTER);
		WebElement mensagem = driver.findElement(By.className("msg"));
		System.out.println(mensagem.getText());
		
		
		//Teste de newsletter
		//driver.findElement(By.id("email_newsletter")).sendKeys("newsletter@teste.com");
		//driver.findElement(By.id("btn_newsletter")).click();
		
	}
	
	@After 
		public void FecharNavegador() {
			driver.close();
		}
}