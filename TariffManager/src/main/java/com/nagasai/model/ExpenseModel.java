package com.nagasai.model;


import java.util.Arrays;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


public class ExpenseModel {

	private int id;
	
	private int expenseId;
	@NotEmpty(message="Bill Number cannot be empty")
	private String billNumber;
	@NotEmpty(message="Bill jpg Image Required")
	private byte[] billImage;
	@NotNull(message="Bill Cost Cant be empty")
	@Positive(message="Bill Cost cant be negative")
	private int billCost;
	
	private String datedOn;
	private String status;
	private String remark;
	
	
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public byte[] getBillImage() {
		return billImage;
	}
	public void setBillImage(byte[] billImage) {
		this.billImage = billImage;
	}
	public int getBillCost() {
		return billCost;
	}
	public void setBillCost(int billCost) {
		this.billCost = billCost;
	}
	public String getDatedOn() {
		return datedOn;
	}
	public void setDatedOn(String datedOn) {
		this.datedOn = datedOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", billNumber=" + billNumber + ", billImage="
				+ Arrays.toString(billImage) + ", billCost=" + billCost + ", datedOn=" + datedOn + ", status=" + status
				+ ", remark=" + remark + "]";
	}
	
}
