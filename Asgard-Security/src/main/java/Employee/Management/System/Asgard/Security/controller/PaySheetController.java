package Employee.Management.System.Asgard.Security.controller;

import Employee.Management.System.Asgard.Security.entity.dto.PaysheetDTO;
import Employee.Management.System.Asgard.Security.service.PaySheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paysheets")
public class PaySheetController {

    private final PaySheetService paySheetService;

    public PaySheetController(PaySheetService paySheetService) {
        this.paySheetService = paySheetService;
    }

    // Create a new paysheet record
    @PostMapping
    public ResponseEntity<PaysheetDTO> createPaySheet(@RequestBody PaysheetDTO paysheetDTO) {
        PaysheetDTO createdPaySheet = paySheetService.createPaySheet(paysheetDTO);
        return ResponseEntity.ok(createdPaySheet);
    }

}
