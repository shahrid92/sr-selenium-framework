package test.api;

//import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class DemoApiTest {

    Response res;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testapi(){

        /*
        *
        *  verify json structure using hemcrest
        *
        *
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

    }

}
