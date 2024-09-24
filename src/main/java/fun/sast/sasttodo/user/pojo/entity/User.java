package fun.sast.sasttodo.user.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
    @ApiModelProperty(value = "用户id")
    private Long id;
    @ApiModelProperty(value = "学生id")
    private String student_id;
    @ApiModelProperty(value = "密码")
    private String password;
}
