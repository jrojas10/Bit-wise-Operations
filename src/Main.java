import javax.swing.JFileChooser;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File f = fc.getSelectedFile();
		String name = fc.getSelectedFile().getName();
		System.out.println(name);
//case
		PPMImageSub grayscale = new PPMImageSub(f);
		
		grayscale.grayscale();
		grayscale.writeImage("Grayscale " + name);

		PPMImageSub sepia = new PPMImageSub(f);
		sepia.sepia();
		sepia.writeImage("Sepia " + name);

		PPMImageSub negative = new PPMImageSub(f);
		negative.negative();
		negative.writeImage("Negative " + name);

		System.exit(0);
	}

}
