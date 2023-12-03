package in.sliya.cashledger.models.errors;

import lombok.Data;

@Data
public class ApiError {
    private int statusCode;
    private String errorName;
    private String errorDescription;

    public ApiError(int statusCode, String errorName, String errorDescription) {
        this.statusCode = statusCode;
        this.errorName = errorName;
        this.errorDescription = errorDescription;
    }
}
