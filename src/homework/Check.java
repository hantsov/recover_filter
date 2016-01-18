package homework;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Sisaldab kahte meetodit, mis kontrollivad
 * kas tegemist on noutud tunnusbaitidega
 * @author Hardi Antsov
 *
 */
public class Check {
	
	/**
	 * Kontrollib, kas tegemist on vajatud tunnusbaitidega.
	 * @param Sisestuses RandomAccessFile-na avatud fail
	 * @return Tagasab bool jah/ei, kas leidis baidid voi mitte
	 * 
	 */
	
	public static boolean check (RandomAccessFile filestream) throws IOException {
		int check = filestream.read();
		if(check == 255) {
			check = filestream.read();
			if (check == 216) {
				check = filestream.read();
				if(check == 255) {
					check = filestream.read();
					if(check == 224 || check == 225)
						return true;
					else {
						if (check == -1)
							return true;
						return false;
					}
				}
				else {
					if (check == -1)
						return true;
					return false;
				}
			}
			else {
				if (check == -1)
					return true;
				return false;
			}
		}
		else {
			if(check == -1)
				return true;
			return false;
		}
	}
	/**
	 * Moeldud parast tunnusbaitide leidmist failisisest kursorit
	 * "tagasi" kerima, kui avastatakse uut faili identifitseeriv
	 * tunnusbaitide kogumik
	 * @param Sisestuses RandomAccessFile-na avatud fail
	 * @return Tagasab bool jah/ei, kas leidis baidid voi mitte
	 * 
	 */
	
	public static boolean checkTwo (RandomAccessFile filestream) throws IOException {
		int check = filestream.read();
		if(check == 255) {
			check = filestream.read();
			if (check == 216) {
				check = filestream.read();
				if(check == 255) {
					check = filestream.read();
					if(check == 224 || check == 225)
						return true;
					else {
						if (check == -1)
							return true;
						filestream.seek((filestream.getFilePointer())-4);
						return false;
					}
				}
				else {
					if (check == -1)
						return true;
					filestream.seek((filestream.getFilePointer())-3);
					return false;
				}
			}
			else {
				if (check == -1)
					return true;
				filestream.seek((filestream.getFilePointer())-2);
				return false;
			}
		}
		else {
			if(check == -1)
				return true;
			filestream.seek((filestream.getFilePointer())-1);
			return false;
		}
	}
}
