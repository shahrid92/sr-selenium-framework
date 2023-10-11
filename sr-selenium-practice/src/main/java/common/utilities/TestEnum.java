package common.utilities;

public enum TestEnum {

    APP_CONFIG("user.dir"),
    CHROME("chrome"),
    EDGE("edge"),
    FIREFOX("firefox"),
    BROWSER("browser"),
    BASEURL("base_url");

    private final String text;

    TestEnum(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }

}
