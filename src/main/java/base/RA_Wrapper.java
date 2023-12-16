package base;

import entities.storePOJO.CreateOrderRequestBody;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import utils.AppProperties;
import utils.ApplicationProLoader;
import utils.PropertiesCache;
import utils.PropertiesReader;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class RA_Wrapper extends RA_Implementation {
//    PropertiesCache sys;
    public static int orderId;
//
//    {
//        try {
//            sys = new PropertiesCache();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private final String basePath =  sys.getProperty("version") + "/" + sys.getProperty("storeModule") + "/" + "order";


    private final String basePath = ApplicationProLoader.loadProps().version() +
            "/" ;
    public Response getOrder(int orderId) {
        return getToAPI(ApplicationProLoader.loadProps().endpoint(),
                Map.of("Accept", "Application/json"),
                basePath+ ApplicationProLoader.loadProps().storeModule()+"/order/"+orderId);
    }

    public Response createOrder(Object reqBody){
        return postToAPI(ApplicationProLoader.loadProps().endpoint(),
                Map.of("Accept", "Application/json","Content-Type","Application/json"),
                basePath+ ApplicationProLoader.loadProps().storeModule()+"/order/",reqBody);
    }

    public Response deleteOrder(int orderId) {
        return deleteToAPI(ApplicationProLoader.loadProps().endpoint(),
                Map.of("Accept", "Application/json"),
                basePath + ApplicationProLoader.loadProps().storeModule()+ "/order/" + orderId);
    }

    public Response createUser(Object reqBody){
        return postToAPI(ApplicationProLoader.loadProps().endpoint(),
                Map.of("Accept", "Application/json","Content-Type","Application/json"),
                basePath+ApplicationProLoader.loadProps().userModule()+"/createWithArray",reqBody);
    }

}
