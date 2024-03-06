package Interfaces;

import Garbage_Package.Garbage;
import Trash_Can_Package.TrashCan;

public interface IFileIO {
	
	// private int getLengthOfFile(String path);
	public String[] getDatasFromFile(String path);
	
	public void transferGarbagesToCan(String[] datas);
	
	public boolean updateTrashCan();
	public TrashCan<Garbage> readTrashCan();
	
	public void separateOperation();
	
}
