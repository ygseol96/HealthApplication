package com.ygseol.helath.healthapplication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Log4j2
public class ResultData<T> { //성공, 실패처리 결과값 Return 인터페이스

    public T body; //어떠한 형태의 응답깂도 받을 수 있게. 제네릭 파라미터로 선언.

    String message;
    String code;
    StackTraceElement[] stackTrace;
    //성공처리 결과값 body에 담아서 보내기
    public final void setSuc(T body){
        this.body = body;
        this.message = "SUCCESS";
        this.code = "SUC0000";
        log.info("Caller is : " + getStackTrace());
    }

    //실패처리 추후 Exception으로 처리할지 예정
    public final void setErr(T body){
        this.body = body;
        this.message = "fail";
        this.code = "ERR0000";
        log.info("Caller is : " + getStackTrace());
    }
}
