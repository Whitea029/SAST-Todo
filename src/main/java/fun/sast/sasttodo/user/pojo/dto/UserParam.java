package fun.sast.sasttodo.user.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserParam {
    @ApiModelProperty(value = "学生id")
    private String student_id;
    @ApiModelProperty(value = "密码")
    private String password;
}
