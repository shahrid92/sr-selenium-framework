package common.dto;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetAllureJson  {

    public AllureResultDTO getAllureResultByUUID(String uuid) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        AllureResultDTO result = mapper.readValue(new File("C:\\Users\\shahr\\Shah Workspace\\01 Practice\\test-automation-practices\\sr-selenium-framework\\sr-selenium-practice\\target\\allure-results\\"+uuid+"-result.json"), AllureResultDTO.class);
        System.out.println("Found " +result.getUuid() + ":" +result.getName());
        return result;
    }
    
}
