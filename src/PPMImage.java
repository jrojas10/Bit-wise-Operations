import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;

public class PPMImage {
    private String magicNumber;
    private int width;
    private int height;
    private int maxColorValue;
    private char[] pixelData;

    public PPMImage(File file) {
        if (!file.getName().toLowerCase().endsWith(".ppm")) {
            throw new RuntimeException("ERROR: File is not a PPM Image.");
        }
        this.loadImage(file);
    }

    public char[] getPixelData() {
        return this.pixelData;
    }

    private void loadImage(File file) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            String string = dataInputStream.readLine();
            if (!string.equals("P6")) {
                throw new RuntimeException("PPMIMAGE READ ERROR: First line is not the magic number P6!");
            }
            this.magicNumber = string;
            String[] arrstring = dataInputStream.readLine().split(" ");
            if (arrstring.length != 2) {
                throw new RuntimeException("PPMIMAGE READ ERROR: Cannot parse width and height values correctly");
            }
            this.width = Integer.parseInt(arrstring[0]);
            this.height = Integer.parseInt(arrstring[1]);
            this.maxColorValue = Integer.parseInt(dataInputStream.readLine());
            this.pixelData = new char[this.width * this.height * 3];
            for (int i = 0; i < this.pixelData.length; ++i) {
                this.pixelData[i] = (char)dataInputStream.readUnsignedByte();
            }
        }
        catch (FileNotFoundException var2_3) {
            System.err.println("ERROR: PPMImage not found!");
        }
        catch (IOException var2_4) {
            System.err.println("ERROR: PPMImage read error! Image probably not in the right format.");
        }
        catch (NumberFormatException var2_5) {
            System.err.println("ERROR: PPMImage read error! Image probably not in the right format.");
        }
        catch (RuntimeException var2_6) {
            System.err.println(var2_6.getMessage());
        }
    }

    public void writeImage(String string) {
        if (!string.toLowerCase().endsWith(".ppm")) {
            throw new RuntimeException("ERROR: File is not a PPM Image.");
        }
        File file = new File(string);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("" + this.magicNumber);
            bufferedWriter.write("\n");
            bufferedWriter.write("" + this.width + " " + this.height);
            bufferedWriter.write("\n");
            bufferedWriter.write("" + this.maxColorValue);
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file, true));
            for (int i = 0; i < this.pixelData.length; ++i) {
                dataOutputStream.writeByte(this.pixelData[i]);
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        }
        catch (FileNotFoundException var3_4) {
            var3_4.printStackTrace();
        }
        catch (IOException var3_5) {
            var3_5.printStackTrace();
        }
    }
}