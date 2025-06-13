package Employee.Management.System.Asgard.Security.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DutyPointDTO {
    private Long dutyPoint_id;
    private String dutyPoint_name;
    private String phone;
    private String dutyPoint_location;
    private BigDecimal dutyPointCharges;
}
