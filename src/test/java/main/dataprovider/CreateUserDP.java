package main.dataprovider;

import entities.storePOJO.CreateUserRequestBody;
import entities.storePOJO.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CreateUserDP {
    private static Response response;

    public void testData(){
      response  = RestAssured.given().get("https://random-data-api.com/api/v2/users?size=1&response_type=json");
    }



    private  String generateId() {
        return response.getBody().jsonPath().get("id").toString();
    }

    private  String generateUserName() {
        return response.getBody().jsonPath().get("username");
    }
    private  String generateFirstName() {
        return response.getBody().jsonPath().get("first_name");
    }
    private  String generateLastName() {
        return response.getBody().jsonPath().get("last_name");
    }

    private  String generateEmail() {
        return response.getBody().jsonPath().get("email");
    }
    private  String generatePhoneNo() {
        return response.getBody().jsonPath().get("phone_number");
    }
    private  String generatePassword() {
        return response.getBody().jsonPath().get("password");
    }
    private int generateUserStatus() {
        Random random = new Random();
        int[] statusList = {0, 1};
        return statusList[random.nextInt(statusList.length)];
    }

    @DataProvider
    public Object[][] getData() {
        testData();
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(generateId());
        user.setUsername(generateUserName());
        user.setFirstName(generateFirstName());
        user.setLastName(generateLastName());
        user.setEmail(generateEmail());
        user.setPassword(generatePassword());
        user.setPhone(generatePhoneNo());
        user.setUserStatus(generateUserStatus());
        users.add(user);

        CreateUserRequestBody order = new CreateUserRequestBody();
        order.setUsers(Collections.singletonList(user));

        return new Object[][]{{order}};
    }
}
