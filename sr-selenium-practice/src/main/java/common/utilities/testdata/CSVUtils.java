package common.utilities.testdata;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVUtils {

    public static Object[][] getTableArray(String filePath) throws Exception {
        Object[][] tabArray = null;

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> allData = csvReader.readAll();
            int totalRows = allData.size();
            int totalCols = allData.get(0).length;

            tabArray = new String[totalRows][totalCols];

            for (int i = 0; i < totalRows; i++) {
                for (int j = 0; j < totalCols; j++) {
                    tabArray[i][j] = allData.get(i)[j];
                    System.out.println(tabArray[i][j]);
                }
            }

        } catch (IOException e) {
            System.out.println("Could not read the CSV file");
            e.printStackTrace();
        }

        return tabArray;
    }
}
