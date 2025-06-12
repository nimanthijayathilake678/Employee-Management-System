package Employee.Management.System.Asgard.Security.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DutyPoint")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DutyPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dutyPoint_id;

    @Column(nullable = false,unique = true, length = 100)
    private String dutyPoint_name;

    private String phone;

    @Column(nullable = false,length = 100)
    private String dutyPoint_location;

    @Column(name = "dutyPoint_charges", nullable = false)
    private BigDecimal dutyPointCharges;

}
