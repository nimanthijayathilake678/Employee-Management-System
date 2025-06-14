package Employee.Management.System.Asgard.Security.service.mapper;

import Employee.Management.System.Asgard.Security.entity.Paysheet;
import Employee.Management.System.Asgard.Security.entity.dto.PaysheetDTO;

public class PaySheetMapper {
    public Paysheet toEntity(PaysheetDTO paysheetDTO){
        //map the feilds to the entity
        if (paysheetDTO ==null){
            return null;
        }
        return Paysheet.builder()
                .paySheet_id(paysheetDTO)
    }
}
