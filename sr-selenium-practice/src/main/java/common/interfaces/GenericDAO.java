package common.interfaces;

import common.dto.AllureResultDTO;

public interface GenericDAO {

    void insert(String uuid,String testName,String status, String startTime, String stopTime);
    void create();
    void get(AllureResultDTO allure);

}
