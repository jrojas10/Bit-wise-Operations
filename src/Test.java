import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// get character and check last bit
		// compare with character in string and
		// check last bit, turn on or off so they match
		// make sure it writes chars to file
		// pipe(|) turns on
		// ampersand(&) checks bit, if 0 bit is off, if any # it means it is
		// on(1);

		PPMImageSub p = new PPMImageSub(new File("C:\\Users\\user\\Desktop\\dog.ppm"));
		char[] arrayPixel = p.getPixelData();
		String s = "my name is juan";
		System.out.println(s);
		char[] stringToArray = s.toCharArray();

		char a = 'a';
		char mask = (1 << (0)); // or 1
		char offMask = (char) ~(1 << (0));

		// System.out.println(('b'|mask)== 'c'); //98+1 =99
		// System.out.println(a|mask);//turns on
		// System.out.println(a&offMask);// turns off
		// System.out.println(a&mask);// 0 if off, any number if on
		// System.out.println("new line");
		ArrayList<Character> list = new ArrayList<Character>();
		char[] arrayBin = new char[stringToArray.length * 8];
		String binary = null;
		for (int i = 0; i < stringToArray.length; i++) {
			// String bin = Integer.toBinaryString(stringToArray[i]);
			binary = String.format("%8s", Integer.toBinaryString(stringToArray[i])).replace(' ', '0');
			System.out.println(binary);

			for (int j = 0; j < 8; j++) {
				list.add(binary.charAt(j));

			}

		

		}

		char[] binaryArray = new char[list.size()];
		for (int i = 0; i < list.size(); i++) {
			binaryArray[i] = list.get(i);

		}
		//each pixel is 3 chars
		

		// String str = Integer.toBinaryString(s.getBytes("UTF-8")[0]);
		

	}

}