package com.rjn.model;

import org.joda.time.LocalDate;

/*
 * Baliram
 * 20-july-2016
 */
public class ReceiptMaster {
	
	private int id;
	
	private String branchId;
	
	private String bookingHeaderId;
	
	private LocalDate receiptDate;
	
	private int receiptAmount;
	
	private String receiptCurrency;
	
	private String receiptMode;
	
	private String bankName;
	
	private String branchName;
	
	private String status;
	
	private int appliedAmount;
	
	private LocalDate remittanceDate;
	
	private int remittanceAmount;
	
	private String transactionType;
	
	private String cancelReason;
	
	private String receiptNo;
	
	private String custProfileNo;
	
	private String billRefNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBookingHeaderId() {
		return bookingHeaderId;
	}

	public void setBookingHeaderId(String bookingHeaderId) {
		this.bookingHeaderId = bookingHeaderId;
	}

	public LocalDate getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(LocalDate receiptDate) {
		this.receiptDate = receiptDate;
	}

	public int getReceiptAmount() {
		return receiptAmount;
	}

	public void setReceiptAmount(int receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public String getReceiptCurrency() {
		return receiptCurrency;
	}

	public void setReceiptCurrency(String receiptCurrency) {
		this.receiptCurrency = receiptCurrency;
	}

	public String getReceiptMode() {
		return receiptMode;
	}

	public void setReceiptMode(String receiptMode) {
		this.receiptMode = receiptMode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAppliedAmount() {
		return appliedAmount;
	}

	public void setAppliedAmount(int appliedAmount) {
		this.appliedAmount = appliedAmount;
	}

	public LocalDate getRemittanceDate() {
		return remittanceDate;
	}

	public void setRemittanceDate(LocalDate remittanceDate) {
		this.remittanceDate = remittanceDate;
	}

	public int getRemittanceAmount() {
		return remittanceAmount;
	}

	public void setRemittanceAmount(int remittanceAmount) {
		this.remittanceAmount = remittanceAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getCustProfileNo() {
		return custProfileNo;
	}

	public void setCustProfileNo(String custProfileNo) {
		this.custProfileNo = custProfileNo;
	}

	public String getBillRefNo() {
		return billRefNo;
	}

	public void setBillRefNo(String billRefNo) {
		this.billRefNo = billRefNo;
	}
}
