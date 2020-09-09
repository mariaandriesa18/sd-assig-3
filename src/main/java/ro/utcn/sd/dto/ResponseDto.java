package ro.utcn.sd.dto;

public class ResponseDto {

    private String message;
    private String optionPaneType;

    public ResponseDto(String message, String severity) {
        this.message = message;
        this.optionPaneType = severity;
    }

    public ResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getOptionPaneType() {
        return optionPaneType;
    }
}
