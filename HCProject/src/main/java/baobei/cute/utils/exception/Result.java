package baobei.cute.utils.exception;

import baobei.cute.utils.constants.CodeMsg;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by tangminyan on 2020/3/26.
 */
@Data
public class Result<T> implements Serializable {
    private int code;
    private T data;
    private String msg;

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private Result() {
        this.code = 0;
        this.msg = "success";
        this.data = null;
    }

    private Result(CodeMsg codeMsg) {
        if (codeMsg == null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }


    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> success() {
        return new Result<T>();
    }
    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }
}
