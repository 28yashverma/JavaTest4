package finalPack;

public class Companies 
{
	private int flipkartPrice;
	private int snapdealPrice;
	private String status;
	private String category;
	private String subCategory;
	
	
	public Companies(int flipkartPrice, int snapdealPrice, String status, String category, String subCategory) 
	{
		this.flipkartPrice = flipkartPrice;
		this.snapdealPrice = snapdealPrice;
		this.status = status;
		this.category = category;
		this.subCategory = subCategory;
	}
	
	public int getFlipkartPrice() {
		return flipkartPrice;
	}
	public void setFlipkartPrice(int flipkartPrice) {
		this.flipkartPrice = flipkartPrice;
	}
	public int getSnapdealPrice() {
		return snapdealPrice;
	}
	public void setSnapdealPrice(int snapdealPrice) {
		this.snapdealPrice = snapdealPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	
	
}
