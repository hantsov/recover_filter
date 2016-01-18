package homework;

import homework.lib.TextIO;

/**
 * Kysib kaks Stringi, mis on
 * moeldud kasutamaks JavaHomework
 * klassis input/output kataloogitee
 * maaramiseks
 * @author Hardi Antsov
 *
 */

public class KasutajaSisestus {
	
	public String sourceout1, sourceout2 = null;
	
	public String kasutajaSisestusSource() {
		
		System.out.println("Anna faili asukoht!");
		System.out.println("Naide: /path/path/path/fail.raw");
		sourceout1 = TextIO.getlnString();
		return sourceout1;
	}
	public String kasutajaSisestusDestination() {
		System.out.println("Kuhu tulemuse valjastan?");
		System.out.println("Naide: /path/path/path");
		sourceout2 = TextIO.getlnString();
		return sourceout2;
	}


}
