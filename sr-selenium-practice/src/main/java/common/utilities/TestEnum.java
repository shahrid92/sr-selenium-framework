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
    public List<TestEnum> reportCriteria(){

        List<TestEnum> criteria = new ArrayList<>();

        criteria.add(EMPLOYER_NAME);
        criteria.add(EMPLOYMENT_STATUS);
        criteria.add(PAYGRADE);

        return criteria;
    }

    public static TestEnum fromValue(String value) {
        for (TestEnum criterion : TestEnum.values()) {
            if (criterion.toString().equalsIgnoreCase(value)) {
                return criterion;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }

}
