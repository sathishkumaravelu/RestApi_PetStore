package testFiles;

import base.RA_Wrapper;
import entities.storePOJO.CreateOrderRequestBody;
import io.restassured.response.Response;
import main.dataprovider.CreateOrderDP;
import org.junit.Assert;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

public class TC_02_CreateOrder extends RA_Wrapper {


    @Test(dataProvider = "getData", dataProviderClass = CreateOrderDP.class)
    public void verifyCreateOrderAndDelete(CreateOrderRequestBody orderData) {
        Response order = createOrder(orderData);
        System.out.println(order.getStatusCode());
        orderId = order.getBody().jsonPath().get("id");
        System.out.println(orderId);
        Response getOrderResponse = getOrder(order.getBody().jsonPath().get("id"));
        System.out.println("******************************");
        getOrderResponse.prettyPrint();
        Assert.assertEquals(200,getOrderResponse.statusCode());


    }
}
