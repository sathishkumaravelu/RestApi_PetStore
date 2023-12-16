package entities.storePOJO;

import lombok.Data;

import java.util.List;

@Data
public class CreateUserRequestBody {
    private List<User> users;


}
