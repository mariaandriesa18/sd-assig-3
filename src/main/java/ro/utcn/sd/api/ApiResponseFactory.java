package ro.utcn.sd.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ro.utcn.sd.dto.ResponseDto;
/**Most used responses for positive flows:
 * HttpStatus.OK - 200
 * HttpStatus.CREATED - 201
 */
/** Most used responses for negative flows:
 * HttpStatus.BAD_REQUEST - 400
 * HttpStatus.NOT_ACCEPTED - 406
 * HttpStatus.CONFLICT - 409
 * HttpStatus.NOT_MODIFIED - 304
 */
public class ApiResponseFactory implements ApiResponse{

    public  ResponseEntity createSuccessMessage( String message ) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(message));
    }
    public  ResponseEntity createWarningMessage(Integer status, String message ){

        if(status == 201)
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseDto(message));

        if(status == 400)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(message));

        if(status == 406)
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseDto(message));

        if(status == 409)
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseDto(message));

        return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                .body(new ResponseDto(message));
    }

    public  ResponseEntity createWarningMessage(Integer status, String message, String severity) {

        if(status == 201)
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseDto(message, severity));

        if(status == 400)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(message, severity));

        if(status == 406)
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ResponseDto(message, severity));

        if(status == 409)
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseDto(message, severity));

        return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                .body(new ResponseDto(message, severity));

    }


}
