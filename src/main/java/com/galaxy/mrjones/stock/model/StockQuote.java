package com.galaxy.mrjones.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stock_Summary")
public class StockQuote {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	int ID;
	@Column(name="Symbol")
	String Symbol;
	@Column(name="CompanyName")
	String CompanyName;
	@Column(name="OpenPrice")
	double OpenPrice;
	@Column(name="ChgClosePrcn")
	double ChgClosePrcn;
	@Column(name="TodayHigh")
	double TodayHigh;
	@Column(name="TodayLow")
	double TodayLow;
	@Column(name="PrevClose")
	double PrevClose;
	@Column(name="TodayClose")
	double TodayClose;
	
	public StockQuote(String symbol, String companyName, double openPrice, double chgClosePrcn,
			double todayHigh, double todayLow, double prevClose, double todayClose) {
		super();
		Symbol = symbol;
		CompanyName = companyName;
		OpenPrice = openPrice;
		ChgClosePrcn = chgClosePrcn;
		TodayHigh = todayHigh;
		TodayLow = todayLow;
		PrevClose = prevClose;
		TodayClose = todayClose;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSymbol() {
		return Symbol;
	}
	public void setSymbol(String symbol) {
		Symbol = symbol;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public double getOpenPrice() {
		return OpenPrice;
	}
	public void setOpenPrice(double openPrice) {
		OpenPrice = openPrice;
	}
	public double getChgClosePrcn() {
		return ChgClosePrcn;
	}
	public void setChgClosePrcn(double chgClosePrcn) {
		ChgClosePrcn = chgClosePrcn;
	}
	public double getTodayHigh() {
		return TodayHigh;
	}
	public void setTodayHigh(double todayHigh) {
		TodayHigh = todayHigh;
	}
	public double getTodayLow() {
		return TodayLow;
	}
	public void setTodayLow(double todayLow) {
		TodayLow = todayLow;
	}
	public double getPrevClose() {
		return PrevClose;
	}
	public void setPrevClose(double prevClose) {
		PrevClose = prevClose;
	}
	public double getTodayClose() {
		return TodayClose;
	}
	public void setTodayClose(double todayClose) {
		TodayClose = todayClose;
	}
	@Override
	public String toString() {
		return "StockQuote [ID=" + ID + ", Symbol=" + Symbol + ", CompanyName=" + CompanyName + ", OpenPrice="
				+ OpenPrice + ", ChgClosePrcn=" + ChgClosePrcn + ", TodayHigh=" + TodayHigh + ", TodayLow=" + TodayLow
				+ ", PrevClose=" + PrevClose + ", TodayClose=" + TodayClose + "]";
	}
	
		
	
}
