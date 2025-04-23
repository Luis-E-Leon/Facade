package subsystem;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter {
    public void write(String filePath, String content) throws Exception {
        Files.write(Paths.get(filePath), content.getBytes());
    }
}
