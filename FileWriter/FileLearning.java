package FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class FileLearning {

  public static void main(String[] args) throws IOException {
    // Defining a Path
    String basePath = "/Users/francescopanico/Desktop/Francesco/Vari/Studio/backend-dev/java-learning/FileWriter";
    String dirName = "Files";
    String filePath = "firstExample.txt";
    Path path = Path
        .of(basePath);
    System.out.println("Path: " + path + " exist: " + Files.exists(path));

    // Create directories, temporary files and files
    Path dir = Files.createDirectory(path.resolve(dirName));
    Path tmpFile = Files.createTempFile(dir, "tempFile", ".txt");
    Path newFile = Files.createFile(dir.resolve(filePath));

    // Reading permissions on path
    try {
      Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
      System.out.println("Permission of " + path + " = " + permissions);
    } catch (UnsupportedOperationException e) {
      System.err.println("Error on reading permissions");
    }

    // Reading and Writing Files
    Files.writeString(newFile, "This is a string");
    String s = Files.readString(newFile);
    System.out.println("String on file " + newFile + ": " + s);

    // Move deleting and listing files

  }

}
