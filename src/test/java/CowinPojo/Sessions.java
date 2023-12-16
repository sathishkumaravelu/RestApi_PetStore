package CowinPojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sessions {
    @JsonProperty("session_id")
    private String sessionId;
    private String date;
    private int available_capacity;
    private int min_age_limit;
    private Integer max_age_limit;
    private boolean allow_all_age;
    private String vaccine;

    @JsonProperty("slots")
    private List<Slots> Slots;

    private int available_capacity_dose1;
    private int available_capacity_dose2;

}
