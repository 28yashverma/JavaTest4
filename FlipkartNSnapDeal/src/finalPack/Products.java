package finalPack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@SuppressWarnings("unused")
public class Products 
{

	public static void main(String []args) throws InterruptedException
	{
		
		String category = "Mobiles";
		String subCat = "Apple";
		String productName[] = {
				"Apple iPhone 4S (White, with 8 GB)",
				"Apple iPhone 4S (Black, with 8 GB)",
				"Apple iPhone 5S (Gold, with 16 GB)"
				};
		
		String snapDealproductName[] = {
				"Apple iPhone 4S 8 GB (White)",
				"Apple iPhone 4S 8 GB (Black)",
				"Apple iPhone 5S 16 GB (Gold)"
				};
		
		//String searchPathForSnapdeal = ".//*[@id='keyword']";
		//String searchButton = ".//*[@id='searchBtn']";
		String forSnapdeal = "Mobile Phones";
		int priceForFlipkart = 0;
		int priceForSnapdeal = 0;
		String status = null;
		int incoming = 2;
		int initial = 1;
		
		
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\yashindra.verma\\Desktop\\new folder\\IEDriverServer_x64_2.44.0\\IEDriverServer.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\yashindra.verma\\Desktop\\new folder\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new InternetExplorerDriver();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//Flipkart-------------------------------------------------------------------------------
		outer:
		for(int len = 0; len < productName.length; len++)
		{
			System.out.println("For Flipkart");
			driver.get("http://www.flipkart.com");
			
			
			List<WebElement> listOfCategory = driver.findElements(By.cssSelector(".goquickly-list"));
			Methods.passedFirst(driver, category, listOfCategory);										//Method to check for respective category (Mobiles)
			
			List<WebElement> subCategory = driver.findElements(By.xpath("//div[@id='list-tagcloud']"));
			Methods.passedFirst(driver, subCat, subCategory);											//Method to check for respective sub - category (Apple)
			
			List<WebElement> listOfWebElementsinFlipkart = driver.findElements(By.cssSelector(".results.grid"));
			Thread.sleep(3000);
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean checkForElementInFlipkart = Methods.isElementPresent(productName[len], listOfWebElementsinFlipkart, driver);			//Method to check for presence of Element
			
			for(WebElement element : listOfWebElementsinFlipkart)
			{
				if(element.getText().contains(productName[len]))
				{
					if(checkForElementInFlipkart)
						driver.findElement(By.linkText(productName[len])).click();
					else
						break outer;
					Thread.sleep(5000);
				}
			}
			
			String priceforFlipkart = driver.findElement(By.cssSelector(".selling-price.omniture-field")).getText();
			priceforFlipkart = priceforFlipkart.replaceAll("[\\s\\,\\.]", "");
			priceforFlipkart = priceforFlipkart.substring(2, 7);
			
			priceForFlipkart = Integer.parseInt(priceforFlipkart);
			System.out.println(priceForFlipkart);
		
		
		
		
		
			//SnapDeal----------------------------------------------------------------------------------
			System.out.println("For Snapdeal");
			driver.get("http://www.snapdeal.com");
//-->			driver.findElement(By.xpath(searchPathForSnapdeal)).sendKeys("apple mobile phones");
//-->			driver.findElement(By.xpath(searchButton)).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			boolean clickingAndPerformingSearch = Methods.clickAndPerformSearch(driver, "apple mobile phones");				//Method to search for string and perform click operation
			Thread.sleep(2000);
//-->			driver.findElement(By.xpath(".//*[@id='matchingCatbox']/ul[1]/ul/li[1]/a/div[2]")).click();
			boolean gettingXpath = Methods.getMobileXPath(driver, forSnapdeal);												//Method to click on Mobile Phones link in the list using
			Thread.sleep(3000);																								//JavaScript Executer
			
			List<WebElement> list = driver.findElements(By.cssSelector("#products-main4"));
			boolean flag = false;
			
			boolean checkForElemenInSnapdeal = Methods.isElementPresent(snapDealproductName[len], list, driver);			//Method to check for presence of element 
			
			if(checkForElemenInSnapdeal)
				flag = Methods.snapPassed(list, driver, snapDealproductName[len]);											//Method to click on that product
			else
				break outer;
			
			if(flag)
			{
				
				String price = driver.findElement(By.cssSelector("#selling-price-id")).getText();
				priceForSnapdeal = Integer.parseInt(price);
				System.out.println(priceForSnapdeal);
			}

			//Price Comparison----------------------------------------------------------------------------
			
			boolean priceResult = Methods.priceComparison(priceForFlipkart, priceForSnapdeal);								//Method for price comparison
			status = Methods.computeStatus(priceResult);																	//Method to compute status based on price comparison
			System.out.println(status);
			

			
			
			//Object Creation-----------------------------------------------------------------------------
			
			List<Companies> comp = new ArrayList<Companies>();
			NewPojo pojo = null ;
			Companies companies = new Companies(priceForFlipkart, priceForSnapdeal, status, category, subCat);				
			comp.add(companies);
			pojo = new NewPojo(productName[len], comp);
			
			for(int i = 0; i < pojo.comp.size(); i++)
			{
				//System.out.println(pojo.getProductName()+" "+comp.get(i).getFlipkartPrice()+" "+comp.get(i).getSnapdealPrice()+" "+comp.get(i).getStatus()+" "+comp.get(i).getCategory()+" "+comp.get(i).getSubCategory());
				PoiCode.method(pojo.getProductName(), comp.get(i).getFlipkartPrice(), comp.get(i).getSnapdealPrice(), comp.get(i).getStatus(), comp.get(i).getCategory(), comp.get(i).getSubCategory(), incoming, initial);		
				//Method
			}
			++incoming;
			++initial;
			
		}
		driver.quit();
		
	}

}
