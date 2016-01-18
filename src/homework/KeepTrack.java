package homework;

import java.io.PrintWriter;
import java.util.ArrayList;

public class KeepTrack {
	
	/**
	 * Salvestab kahte ArrayListi logi()
	 * kaudu programmis toimuvat ja saab hiljem
	 * kasutada staatilist valjatrukkimismeetodit,
	 * et neid .txt failidena salvestada.
	 * @author Hardi Antsov
	 */

	public static ArrayList <String> keepTrack = new ArrayList<String>();
	public static ArrayList <String> programmiLogi = new ArrayList<String>();
	static int total = 0;
	static KasutajaSisestus info = new KasutajaSisestus();

	public void keepingTrack (String sisend1) {
		total++;
		keepTrack.add("Processed filename: " + sisend1 + " Total nr of files: " + total);
	}
	public void logi(String execute) {
		programmiLogi.add(execute);
	}
	public static void txtLogid(){
		try {
			PrintWriter logiTxt = new PrintWriter (info.kasutajaSisestusDestination()+"/logi.txt", "UTF-8");
			PrintWriter failidTxt = new PrintWriter (info.sourceout2+"/filelist.txt", "UTF-8");
			for(String s: programmiLogi) {
				logiTxt.println(s);
			}
			logiTxt.close();
			for(String s: keepTrack) {
				failidTxt.println(s);
			}
			failidTxt.close();
		} catch (Exception e) {
			System.err.println("Error:" +  e.getMessage());
			programmiLogi.add(e.getMessage());
		}

	}
}
