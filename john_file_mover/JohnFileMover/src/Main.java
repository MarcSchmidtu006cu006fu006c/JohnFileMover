import java.util.*;
import java.io.*;
import java.time.*;


/**
 * The purpose of this very small java program is take image files from an input folder and
 * move them to a destination folder. The entire application's only purpose is to
 * move none zip files to the destination folder and rename them to include the current date.
 * Being as this is only a three class program I did not comment throughout. This project is intended to be
 * used by just one person who will never be accessing the source code.
**/
 public class Main {


    public static void main(String[] args) throws IOException{

        ExtensionCheck extCheck = new ExtensionCheck();
        CopyFile cpyFile = new CopyFile();

        Scanner in = new Scanner(System.in);

            System.out.println("Hey John, please enter the file path of the input folder and press enter.");
            System.out.println("example --> C:\\Documents\\3D_printer_images\\");

        String inputFilePath = in.nextLine();

            System.out.println("Now please enter the file path of the intended output folder and press enter");
            System.out.println("example --> C:\\Documents\\3D_printer_images_output\\");

        String outputFilePath = in.nextLine();

        in.close();

        File inputFolder = new File(inputFilePath);
        File outputFolder = new File(outputFilePath);

        System.out.println("this is the input folder: " + inputFolder);

        if (inputFolder.exists() && outputFolder.exists()){
            System.out.println("Input and Output Folders found");
        } else {
            System.out.println("Folders not found please check file path");
        }

        File[] lifeOfFiles = inputFolder.listFiles();


        String desFileName = "";
        String currentDate = LocalDate.now().toString();

        for (File file : lifeOfFiles){
            if (file.isFile()){
                if (extCheck.getFileExtension(file.getName()) != "zip"){
                    System.out.println("copying and renaming files.....");
                    cpyFile.copyFileUsingStream(new File(inputFolder + "\\" + file.getName()), new File(outputFolder + "\\" + currentDate + " " + file.getName()));
                }
            }
        }
    }
}