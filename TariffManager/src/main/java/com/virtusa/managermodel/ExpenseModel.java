package com.virtusa.managermodel;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


public class ExpenseModel {

	private int id;
	private int expenseId;
	private String billNumber;
	private byte[] billImage;
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
