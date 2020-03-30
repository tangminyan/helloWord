package baobei.cute.utils.exception;

import baobei.cute.utils.constants.CodeMsg;

/**
 * Created by tangminyan on 2020/3/26.
 */
public class GlobalException extends RuntimeException {

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
