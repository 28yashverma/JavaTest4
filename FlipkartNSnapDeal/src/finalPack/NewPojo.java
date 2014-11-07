package finalPack;

import java.util.ArrayList;
import java.util.List;

public class NewPojo
{
	private String productName;
	List<Companies> comp = new ArrayList<Companies>();
	
	public NewPojo(String productName, List<Companies> list) 
	{
		this.productName = productName;
		this.comp = list;
	}
	public String getProductName() 
	{
		return productName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	public List<Companies> getComp() 
	{
		return comp;
	}
	public void setComp(List<Companies> comp) 
	{
		this.comp = comp;
	}
	
}
