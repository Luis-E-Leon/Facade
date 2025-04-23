package facade;

import subsystem.FileReader;
import subsystem.FileWriter;
import subsystem.FileEncryptor;

public class Facade {
    private static Facade instance;

    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final FileEncryptor fileEncryptor;

    private Facade() {
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
        this.fileEncryptor = new FileEncryptor();
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public void writeEncrypted(String filePath, String content) throws Exception {
        String encrypted = fileEncryptor.encrypt(content);
        fileWriter.write(filePath, encrypted);
    }

    public String readDecrypted(String filePath) throws Exception {
        String encrypted = fileReader.read(filePath);
        return fileEncryptor.decrypt(encrypted);
    }
}
