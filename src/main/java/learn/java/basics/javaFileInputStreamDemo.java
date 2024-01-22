package learn.java.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

public class javaFileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        String filePath = getFilePath();
        System.out.println("userDir = " + filePath);
        File file = new File(filePath);
        String str = "this test";
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print("i = " + (char) i);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Objects.requireNonNull(fileInputStream).close();
            Objects.requireNonNull(fileOutputStream).close();
        }


    }

    private static String getFilePath() {
        String userDir = System.getProperty("user.dir");
        String filePathString = "/src/main/java/learn/java/basics/temp1.txt";
        StringBuilder sb = new StringBuilder();
        Stream.of(filePathString).map(c -> {
            if (c.equals("/"))
                return File.separator;
            return c;
        }).forEach(sb::append);
        String filePath = userDir + filePathString;
        return filePath;
    }
}
