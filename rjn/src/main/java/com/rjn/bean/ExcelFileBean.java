package com.rjn.bean;

public class ExcelFileBean { 
	String col1;
	String col2; 
	String col3;
	String col4;
	String col5;
	String col6;
	String col7;
	String col8;

	public String getCol1() { 
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	public String getCol2() {
		return col2;
	}
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	public String getCol3() {
		return col3;
	}
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	public String getCol4() {
		return col4;
	}
	public void setCol4(String col4) {
		this.col4 = col4;
	}
	public String getCol5() {
		return col5;
	}
	public void setCol5(String col5) {
		this.col5 = col5;
	}
	public String getCol6() {
		return col6;
	}
	public void setCol6(String col6) {
		this.col6 = col6;
	}
	public String getCol7() {
		return col7;
	}
	public void setCol7(String col7) {
		this.col7 = col7;
	}
	public String getCol8() {
		return col8;
	}
	public void setCol8(String col8) {
		this.col8 = col8;
	}
	
	@Override
	public String toString() {
		String returnValue = "col1: " + col1 + "\ncol2: " + col2 +"\ncol3: " + col3 +"\ncol4: " + col4 +"\ncol5: " + col5 + "\n\n";
		return returnValue;
	}
}
