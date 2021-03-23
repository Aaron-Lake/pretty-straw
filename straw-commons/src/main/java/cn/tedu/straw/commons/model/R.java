package cn.tedu.straw.commons.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class R<E> implements Serializable {

    private Integer state;
    private String message;
    private E data;

    public R(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public R(Integer state, String message, E data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public static final R OK = new R(200,"ok!");

    public static R makeErrR(Integer state,Throwable throwable){
        return new R(state,throwable.getMessage());
    }
    public static <E>R ok(E data){

        return new R(State.OK,"OK!",data);
    }

    public interface State{
        public Integer OK =200;
        public Integer ERR_INVITE_CODE=4001;
        public Integer ERR_PHONE_DUPLICATE=4001;
        public Integer ERR_INSERT=4001;
        public Integer ERR_ILLEGAL_PARAMETER=4001;
        public Integer ERR_UNKNOWN=9999;
    }


}
