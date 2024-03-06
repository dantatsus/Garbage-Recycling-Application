package FileIO_Package;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

import Garbage_Package.Garbage;
import Interfaces.IFileIO;
import Recycle_Bin_Package.PlasticRecycleBin;
import Trash_Can_Package.TrashCan;
import Recycle_Bin_Package.*;

public class FileIO implements IFileIO{
	
	private String[] datas;
	private TrashCan<Garbage> can;
	
	public FileIO(TrashCan<Garbage> can) {
		this.can = can;
	}
	
	private int getLengthOfFile(String path){
		
		// Private method to find the length of the file.
		// Usage : getDatasFromFile method
		
        int lenght = 0;

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));

            //Pass the first element
            String lineCounter = reader.readLine();

            //If line is not empty add one to length
            while(lineCounter != null) {
                lenght++;
                lineCounter = reader.readLine(); }
            reader.close();
            return lenght;
        } catch (FileNotFoundException e) {
            System.out.println("An error occured (FileNotFoundException");
        } catch (IOException e) {
            System.out.println("An error occured (IOException");
        }

        return 0;
    }
	
	public String[] getDatasFromFile(String path){
		
		// method to read the txt and csv files.
		
        try {
            int lengthOfFile;

            //Take the file from path
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));

            //Get the number of lines in the file and create the array with that size
            lengthOfFile = getLengthOfFile(path);
            datas = new String[lengthOfFile];

            //Put each line as one String element in array
            for (int i = 0; i<lengthOfFile; i++) {
                datas[i] = reader.readLine();
                
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occured (FileNotFoundException");
        } catch (IOException e) {
            System.out.println("An error occured (IOException");
        }
        
        return datas;
    }
	
	
	// METHODS FOR TRASH CAN
	
	
	public void transferGarbagesToCan(String[] datas) {
		
		for (String garbage : datas) {
			
			StringTokenizer tokenizer = new StringTokenizer(garbage, ",");
			
			if (!tokenizer.hasMoreTokens()){ break;}
			
			// getting name and type from tokenizer
			String name = tokenizer.nextToken();
			String type = tokenizer.nextToken();
			
			// Get how many items do we have and remove all the whitespaces while parse to int
			int count = Integer.parseInt(tokenizer.nextToken().replaceAll("\\s", ""));
			
			// Adding process
			for (int index = 0; index < count; index++) {
				can.add(new Garbage(name, type));
			}			
		}		
	}
	
	public TrashCan<Garbage> readTrashCan() {
		
		// Size
		
		System.out.println("Trash_Can_Size: Size of the can is: " + can.getItemCount());
		
		// Content
		
		System.out.println("Trash_Can_Content: There are " + can.getPlastic() + " plastic, " + can.getPaper()
		+ " paper, " + can.getGlass() + " glass, " + can.getFabric() + " fabric, " + can.getMetal() +
		" metal, and " + can.getOrganic() + " organic garbages in the trash can.");
		System.out.println("Garbages are: ");
		
		can.displayItems();
		
		return can;
	}
	
	public boolean updateTrashCan() {
		if(!can.isUpdate()) {
			System.out.println("There is no update for trash can.");
			return false;
		}
		else {
			System.out.println("Update for trash can:");
			readTrashCan();
			return true;
		}
	}
	
	
	// METHODS FOR RECYCLEBINS
	
	public void separateOperation() {
		
		// Taking all the garbages in this array:
		Garbage[] garbages = can.toArray();
		
		
		// Bin Objects
		PlasticRecycleBin<Garbage> plastic_bin = new PlasticRecycleBin<Garbage>();
		PaperRecycleBin<Garbage> paper_bin = new PaperRecycleBin<Garbage>();
		GlassRecycleBin<Garbage> glass_bin = new GlassRecycleBin<Garbage>();
		FabricRecycleBin<Garbage> fabric_bin = new FabricRecycleBin<Garbage>();
		MetalRecycleBin<Garbage> metal_bin = new MetalRecycleBin<Garbage>();
		OrganicRecycleBin<Garbage> organic_bin = new OrganicRecycleBin<Garbage>();
		
		// We separate the garbages according to their type
		
		for (Garbage garbage : garbages) {
			
			if(garbage.getType().toString().equals("PLASTIC")) {
				if(!plastic_bin.isFull()) {plastic_bin.add(garbage);}
				else {
					plastic_bin.displayItems();
					plastic_bin = new PlasticRecycleBin<Garbage>();
					plastic_bin.add(garbage);
				}
			}
			else if(garbage.getType().toString().equals("PAPER")) {
				if(!paper_bin.isFull()) {paper_bin.add(garbage);}
				else {
					paper_bin.displayItems();
					paper_bin = new PaperRecycleBin<Garbage>();
					paper_bin.add(garbage);
				}
			}
			else if (garbage.getType().toString().equals("GLASS")) {
				if(!glass_bin.isFull()) {glass_bin.add(garbage);}
				else {
					glass_bin.displayItems();
					glass_bin = new GlassRecycleBin<Garbage>();
					glass_bin.add(garbage);
				}
			}
			else if (garbage.getType().toString().equals("FABRIC")) {
				if(!fabric_bin.isFull()) {fabric_bin.add(garbage);}
				else {
					fabric_bin.displayItems();
					fabric_bin = new FabricRecycleBin<Garbage>();
					fabric_bin.add(garbage);
				}
			}
			else if (garbage.getType().toString().equals("METAL")) {
				if(!metal_bin.isFull()) {metal_bin.add(garbage);}
				else {
					metal_bin.displayItems();
					metal_bin = new MetalRecycleBin<Garbage>();
					metal_bin.add(garbage);
				}
			}
			else if (garbage.getType().toString().equals("ORGANIC")) {
				if(!organic_bin.isFull()) {organic_bin.add(garbage);}
				else {
					organic_bin.displayItems();
					organic_bin = new OrganicRecycleBin<Garbage>();
					organic_bin.add(garbage);
				}
			}		
		}
		
		
		plastic_bin.displayItems();
		paper_bin.displayItems();
		glass_bin.displayItems();
		fabric_bin.displayItems();
		metal_bin.displayItems();
		organic_bin.displayItems();
		
		
	}
}
