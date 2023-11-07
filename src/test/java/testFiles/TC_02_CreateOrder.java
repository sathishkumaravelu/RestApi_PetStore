package testFiles;

import base.RA_Wrapper;
import entities.storePOJO.CreateOrderRequestBody;
import io.restassured.response.Response;
import main.dataprovider.CreateOrderDP;
import org.testng.annotations.Test;

public class TC_02_CreateOrder extends RA_Wrapper {


    @Test(dataProvider = "getData", dataProviderClass = CreateOrderDP.class)
    public void tc_createOrder(CreateOrderRequestBody orderData) {
        Response order = createOrder(orderData);
        System.out.println(order.getStatusCode());
    }
}
