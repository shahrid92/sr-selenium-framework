package common.utilities;

public enum ElementsEnums {

    EMPLOYER_NAME("Employee Name",".oxd-autocomplete-text-input > input"),
    EMPLOYMENT_STATUS("Employment Status",""),
    PAYGRADE("Pay Grade","");

    private final String text;
    private final String path;

    ElementsEnums(final String text,final String path){
        this.text = text;
        this.path = path;
    }

    @Override
    public String toString(){
        return text;
    }

    public String getPath() {return path;}

}


