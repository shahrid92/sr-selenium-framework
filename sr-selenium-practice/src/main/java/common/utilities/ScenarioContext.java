package common.utilities;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<Context, Object> scenarioContext;

    public ScenarioContext() {
        this.scenarioContext = new EnumMap<>(Context.class);
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key);
    }

    public void checkSize() {
        System.out.println(this.scenarioContext.size());
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key);
    }

}
