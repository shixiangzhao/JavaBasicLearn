package shixzh.jbl.nio.file;

import static java.io.File.separator;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {

    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        String myDir = userDir + separator + "src" + separator + "main" + separator + "java"
                + separator + "shixzh" + separator + "jbl" + separator + "nio";

        String myFile = myDir + separator + "test.zip";
        
        testVisitFile(myDir);
        System.out.println("===============================");
        testFileSystem(myFile);
    }

    private static void testVisitFile(String myDir) throws IOException {
        Files.walkFileTree(Paths.get(myDir), new SimpleFileVisitor<Path>() {

            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                if (attrs.isDirectory()) {
                    System.out.println(path);
                }
                System.out.println(path.getFileName());
                System.out.println(attrs.creationTime());
                return FileVisitResult.CONTINUE;
            }

            public FileVisitResult visitFileFailed(Path path, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }
    
    private static void testFileSystem(String zipname) throws IOException {
        FileSystem fs = FileSystems.newFileSystem(Paths.get(zipname), null);
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>(){
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
