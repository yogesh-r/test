package com.rjn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="email_message_queue")
public class EmailMessageQueue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "reg_id", nullable = false)
	private String regId;
	
	@Column(name = "stud_name", nullable = false)
	private String studName;
	
	@Column(name = "receipt_id", nullable = false)
	private String receiptId;
	
	@Column(name = "email_id", nullable = false)
	private String emailId;
	
	@Column(name = "subject", nullable = false)
	private String subject;
	
	@Column(name = "message_type", nullable = false)
	private String messageType;
	
	@Column(name = "message_text", nullable = false)
	private String messageText;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "email_status", nullable = false)
	private String emailStatus;
	
	@Column(name = "response", nullable = false)
	private String response;
	
	@Column(name = "amount", nullable = false)
	private String amount;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name = "field_1", nullable = false)
	private String field1;
	
	@Column(name = "field_2", nullable = false)
	private String field2;
	
	@Column(name = "field_3", nullable = false)
	private String field3;
	
	@Column(name = "field_4", nullable = false)
	private String field4;
	
	@Column(name = "field_5", nullable = false)
	private String field5;
	
	@Column(name = "due_date", nullable = false)
	private String due_date;
	
	@Column(name = "email_seq_id", nullable = false)
	private int emailSeqId;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name = "date_created", nullable = false)
	private LocalDate dateCreated;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name = "date_send", nullable = false)
	private LocalDate date_send;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public int getEmailSeqId() {
		return emailSeqId;
	}

	public void setEmailSeqId(int emailSeqId) {
		this.emailSeqId = emailSeqId;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDate getDate_send() {
		return date_send;
	}

	public void setDate_send(LocalDate date_send) {
		this.date_send = date_send;
	}
}
