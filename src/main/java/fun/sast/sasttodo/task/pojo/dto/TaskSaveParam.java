package fun.sast.sasttodo.task.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TaskSaveParam {
    @ApiModelProperty(value = "用户id")
    private Long user_id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "状态")
    private int status;
    @ApiModelProperty(value = "截止日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date due_date;
}
