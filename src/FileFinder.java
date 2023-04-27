import java.io.File;
import java.util.ArrayList;

public class FileFinder
{
    private File[] children;
    static ArrayList<String> fileList = new ArrayList<>();

    public FileFinder(File startingDirectory)
    {
        children = startingDirectory.listFiles();
    }

    public ArrayList<String> find(String extension)
    {
        for (File child : children)
        {
            String fileName = child.toString();
            if (child.isDirectory())
            {
                FileFinder finder = new FileFinder(child);
                finder.find(extension);
            }
            else
            {
                fileList.add(fileName);
            }
        }
        return fileList;
    }
}
