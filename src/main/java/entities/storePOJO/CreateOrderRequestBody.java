package entities.storePOJO;

import lombok.Data;


@Data
public class CreateOrderRequestBody {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}

