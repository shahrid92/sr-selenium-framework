package common.utilities.genai;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

public class ReadFeatureFiles {

    public String toString()  {


        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("src/test/resources/features/login.feature"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : lines) {
            System.out.println(line);
        }

        return null;
    }


}
