package edu.java.project01;

import java.sql.Date;

public class ItemVO {

	// 멤버변수
	private int itemId;
	private String itemN;
	private String itemPurchaseP; // purchase price
	private String itemSalesP; // sales price
	private String itemPurchaseC; // purchase count
	private String itemSalesC; // sales count
	private String vendorName;
	private Date itemD;
	public ItemVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemVO(int itemId, String itemN, String itemPurchaseP, String itemSalesP, String itemPurchaseC,
			String itemSalesC, String vendorName, Date itemD) {
		super();
		this.itemId = itemId;
		this.itemN = itemN;
		this.itemPurchaseP = itemPurchaseP;
		this.itemSalesP = itemSalesP;
		this.itemPurchaseC = itemPurchaseC;
		this.itemSalesC = itemSalesC;
		this.vendorName = vendorName;
		this.itemD = itemD;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemN() {
		return itemN;
	}
	public void setItemN(String itemN) {
		this.itemN = itemN;
	}
	public String getItemPurchaseP() {
		return itemPurchaseP;
	}
	public void setItemPurchaseP(String itemPurchaseP) {
		this.itemPurchaseP = itemPurchaseP;
	}
	public String getItemSalesP() {
		return itemSalesP;
	}
	public void setItemSalesP(String itemSalesP) {
		this.itemSalesP = itemSalesP;
	}
	public String getItemPurchaseC() {
		return itemPurchaseC;
	}
	public void setItemPurchaseC(String itemPurchaseC) {
		this.itemPurchaseC = itemPurchaseC;
	}
	public String getItemSalesC() {
		return itemSalesC;
	}
	public void setItemSalesC(String itemSalesC) {
		this.itemSalesC = itemSalesC;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Date getItemD() {
		return itemD;
	}
	public void setItemD(Date itemD) {
		this.itemD = itemD;
	}
	@Override
	public String toString() {
		return "ItemVO [itemId=" + itemId + ", itemN=" + itemN + ", itemPurchaseP=" + itemPurchaseP + ", itemSalesP="
				+ itemSalesP + ", itemPurchaseC=" + itemPurchaseC + ", itemSalesC=" + itemSalesC + ", vendorName="
				+ vendorName + ", itemD=" + itemD + "]";
	}

	
} // end ItemVO
