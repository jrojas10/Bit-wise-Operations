import java.io.File;

public class PPMImageSub extends PPMImage {

	public PPMImageSub(File file) {
		super(file);

	}

	public void hideMsg(String message) {
		message = null;
	}

	public String returnMsg() {
		String s = null;
		return s;
	}

	public void grayscale() {
		char[] a = getPixelData();
		int size = a.length;//494475
		for (int i = 0; i < a.length; i += 3) {
			char R = a[i];
			char G = a[i + 1];
			char B = a[i + 2];

			char newRed = (char) ((R * .299) + (G * .587) + (B * .114));
			char newGreen = (char) ((R * .299) + (G * .587) + (B * .114));
			char newBlue = (char) ((R * .299) + (G * .587) + (B * .114));
			
			
			a[i] = newRed;
			a[i+1] = newGreen;
			a[i+2] = newBlue;
		}

		
	}

	public void sepia() {
		char[] a = getPixelData();
		for (int i = 0; i < a.length; i += 3) {
			char R = a[i];
			char G = a[i + 1];
			char B = a[i + 2];

			char newRed = (char) ((R * .393) + (G * .769) + (B * .189));
			char newGreen = (char) ((R * .349) + (G * .686) + (B * .168));
			char newBlue = (char) ((R * .272) + (G * .534) + (B * .131));
			if(newRed >255)
				newRed =255;
			if(newGreen > 255)
				newGreen = 255;
			if(newBlue > 255)
				newBlue = 255;
			
			a[i] = newRed;
			a[i+1] = newGreen;
			a[i+2] = newBlue;
		}
		
	}

	public void negative() {
		char[] a = getPixelData();
		for (int i = 0; i < a.length; i += 3) {
			char R = a[i];
			char G = a[i + 1];
			char B = a[i + 2];

			char newRed = (char) (255 - R);
			char newGreen = (char) (255 - G);
			char newBlue = (char) (255 - B);
			
			a[i] = newRed;
			a[i+1] = newGreen;
			a[i+2] = newBlue;
		}
		
	}
}
