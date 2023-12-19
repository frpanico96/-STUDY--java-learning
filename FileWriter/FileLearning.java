package FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    // Move listing files
    try {
      Path movedFile = Files.move(tmpFile, Path.of(basePath + "/" + filePath));
      Files.delete(movedFile);
    } catch (FileAlreadyExistsException e) {
      System.err.println("Error on moving file");
    }

    try (var files = Files.list(dir)) {
      files.forEach(System.out::println);
    }

    // Absolute, Relative and Canonical Files
    System.out.println(basePath + " is absolute: " + path.isAbsolute());
    Path relativePath = Path.of("../FileWriter");
    System.out.println(relativePath + " is absolute: " + relativePath.isAbsolute());
    Path canonicalPath = relativePath.normalize().toAbsolutePath();
    System.out.println(canonicalPath + " is absolute: " + canonicalPath.isAbsolute());
    Path relativezedPath = Paths.get(basePath).relativize(canonicalPath);
    System.out.println(relativezedPath + " is absolute: " + relativezedPath.isAbsolute());

    // Deleting files
    try {
      Files.delete(newFile);
      Files.delete(dir);
    } catch (FileNotFoundException e) {
      System.err.println("Error on deleting file");
    }
  }

}
