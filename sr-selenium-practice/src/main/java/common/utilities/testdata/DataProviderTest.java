package common.utilities.testdata;

import org.testng.annotations.DataProvider;


public class DataProviderTest {

    @DataProvider(name = "userlist")
    public static Object[][] credentials() throws Exception {

        //Object[][] testObjArray = ExcelUtils.getTableArray("src/test/resources","Sheet1");
        Object[][] testObjArray = CSVUtils.getTableArray("src/test/resources/test.csv");

        return (testObjArray);

    }
}
