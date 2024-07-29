package Enum;

/**
 * @Create 06/27/2024 - 22:25
 * @Author xiao
 * @Description TODO
 */

public enum ResultCode {  // implements interface
//    SUCCESS,
//    FAILED,
//    VALIDATE_FAILED,
//    UNAUTHORIZED
    SUCCESS(200, "Success"),
    FAILED(500, "Failed"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    LOVEDAY(520, "Love Day Message");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;

    }
    public long getValue() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
