package common.utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
    PARALLEL_REMOTE("parallel"),
    REPORT(""),
    BROWSER_REMOTE("browser.remote"),
    BROWSER_REMOTE_URL("browser.remote.url"),
    ELEMENTS_TIMEOUT("elements.timeout");

    private final String text;
    //private final Pattern regexp;

    TestEnum(final String text){
        this.text = text;
        //this.regexp = Pattern.compile(pattern.replace(".", "\\.").replace("*", ".*"));
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
