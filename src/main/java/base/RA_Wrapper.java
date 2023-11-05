package base;

import entities.storePOJO.CreateOrderRequestBody;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.AppProperties;
import utils.ApplicationProLoader;
import utils.PropertiesCache;
import utils.PropertiesReader;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class RA_Wrapper extends RA_Implementation {
    PropertiesCache sys;

    {
        try {
            sys = new PropertiesCache();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final String basePath = "/" + sys.getProperty("version") + "/" + sys.getProperty("storeModule") + "/" + "order" + "/";

    public Response getOrder(String orderId) {
        Response getResponse = getToAPI(sys.getProperty("endpoint"),
                Map.of("Accept", "Application/json"),
                basePath+orderId);
        return getResponse;
    }




}
