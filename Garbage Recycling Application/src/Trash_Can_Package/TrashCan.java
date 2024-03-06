package Trash_Can_Package;

import Garbage_Package.Garbage;
import Interfaces.IBag;
import Interfaces.ITrashCan;
import Recycle_Bin_Package.*;

public class TrashCan<G extends Garbage> implements IBag<G>, ITrashCan<G> {
	
	// Parameters for Trash Can:
	private G[] can;
	private int numberOfGarbages;
	private final int size = 450;
	private boolean update;
	
	// Garbage types:
	private int plastic = 0;
	private int paper = 0;
	private int glass = 0;
	private int fabric = 0;
	private int metal = 0;
	private int organic = 0;
	
	@SuppressWarnings("unchecked")
	public TrashCan() {
		
		can = (G[]) new Garbage[size];
		numberOfGarbages = 0;
		update = true;
		// end constructor
	}
	
	public boolean add(G garbage) {
		boolean result = true;
		if(isFull()) {
			result = false;
		}
		else {
			can[numberOfGarbages] = garbage;
			numberOfGarbages++;
			update = true;
			switch(garbage.getType().toString()) {
				case ("PLASTIC"):{
					plastic++;
					break;
				}
				case("PAPER"):{
					paper++;
					break;
				}
				case("GLASS"):{
					glass++;
					break;
				}
				case("FABRIC"):{
					fabric++;
					break;
				}
				case("METAL"):{
					metal++;
					break;
				}
				case("ORGANIC"):{
					organic++;
					break;
				}
			}
		}
		return result;
	}
	
	public G[] toArray() {
		
		@SuppressWarnings("unchecked")
		G[] result = (G[]) new Garbage[numberOfGarbages];
		for(int index = 0; index < numberOfGarbages; index++) {
			result[index] = can[index];
		}
		return result;
	}
	
	public boolean isFull() {
		return numberOfGarbages >= can.length;
	}
	
	public boolean isEmpty() {
		return numberOfGarbages == 0;
	}
	
	public int getItemCount() {
		return numberOfGarbages;
	}
	
	public void dump() {
		while (!isEmpty())
			remove();
		update = true;
	}
	
	public boolean contains (G garbage) {
		boolean found = false;
		int index = 0;
		while(!found && (index < numberOfGarbages)) {
			if (garbage.equals(can[index])) {
				found = true;
			}
			index++;
		}
		return found;
	}
	
	public G remove() {
		G result = null;
		if (numberOfGarbages > 0) {
			result = can[numberOfGarbages - 1];
			can[numberOfGarbages - 1] = null;
			numberOfGarbages--;
			update = true;
		}
		return result;
	}
	
	public G removeByIndex(int index) {
		G result = null;
		if (!isEmpty() && (index >= 0)) {
			result = can[index];
			can[index] = can[numberOfGarbages - 1];
			
			can[numberOfGarbages - 1] = null;
			numberOfGarbages--;
			update = true;
		}
		return result;
	}
	
	public boolean remove(G garbage) {
		int index = getIndexOf(garbage);
		G result = removeByIndex(index);
		if (garbage.equals(result)) {
			update = true;
			return true;
		}
		else {return false;}
	}
	
	public int getIndexOf(G garbage) {
		
		int where = -1;
		boolean found = false;
		int index = 0;
		while(!found && (index < numberOfGarbages)) {
			if (garbage.equals(can[index])) {
				found = true;
				where = index;
			}
			index++;
		}
		return where;
	}
	
	public void displayItems() {
		
		for (G garbage : can)
			System.out.println(garbage.toString());
	}
	
	public boolean transferTo(RecycleBin<Garbage> bin, G garbage) {
		boolean result = false;
		if(!bin.isFull() && contains(garbage)) {
			if(bin.add(garbage) && remove(garbage)) {
				result = true;
				update = true;
			}
		}
		if(update) {
			switch(garbage.getType().toString()) {
				case("PLASTIC"):{
					plastic--;
				}
				case("PAPER"):{
					paper--;
				}
				case("GLASS"):{
					glass--;
				}
				case("FABRIC"):{
					fabric--;
				}
				case("METAL"):{
					metal--;
				}
				case("ORGANIC"):{
					organic--;
				}
			}
		}
		return result;
	}
	
	public boolean separate(RecycleBin<Garbage> bin, G garbage) {
		return transferTo(bin,garbage);
	}
	
	
	public boolean isUpdate() {
		return update;
	}

	public int getPlastic() {
		return plastic;
	}

	public int getPaper() {
		return paper;
	}

	public int getGlass() {
		return glass;
	}

	public int getFabric() {
		return fabric;
	}

	public int getMetal() {
		return metal;
	}

	public int getOrganic() {
		return organic;
	}
	
}
