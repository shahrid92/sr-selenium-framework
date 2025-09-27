package common.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class AllureResultDTO {

    private String uuid;
    private String name;
    private String start;
    private String stop;
    private String status;

}
