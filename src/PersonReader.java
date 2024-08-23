import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
public class PersonReader {
    public static void  main(String[] args)
    {
        //Declar variables
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        //set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try //code that might trigger exception goes here
        {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();

                inFile = new Scanner(target);

                while(inFile.hasNext())
                {
                    line = inFile.nextLine();
                    System.out.println(line);
                }

                inFile.close();
            }
            else
            {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("IOException Erorr");
            e.printStackTrace();
        }
    }
}
