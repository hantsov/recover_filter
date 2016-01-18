package homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class Ekstraktor {
	
	/**
	 * Otsib etteantud failist .jpg nelja tunnusbaiti
	 * ja kopeerib nende leidmisel
	 * andmed uude faili. 
	 * @author Hardi Antsov
	 */
	
	// Loob puhvri ja faili muutujad
	private byte buffer[] = new byte[512];
	private int counter=0;
	private RandomAccessFile in = null;
	private FileOutputStream out = null;
	String kasutajaSisestus1, kasutajaSisestus2;
	
	public Ekstraktor (String kasutajaSisestus1, String kasutajaSisestus2) {
		this.kasutajaSisestus1 = kasutajaSisestus1;
		this.kasutajaSisestus2 = kasutajaSisestus2;
	}
	// Avab input faili
	public boolean ekstraktor() {
		
		
		KeepTrack tracker = new KeepTrack();
		tracker.logi("Executing ekstraktor");
		
		try{
			in = new RandomAccessFile(kasutajaSisestus1, "r");
		} catch (FileNotFoundException e){
			System.err.println("Faili ei leitud: " + e.getMessage());
			KeepTrack.programmiLogi.add("Error " + e.getMessage());
		}
		try {
			for (int c = in.read(); c != -1; c = in.read()) {
				if(c == 255) {
					in.seek((in.getFilePointer())-1);
					if(Check.check(in)) {
						tracker.logi("JPG Found");
						in.seek((in.getFilePointer())-4);
						out = new FileOutputStream(kasutajaSisestus2 + "/ "+ counter + ".jpg");
						do {
							in.read(buffer, 0, 512);
							out.write(buffer);
						} while (Check.checkTwo (in) == false);
						in.seek((in.getFilePointer())-4);
						out.close();
						counter++;
						tracker.keepingTrack(kasutajaSisestus2 + "/ "+ counter + ".jpg");
					}
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException:" + e.getMessage());
			KeepTrack.programmiLogi.add("Error " + e.getMessage());
			return false;
		} catch (Exception e){
			System.err.println("Mingi muu exception:" + e.getMessage());
			KeepTrack.programmiLogi.add("Error " + e.getMessage());
			return false;
		}
		return true;
	}
}
