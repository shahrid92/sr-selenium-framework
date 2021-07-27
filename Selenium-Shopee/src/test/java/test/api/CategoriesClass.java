package test.api;

import java.util.HashMap;
import java.util.Map;

public class CategoriesClass {

    private Map<String,String> main= new HashMap<>();

    public Map<String, String> getMain() {
        return main;
    }

    public void setMain(Map<String, String> main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "CategoriesClass{" +
                "main=" + main +
                '}';
    }
}
