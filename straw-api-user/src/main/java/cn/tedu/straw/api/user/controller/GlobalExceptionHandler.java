package cn.tedu.straw.api.user.controller;

import cn.tedu.straw.api.user.ex.*;
import cn.tedu.straw.commons.model.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public R exceptionHandler(Throwable throwable){
        if (throwable instanceof InviteCodeException){
            return R.makeErrR(R.State.ERR_INVITE_CODE,throwable);
        }else if (throwable instanceof PhoneDuplicateException){
            return R.makeErrR(R.State.ERR_PHONE_DUPLICATE,throwable);
        }else if (throwable instanceof InsertException){
            return R.makeErrR(R.State.ERR_INSERT,throwable);
        }else if (throwable instanceof IllegalParameterException){
            return R.makeErrR(R.State.ERR_ILLEGAL_PARAMETER,throwable);
        }else {
            return R.makeErrR(R.State.ERR_UNKNOWN,throwable);
        }

    }
}
