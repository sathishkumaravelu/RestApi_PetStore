package CowinPojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Center {
    private int center_id;
    private String name;
    private String address;
    private String state_name;
    private String district_name;
    private String block_name;
    private int pincode;
    private int lat;
    @JsonProperty("long")
    private int longitude;
    private String from;
    private String to;
    private String fee_type;

    @JsonProperty("sessions")
    private List<Sessions> Sessions;

    @JsonProperty("vaccine_fees")
    private List<VaccineFees> VaccineFees;
}
