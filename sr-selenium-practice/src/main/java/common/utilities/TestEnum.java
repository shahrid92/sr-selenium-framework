package common.utilities;
import java.util.ArrayList;
import java.util.List;

public enum TestEnum {

    APP_CONFIG("user.dir"),
    CHROME("chrome"),
    EDGE("edge"),
    FIREFOX("firefox"),
    BROWSER("browser"),
    BASEURL("base_url"),
    ADMIN_USERNAME_TEXTFIELD("employee_username"),
    EMPLOYER_NAME("Employee Name"),
    EMPLOYMENT_STATUS("Employment Status"),
    PAYGRADE("Pay Grade"),

    REPORT("");

    private final String text;

    TestEnum(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }

    /**
     *test
     * <b>test</b>
     * @return
     */
    public List<String> reportCriteria(){

        List<String> criteria = new ArrayList<>();

        criteria.add(EMPLOYER_NAME.toString());
        criteria.add(EMPLOYMENT_STATUS.toString());
        criteria.add(PAYGRADE.toString());

        return criteria;
    }

}
