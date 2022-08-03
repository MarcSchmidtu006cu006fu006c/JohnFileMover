import java.io.*;

public class ExtensionCheck {

    public String getFileExtension(String fullName){
        if(fullName.equals(null)){
            return null;
        } else{
            String fileName = new File(fullName).getName();
            int dotIndex = fileName.lastIndexOf('.');
            return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
        }
    }
}
