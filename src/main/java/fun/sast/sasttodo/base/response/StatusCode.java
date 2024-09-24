package fun.sast.sasttodo.base.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusCode {
    SUCCESS(2000, "OK"),
    LOGIN_SUCCESS(2001, "登录成功"),
    OPERATION_SUCCESS(2002, "操作成功"),


    NOT_LOGIN(4000, "未登录"),
    PASSWORD_ERROR(4002, "用户名或密码错误"),
    STUDENT_ID_ERROR(4003, "用户名或密码错误"),

    OPERATION_FAILED(5001, "操作失败"),
    VALIDATE_ERROR(5002, "请求参数错误"),
    USERNAME_ALREADY_EXISTS(5003, "用户名被占用"),
    DATA_UNEXISTS(5004, "请求数据不存在");

    //状态码、状态码描述
    private Integer code;
    private String msg;
}