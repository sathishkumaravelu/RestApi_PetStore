package testFiles.userModule;

import base.RA_Wrapper;
import entities.storePOJO.CreateOrderRequestBody;
import entities.storePOJO.CreateUserRequestBody;
import io.restassured.response.Response;
import main.dataprovider.CreateOrderDP;
import main.dataprovider.CreateUserDP;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC_01_CreateUser extends RA_Wrapper {


    @Test(dataProvider = "getData", dataProviderClass = CreateUserDP.class)
    public void verifyUserCreated(CreateUserRequestBody orderData) {
        Response user = createUser(orderData);
        System.out.println(user.getStatusCode());

    }
}
