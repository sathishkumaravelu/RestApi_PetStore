package testFiles;

import base.RA_Wrapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TC_01_CreateOrder extends RA_Wrapper {

    @Test
    public void tcCreateOrder(){
        Response order = getOrder("100");
        System.out.println(order.getStatusCode());
    }
}
