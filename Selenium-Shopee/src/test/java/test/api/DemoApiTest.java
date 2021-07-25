package test.api;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DemoApiTest {

    Response res;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testapi(){

        /*
        * Validation json structure using hemcrest
        * which include in rest assured dependencies (compile scope)
        * */

        given().get("https://shopee.com.my/api/v2/item/get?itemid=1503829152&shopid=77764945")
                .then().assertThat()
                .body("item",hasKey("itemid"))
                .body("item.categories[0]",hasKey("display_name"))
                .body("item.categories[0]",hasKey("catid"))
                .body("item.categories[0]",hasKey("image"))
                .body("item.categories[0]",hasKey("no_sub"))
                .body("item.categories[0]",hasKey("is_default_subcat"))
                .body("item.categories[0]",hasKey("block_buyer_platform"));

        /*
         * de-serialization using jayway accessing json path
         * Library :
         * - junit.jupiter
         * - jayway jsonpath
         */

        String json =  given()
                .get("https://shopee.com.my/api/v2/item/get?itemid=1503829152&shopid=77764945")
                .asString();

        String id = JsonPath.read(json, "item.itemid").toString();
        Assertions.assertEquals("1503829152", id);
    }

}
