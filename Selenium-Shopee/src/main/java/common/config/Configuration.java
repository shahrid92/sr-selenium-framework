package common.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;


@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "classpath:general.properties"
})
public interface Configuration extends Config {

    @Key("driver.mode")
    String mode();
    @Key("browser")
    String browser();
    @Key("url.base")
    String urlBase();

}
