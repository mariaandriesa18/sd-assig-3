package ro.utcn.sd.api;

import org.springframework.http.ResponseEntity;

public interface ApiResponse {
    ResponseEntity createSuccessMessage(String message);
    ResponseEntity createWarningMessage(Integer status, String message );
}
