import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileChooser {
    static File[] children;
    static File startingDirectory;
    static ArrayList<String> fileList = new ArrayList<>();


    public static File getFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                startingDirectory = chooser.getSelectedFile();

            } else {
                System.out.println("You did not choose a file. Quitting.");
                System.exit(0);
            }
        } catch (HeadlessException e) {
            throw new RuntimeException(e);
        }
        return startingDirectory;
    }

}
