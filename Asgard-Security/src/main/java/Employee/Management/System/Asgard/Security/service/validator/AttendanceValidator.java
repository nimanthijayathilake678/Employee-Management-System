package Employee.Management.System.Asgard.Security.service.validator;
import Employee.Management.System.Asgard.Security.entity.dto.AttendanceDTO;
import Employee.Management.System.Asgard.Security.exception.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.math.BigDecimal;

@Component
public class AttendanceValidator {

    /** Maximum number of characters allowed in the remarks field */
    private static final int MAX_REMARKS_LENGTH = 255;

    /** Validate data required when a new attendance record is created. */
    public void validateForCreate(AttendanceDTO dto) {
        if (dto == null) {
            throw new BadRequestException("Attendance data is required");
        }

        // A new record should *not* carry an ID; it will be generated by the DB
        if (dto.getAttendance_id() != null) {
            throw new BadRequestException("Attendance ID must not be provided when creating a new record");
        }

        validateCommonFields(dto);
    }

    /** Validate when an existing attendance record is updated. */
    public void validateForUpdate(AttendanceDTO dto) {
        if (dto == null || dto.getAttendance_id() == null) {
            throw new BadRequestException("Attendance ID and data are required for update");
        }

        validateCommonFields(dto);
    }

    /** Shared validation logic between create and update paths. */
    private void validateCommonFields(AttendanceDTO dto) {

        /* — Mandatory references — */
        if (dto.getEmployee().getEmployee_id() == null) {
            throw new BadRequestException("Employee reference is required");
        }

        if (dto.getDutyPoint().getDutyPoint_id() == null) {
            throw new BadRequestException("Duty‑point reference is required");
        }

        /* — Mandatory simple fields — */
        if (dto.getDate() == null) {
            throw new BadRequestException("Attendance date is required");
        }

        if (dto.getShift() == null) {
            throw new BadRequestException("Shift type is required");
        }

        if (dto.getStatus() == null) {
            throw new BadRequestException("Attendance status is required");
        }

        /* — Optional numeric fields (must be non‑negative if present) — */
        if (dto.getBreakDuration() != null && dto.getBreakDuration() < 0) {
            throw new BadRequestException("Break duration cannot be negative");
        }

        if (dto.getOvertimeHours() != null &&
                dto.getOvertimeHours().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Overtime hours cannot be negative");
        }

        /* — Time consistency — */
        if (dto.getCheckInTime() != null && dto.getCheckOutTime() != null &&
                dto.getCheckInTime().isAfter(dto.getCheckOutTime())) {
            throw new BadRequestException("Check‑in time cannot be after check‑out time");
        }

        /* — Remarks length — */
        if (StringUtils.hasText(dto.getRemarks()) &&
                dto.getRemarks().length() > MAX_REMARKS_LENGTH) {
            throw new BadRequestException("Remarks cannot exceed " + MAX_REMARKS_LENGTH + " characters");
        }
    }
}
