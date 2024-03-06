package Recycle_Bin_Package;

import Garbage_Package.Garbage;
import Interfaces.IBag;

public class OrganicRecycleBin<G extends Garbage> extends RecycleBin<G> implements IBag<G> {
	
	private final String type = "ORGANIC";
	
	public OrganicRecycleBin() {
		super();
	}
	
	public boolean add(G garbage) {
		
		if(garbage.getType().toString().equals(type)){
			return super.add(garbage);
		}
		else {
			return false;
		}
	}
	
	public void displayItems() {
		System.out.println(" ");
		System.out.println("Organic Recycle Bin Object: ");
		System.out.println("There are " + getItemCount() + " garbages in there.");
		super.displayItems();
		}
}
