package entities.storePOJO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
public class CreateOrderRequestBody {
    private long id;
    private long petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}
