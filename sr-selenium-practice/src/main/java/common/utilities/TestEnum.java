package common.utilities;

public enum TestEnum {

    APP_CONFIG("user.dir"),
    CHROME("chrome"),
    EDGE("edge"),
    FIREFOX("firefox");

    private final String text;

    TestEnum(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }

}
