package fun.sast.sasttodo.base.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult {
    /*
        1.内部状态码
        2.状态码描述
        3.具体数据
     */
    private Integer code;
    private String msg;
    private Object data;

    /**
     * 第1个构造方法：无参构造
     */

    /**
     * 第2个构造方法：全参构造
     * 应用场景：需要返回具体数据的功能
     */

    /**
     * 第3个构造方法：只有 状态码和描述;
     * 应用场景：用于不需要返回具体数据的功能
     */
    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 第4个构造方法：利用枚举类StatusCode;
     * 应用场景：应用于没有具体数据返回的功能
     */
    public JsonResult(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    /**
     * 第5个构造方法：StatusCode和具体数据data;
     * 应用场景：有具体数据返回的功能;
     */
    public JsonResult(StatusCode statusCode, Object data){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    /**
     * 第6个构造方法：用于静态方法中快速构建JsonResult对象
     * 应用场景：所有操作成功的功能
     */
    public JsonResult(Object data) {
        this.code = StatusCode.SUCCESS.getCode();
        this.msg = StatusCode.SUCCESS.getMsg();
        this.data = data;
    }

    /**
     * 定义2个静态方法,用于快速生成 JsonResult 对象
     */
    public static JsonResult ok(Object data){
        return new JsonResult(data);
    }

    public static JsonResult ok(){
        return ok(null);
    }
}