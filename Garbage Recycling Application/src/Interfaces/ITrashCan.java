package Interfaces;

import Garbage_Package.Garbage;
import Recycle_Bin_Package.RecycleBin;

public interface ITrashCan<T> extends IBag<T> {

	public boolean separate(RecycleBin<Garbage> bin, T garbage);
	
	public boolean isUpdate();
	public int getPlastic();
	public int getPaper();
	public int getGlass();
	public int getFabric();
	public int getMetal();
	public int getOrganic();
	
}
