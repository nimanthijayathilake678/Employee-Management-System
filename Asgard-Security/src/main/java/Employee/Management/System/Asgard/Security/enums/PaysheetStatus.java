package Employee.Management.System.Asgard.Security.enums;

public enum PaysheetStatus {
    DRAFT,         // Paysheet is being prepared, not finalized
    GENERATED,     // Paysheet has been generated but not yet reviewed
    REVIEWED,      // Reviewed by a manager or HR
    APPROVED,      // Approved for payout
    REJECTED,      // Rejected due to errors or inconsistencies
    PAID,          // Payment has been processed
    CANCELLED       //Payment is cancelled
}
