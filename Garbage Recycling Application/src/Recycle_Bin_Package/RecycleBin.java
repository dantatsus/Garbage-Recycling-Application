package Recycle_Bin_Package;

import java.util.Random;

import Garbage_Package.Garbage;
import Interfaces.IBag;

public abstract class RecycleBin<G extends Garbage> implements IBag<G> {
	
	// This is an parent class for all of child bin classes.
	
	private G[] bin;
	private int numberOfGarbages;
	private int size;

	@SuppressWarnings("unchecked")
	public RecycleBin() {
		
		Random random = new Random(); 
		// The sizes of recycling bins are determined randomly.
		
		switch(random.nextInt(1, 4)) {
			case 1:{
				size = 5;
				break;
			}
			case 2:{
				size = 10;
				break;
			}
			case 3:
				size = 15;
				break;
		}
		
		bin = (G[]) new Garbage[size];
		numberOfGarbages = 0;
	}
	
	public boolean add(G garbage) {
		boolean result = true;
		if(isFull()) {
			result = false;
		}
		else {
			bin[numberOfGarbages] = garbage;
			numberOfGarbages++;
		}
		return result;
	}
	
	public boolean isFull() {
		return numberOfGarbages >= bin.length;
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
	}
	
	public boolean contains (G garbage) {
		boolean found = false;
		int index = 0;
		while(!found && (index < numberOfGarbages)) {
			if (garbage.equals(bin[index])) {
				found = true;
			}
			index++;
		}
		return found;
	}
	
	public G remove() {
		G result = null;
		if (numberOfGarbages > 0) {
			result = bin[numberOfGarbages - 1];
			bin[numberOfGarbages - 1] = null;
			numberOfGarbages--;
		}
		return result;
	}
	
	public G removeByIndex(int index) {
		G result = null;
		if (!isEmpty() && (index >= 0)) {
			result = bin[index];
			bin[index] = bin[numberOfGarbages - 1];
			numberOfGarbages--;
		}
		return result;
	}
	
	public boolean remove(G garbage) {
		int index = getIndexOf(garbage);
		G result = removeByIndex(index);
		return garbage.equals(result);
	}
	
	public int getIndexOf(G garbage) {
		
		int where = -1;
		boolean found = false;
		int index = 0;
		while(!found && (index < numberOfGarbages)) {
			if (garbage.equals(bin[index])) {
				found = true;
				where = index;
			}
			index++;
		}
		return where;
	}
	
	public void displayItems() {
		
		for (G garbage : bin)
			if(garbage != null) {System.out.print(garbage.getName() + " // ");}
	}
	
	
	public boolean transferTo(IBag<G> targetBin, G garbage) {
		
		boolean result = false;
		if (!targetBin.isFull() && contains(garbage)) {
			targetBin.add(garbage);
			remove(garbage);
			result = true;
		}
		return result;
	}
	
	public int getSize() {
		return size;
	}
	
}
