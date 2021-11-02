package ZIP;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class Zip_File_Test {
	public static void main(String[] args) {
		Zip_File_Test.zip_one_file();
	}
	public static void zip_one_file() {
    	byte[] buffer = new byte[1024];
    	try{
    	FileOutputStream fos = new FileOutputStream("D:\\zip project\\versionchanges.zip");
                try (ZipOutputStream zos = new ZipOutputStream(fos)) {
                    ZipEntry ze= new ZipEntry("D:\\zip project\\versionchanges.txt");
                    zos.putNextEntry(ze);
                    FileInputStream in = new FileInputStream("D:\\zip project\\versionchanges.txt");
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }           in.close();
                    zos.closeEntry();
                    //remember close it
                }
    	System.out.println("Done");
    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
	}
}