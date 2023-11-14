package testFiles;

import base.RA_Wrapper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC_03_Delete extends RA_Wrapper {

    @Test(dependsOnMethods = {"testFiles.TC_02_CreateOrder.verifyCreateOrderAndDelete"})
    public void verifyDelete(){
        Response response = deleteOrder(orderId);
        response.prettyPrint();
        System.out.println(response.statusCode());

        Response order = getOrder(orderId);
        order.prettyPrint();
        System.out.println(order.statusCode());
        Assert.assertEquals(404,order.statusCode());
    }
}
