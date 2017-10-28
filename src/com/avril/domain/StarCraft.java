package com.avril.domain;

/**
 * 测试用类,继承games
 * @author Avril
 *
 */
public class StarCraft implements Games{
	


	private String protoss;
	private String terran;
	private String zerg;
	

	@Override
	public void play(){
		System.out.println("Playing StarCraft");
	}
	
	
	static{
		System.out.println("StarCraft static loaded!");
	}
	{
		System.out.println("StarCraft block loaded");
	}
	
	public void test(){
		System.out.println("test");
	}
	
	
	public StarCraft(String protoss, String terran, String zerg) {
		super();
		System.out.println("StarCraft Constructor loaded");
		this.protoss = protoss;
		this.terran = terran;
		this.zerg = zerg;
	}
	public StarCraft() {
		super();
		System.out.println("StarCraft non-param Constructor loaded");
	}
	public String getProtoss() {
		return protoss;
	}
	public void setProtoss(String protoss) {
		this.protoss = protoss;
	}
	public String getTerran() {
		return terran;
	}
	public void setTerran(String terran) {
		this.terran = terran;
	}
	public String getZerg() {
		return zerg;
	}
	public void setZerg(String zerg) {
		this.zerg = zerg;
	}
	@Override
	public String toString() {
		return "StarCraft [protoss=" + protoss + ", terran=" + terran + ", zerg=" + zerg + "]";
	}
	
	
	
	
}
