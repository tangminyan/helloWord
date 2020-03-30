package baobei.cute.utils.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by tangminyan on 2020/3/26.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CodeMsg implements Serializable {
    private int code;
    private String msg;

    public static CodeMsg SUCCESS = new CodeMsg(200, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务器错误");
    public static CodeMsg INSERT_ERROR = new CodeMsg(500200, "插入错误");
    public static CodeMsg UNKNOWN_ERROR = new CodeMsg(-999, "未知错误:%s");
    //填充多个错误信息
    public static CodeMsg BIND_ERROR = new CodeMsg(500300,"参数校验异常：%s");
    public static CodeMsg UNSELECT_FILE_ERROR = new CodeMsg(500400,"未选择文件");
    public static CodeMsg FILE_NOT_EXIST_ERROR = new CodeMsg(500500, "文件或文件夹不存在");
    public static CodeMsg UPLOADING = new CodeMsg(500600, "正在上传");

    //补充未知错误的具体信息
    public CodeMsg fillArgs(Object... args){
        int code =  this.code;
        String message = String.format(this.msg,args);
        return new CodeMsg(code,message);
    }

    //处理异常时返回json的toString
    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

}
