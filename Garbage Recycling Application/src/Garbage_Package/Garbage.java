package Garbage_Package;

import Interfaces.IGarbage;

public class Garbage implements IGarbage{
	
	private String name;
	private GarbageTypes type;
	
	public Garbage(String name, String type) {
		
		this.name = name;
		
		switch (type) {
			case ("plastic"):{
				this.type = GarbageTypes.PLASTIC;
				break;
			}
			case ("paper"):{
				this.type = GarbageTypes.PAPER;
				break;
			}
			case ("glass"):{
				this.type = GarbageTypes.GLASS;
				break;
			}
			case("fabric"):{
				this.type = GarbageTypes.FABRIC;
				break;
			}
			case("metal"):{
				this.type = GarbageTypes.METAL;
				break;
			}
			case("organic"):{
				this.type = GarbageTypes.ORGANIC;
				break;
			}
		}
		// end of the costructor.
	}
	
	
	
	public String getName() {
		return name;
	}



	public GarbageTypes getType() {
		return type;
	}


	public boolean equals (Garbage garbageToCompare) {
		if(garbageToCompare == null) {
			return false;
		}
		else {
			return garbageToCompare.getName().equals(name) && garbageToCompare.getType().equals(type);
		}
	}
	
	public String toString() {
		return name + ", " + type.toString();
	}
}
