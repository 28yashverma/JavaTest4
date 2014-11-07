package finalPack;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class Methods {

	/*public static boolean passedValues(List<WebElement> listOfCategory, List<WebElement> subCategory, WebDriver driver, String cat, String sbCat) throws InterruptedException 
	{
		for(WebElement element : listOfCategory)
		{
			if(element.getText().contains(cat))
			{
				driver.findElement(By.linkText(cat)).click();
				Thread.sleep(3000);
			}
		}
		

		for(WebElement element1 : subCategory)
		{
			if(element1.getText().contains(sbCat))
			{
				driver.findElement(By.linkText(sbCat)).click();
				Thread.sleep(5000);
			}
		}
		return true;
	}
	*/
	public static boolean snapPassed(List<WebElement> list, WebDriver driver, String snapDealproductName) throws InterruptedException
	{
		for(WebElement element : list)
		{
			if(element.getText().contains(snapDealproductName))
			{
				Thread.sleep(1000);
				driver.findElement(By.linkText(snapDealproductName)).click();
				Thread.sleep(3000);
			}
		}
		return true;
		
	}

	public static boolean priceComparison(int priceForFlipkart,	int priceForSnapdeal) 
	{
		if(priceForFlipkart == priceForSnapdeal)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static String computeStatus(boolean priceResult) 
	{
		if(priceResult)
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	
	

	public static void passedFirst(WebDriver driver, String category, List<WebElement> listOfCategory) throws InterruptedException 
	{
		for(WebElement element : listOfCategory)
		{
			if(element.getText().contains(category))
			{
				driver.findElement(By.linkText(category)).click();
				Thread.sleep(3000);
			}
		}
		
	}

	public static boolean isElementPresent(String productName, List<WebElement> listOfWebElements, WebDriver driver) 
	{
		boolean flag =  false;
		for(WebElement element: listOfWebElements)
		{
			(new WebDriverWait(driver, 6)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(productName)));
			if(element.getText().contains(productName))
			{
				flag = true;
				System.out.println("Element found");
			}
			else
			{
				flag = false;
				System.out.println("Element Not found");
			}
		}
		return flag;
	}

	
	public static boolean getMobileXPath(WebDriver driver, String forSnapdeal) 
	{
		List<WebElement> elements = driver.findElements(By.cssSelector("#matchingCatbox"));
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		for(WebElement element : elements)
		{
			//System.out.println(element.getText());
			
			if(element.getText().contains(forSnapdeal))
			{
				//System.out.println("It contains");
				WebElement e = driver.findElement(By.partialLinkText(forSnapdeal));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", e);
			}
			else
			{
				System.out.println("Not contains");
			}
		}
		return true;
	}
	
	

	public static boolean clickAndPerformSearch(WebDriver driver, String string) throws InterruptedException
	{
		List<WebElement> list = driver.findElements(By.cssSelector(".pageWrapper.header"));
		Thread.sleep(2000);
		
		for(WebElement e : list)
		{
			if(e.getAttribute("input") == null)
			{
				//e.sendKeys("apple mobile phones");
				driver.findElement(By.id("keyword")).sendKeys("apple mobile phones");
				driver.findElement(By.tagName("button")).click();
			}
		}
		return true;
	}


}
