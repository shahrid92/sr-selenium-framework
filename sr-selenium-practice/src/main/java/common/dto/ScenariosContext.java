package common.dto;

import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter @Setter
public class ScenariosContext {
    private String uuid;
    private Collection<String> tagList;
    private String name;
    private String status;
    private Boolean failedStatus;

}
