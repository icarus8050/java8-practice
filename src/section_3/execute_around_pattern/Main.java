package section_3.execute_around_pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("./src/section_3/execute_around_pattern/data.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(processFile(b -> b.readLine()));
            System.out.println(processFile(b -> b.readLine() + "\n" + b.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
