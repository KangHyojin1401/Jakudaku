package passionx3.jkdk.domain;

import java.util.Date;

public abstract class Item {
	private int itemId;
	private String producerId;
	private String producerName;
	private int themeId;
	private String themeName;
	private int categoryId;
	private String name;
	private Date uploadDate;
	private int price;
	private int like;
	private String thumbnail1;
	private String thumbnail2;
	private String thumbnail3;
	private int isForSale;
	private String description;
	private int approval;

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getProducerId() {
		return producerId;
	}
	public void setProducerId(String producerId) {
		this.producerId = producerId;
	}
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	public int getThemeId() {
		return themeId;
	}
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getThumbnail1() {
		return thumbnail1;
	}
	public void setThumbnail1(String thumbnail1) {
		this.thumbnail1 = thumbnail1;
	}
	public String getThumbnail2() {
		return thumbnail2;
	}
	public void setThumbnail2(String thumbnail2) {
		this.thumbnail2 = thumbnail2;
	}
	public String getThumbnail3() {
		return thumbnail3;
	}
	public void setThumbnail3(String thumbnail3) {
		this.thumbnail3 = thumbnail3;
	}
	public int getIsForSale() {
		return isForSale;
	}
	public void setIsForSale(int isForSale) {
		this.isForSale = isForSale;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getApproval() {
		return approval;
	}
	public void setApproval(int approval) {
		this.approval = approval;
	}
}