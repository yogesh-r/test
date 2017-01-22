package com.rjn.model;
import org.joda.time.LocalDate;
/*
 *  Baliram 
 *  21-07-2016
 */
public class MessageQueue {
	
	private int ID;
	
	private String regId;
	
	private String studName;
	
	private String receiptId;
	
	private String mobileNo;
	
	private String emailId;
	
	private String messageType;
	
	private String messageText;
	
	private String status;
	
	private String emailStatus;
	
	private  LocalDate dateCreated;
	
	private LocalDate dateSend;
	
	private String response;
	
	private String amount;
	
	private String userName;
	
	private String field1;
	
	private String field2;
	
	private String field3;
	
	private String field4;
	
	private String field5;
	
	private LocalDate dueDate;
	
	private int smsId;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDate getDateSend() {
		return dateSend;
	}

	public void setDateSend(LocalDate dateSend) {
		this.dateSend = dateSend;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public int getSmsId() {
		return smsId;
	}

	public void setSmsId(int smsId) {
		this.smsId = smsId;
	}

}
