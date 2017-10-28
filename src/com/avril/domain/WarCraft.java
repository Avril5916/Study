package com.avril.domain;
/**
 * 测试用类继承Games
 * @author Avril
 *
 */

public class WarCraft implements Games{

	private String warname;
	private Double warcost;
	
	@Override
	public void play() {
		System.out.println("Play warcraft");
		
	}
	
	
	
	public String getWarname() {
		return warname;
	}
	public void setWarname(String warname) {
		this.warname = warname;
	}
	public Double getWarcost() {
		return warcost;
	}
	public void setWarcost(Double warcost) {
		this.warcost = warcost;
	}
	@Override
	public String toString() {
		return "Warcraft [warname=" + warname + ", warcost=" + warcost + "]";
	}
	public WarCraft(String warname, Double warcost) {
		super();
		this.warname = warname;
		this.warcost = warcost;
	}
	public WarCraft() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
