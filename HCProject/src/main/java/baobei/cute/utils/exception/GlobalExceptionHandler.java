package baobei.cute.utils.exception;

import baobei.cute.utils.constants.CodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangminyan on 2020/3/26.
 */
@ControllerAdvice //指定全局异常
@RestController
@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = GlobalException.class)
//    public Result<String> globalExceptionHandler(GlobalException e) {
//        log.error(e.getCodeMsg().getMsg());
//        return Result.error(e.getCodeMsg());
//    }

    @ExceptionHandler(value = ArithmeticException.class)
    public Result<String> arithmeticExceptionHandler(ArithmeticException e) {
        log.error(e.getClass().toString());
        return Result.error(CodeMsg.UNKNOWN_ERROR.fillArgs(e.getClass().toString()));
    }

    @ExceptionHandler(value = Exception.class)
    public Result<String> notValidExceptionHandler(RuntimeException e) {
        log.error(e.getMessage(), e);
        return Result.error(CodeMsg.UNKNOWN_ERROR.fillArgs(e.getClass().toString()));
    }
}
