package up.krakow;

import java.io.*;
import java.nio.file.Path;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class PackageZIP {

    public void packageArchive(File[] files, String zipName){
        try {
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipName));
//            zipOut.setLevel(Deflater.BEST_COMPRESSION);
            zipOut.setMethod(ZipEntry.STORED);
            zipOut.setLevel(0);
            if (files.length > 0){
                for (File f : files){
                    ZipEntry zipE = new ZipEntry(f.getName());
                    zipOut.putNextEntry(zipE);
                    FileInputStream fileIn = new FileInputStream(f);
                    zipOut.write(fileIn.readAllBytes());
                    fileIn.close();
                    zipOut.closeEntry();
                }
                zipOut.close();
                System.out.println("Spakowano wybrane pliki do pliku " + zipName);
            }else {
                System.out.println("Nie przesłano pliów do spakowania");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unpackageArchive(Path dLocation, String zipName){
        try {
            ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipName));
            ZipEntry zipE;
            while ((zipE = zipIn.getNextEntry()) != null){
                FileOutputStream fOut = new FileOutputStream(
                        new File(dLocation.toString(), zipE.getName()));
                fOut.write(zipIn.readAllBytes());
                fOut.flush();
                fOut.close();
                System.out.println("Rozpakowałem plik " + zipE.getName());
                zipIn.closeEntry();
            }
            zipIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
