package homework;

import homework.Konverter;



/**
 * Kaib baidi kaupa labi etteantud
 * binaarkoodis faili ning leiab
 * vastavate tunnusbaitidega andmed
 * ning kopeerib neid antud blokisuuruse
 * (buffer) kaupa, otsides iga bloki algusest
 * neid samu tunnusbaite, et kindlas teha,
 * millal uus fail algab.
 * Baseerub David J. Malani CSI ulesandel.
 * @author Hardi Antsov
 *
 */
public class JavaHomework {
	
	
	public static void main(String[] args) {
		
		
		// Antakse kataloogiteed
		KasutajaSisestus kasutajaSisestus = new KasutajaSisestus();
		kasutajaSisestus.sourceout1 = kasutajaSisestus.kasutajaSisestusSource();
		kasutajaSisestus.sourceout2 = kasutajaSisestus.kasutajaSisestusDestination();
		// Avab input faili
		Ekstraktor ekstraktor = new Ekstraktor(kasutajaSisestus.sourceout1, kasutajaSisestus.sourceout2);
		if(ekstraktor.ekstraktor()) {
			System.out.println("Pildid leitud, alustan filtreerimist:");
			Konverter konverter = new Konverter(kasutajaSisestus.sourceout2, kasutajaSisestus.kasutajaSisestusDestination());
			konverter.pildidMustValge();
		}
		System.out.println(".txt logifailid: ");
		KeepTrack.txtLogid();
		System.out.println(KeepTrack.keepTrack);
		
		return;

	}

}
