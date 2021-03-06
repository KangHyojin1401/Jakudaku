
package passionx3.jkdk.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LineItem implements Serializable {
	int lineItemId;
	int orderId;
	int lineNumber;
	int quantity;
	int isDownloaded;
	int unitPrice;
	String uploadDate;
	Item item;
	int saleState;
	int itemId;
	Online online;
	Funding funding;

	public LineItem() {
	}
		
	public LineItem(int lineItemId, int orderId, int lineNumber, int quantity, int isDownloaded, 
		int unitPrice, Item item, int saleState) {
  		this.lineItemId = lineItemId;
		this.orderId = orderId;
		this.lineNumber = lineNumber;
		this.quantity = quantity;
	  	this.isDownloaded = isDownloaded;
	  	this.unitPrice = unitPrice;
	  	this.item = item;
	  	this.saleState = saleState;
	}
  
	// online
	public LineItem(int lineNumber, CartItem cartItem) {
		this.itemId = cartItem.getOnlineItem().getItemId();
	    this.lineNumber = lineNumber;
	    this.online = cartItem.getOnlineItem();
		this.isDownloaded = 0;	// 여기서 설정?
	    this.unitPrice = cartItem.getOnlineItem().getPrice();
	    
	    this.quantity = 1;
	    this.saleState = cartItem.getOnlineItem().getSaleState();
	  }
	
	// funding
	public LineItem(int lineNumber, Funding funding, int quantity) {
		this.itemId = funding.getItemId();
	    this.lineNumber = lineNumber;
	    this.funding = funding;
		this.isDownloaded = 0;
	    this.unitPrice = funding.getPrice();
	    
	    this.quantity = quantity;
	    this.saleState = 0;
	}
	

	
	public int getLineItemId() {
		return lineItemId;
	}
	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIsDownloaded() {
		return isDownloaded;
	}
	public void setIsDownloaded(int isDownloaded) {
		this.isDownloaded = isDownloaded;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getSaleState() {
		return saleState;
	}
	public void setSaleState(int saleState) {
		this.saleState = saleState;
	}
	
	public int getDiscount() {
		if (saleState == 0)
			return 0;
		else
			return (int) (unitPrice * 0.1);
	}
	public int getSalePrice() {
		return unitPrice - getDiscount();
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Online getOnline() {
		return online;
	}

	public void setOnline(Online online) {
		this.online = online;
	}

	public Funding getFunding() {
		return funding;
	}

	public void setFunding(Funding funding) {
		this.funding = funding;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	
	
}
