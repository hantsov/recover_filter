package homework;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Konverter {
	/**
	 * Konverteerib varvlise jpg
	 * mustvalgeks BufferedImage ja
	 * bitwise operaatorite
	 * abil.
	 * @author Hardi Antsov
	 */

	public String input, output;

	public Konverter(String input, String output) {
		this.input = input;
		this.output = output;
	}
	
	public void pildidMustValge () {

		KeepTrack tracker = new KeepTrack();
		tracker.logi("Executing Konverter");
		
		try {
			File path = new File (this.input);
			int counter = 0;
			for(File inputFile : path.listFiles() ) {
				
				inputFile = new File(this.input+"/ "+counter+".jpg");
				BufferedImage image = ImageIO.read(inputFile);
				File outputFile = new File(this.output+"/"+counter+"mustvalge.jpg");
				for (int i = 0; i < image.getWidth(); i++) {
					for(int j = 0; j<image.getHeight(); j++) {
						
						int rgb2 = image.getRGB(i, j);
						
						// bitwise operaatorite kasutamisel oli abiks
						// stackoverflow's postitus kasutaja "camickr" poolt
						
						int red = (rgb2 >> 16) & 0xFF;
						int green = (rgb2 >> 8) & 0xFF;
						int blue = rgb2 & 0xFF;
						// Vaartused parinevad YUV-lt
						red = (int) (red*0.299);
						green = (int) (green * 0.587);
						blue = (int) (blue * 0.114);
						int grayScale = red + green + blue;
						red = grayScale;
						green = grayScale;
						blue = grayScale;
						rgb2 = red;
						rgb2 = (rgb2 << 8) + green;
						rgb2 = (rgb2 << 8) + blue;
						image.setRGB(i, j, rgb2);
					}
				}
				ImageIO.write(image, "jpg", outputFile);
				counter++;
				tracker.logi("JPG Filtered");
				tracker.keepingTrack(this.output+"/"+counter+"mustvalge.jpg");
			}
		}catch (Exception e){
			System.err.println("Error " + e.getMessage());
			KeepTrack.programmiLogi.add("Error " + e.getMessage());
		}
	}
}
