package jorgecasariego.marvelspanish.character.search;

/**
 * Created by jorgecasariego on 6/3/17.
 */

public class ApiResponseCodeException extends Exception {

    private int code;
    private String status;

    public ApiResponseCodeException(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
