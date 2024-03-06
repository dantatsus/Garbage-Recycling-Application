package Interfaces;

import Garbage_Package.Garbage;
import Garbage_Package.GarbageTypes;

public interface IGarbage {
	
	
	
	public String getName();
	public GarbageTypes getType();
	
	public String toString();
	public boolean equals (Garbage garbageToCompare);
}
