package App_Initializer_Package;

import FileIO_Package.FileIO;
import Garbage_Package.Garbage;
import Trash_Can_Package.TrashCan;

public class AppInitializer {
	
	public void initializeTheApp() {
		
		// FileIO and TrashCan objects
		TrashCan<Garbage> can = new TrashCan<Garbage>();
		FileIO io = new FileIO(can);
		
		//reading garbage.txt
		String[] datas = io.getDatasFromFile("src/garbage.txt");
		
		//Adding to trash can and read for the first time.
		io.transferGarbagesToCan(datas);
		io.readTrashCan();
		
		// Separate part:
		io.separateOperation();
		io.updateTrashCan();
		
		
	}
	
}
