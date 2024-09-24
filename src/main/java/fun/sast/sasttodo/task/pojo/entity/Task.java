package fun.sast.sasttodo.task.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class Task {
    @ApiModelProperty(value = "任务id")
    private Long id;
    @ApiModelProperty(value = "用户id")
    private Long user_id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "状态")
    private int status;
    @ApiModelProperty(value = "截止日期")
    private Date due_date;
    @ApiModelProperty(value = "创建时间")
    private Date create_time;
    @ApiModelProperty(value = "最后更新时间")
    private Date last_update_time;
}
