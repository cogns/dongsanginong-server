package org.samtuap.inong.common.exceptionType;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum ProductExceptionType implements ExceptionType {
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 상품입니다."),
    FARM_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 id의 농장이 존재하지 않습니다."),
    NOTICE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 농장에 해당하는 공지사항이 존재하지 않습니다."),
    FIELD_NOT_FOUND(HttpStatus.NOT_FOUND, "필드를 업데이트 할 수 없습니다.");


    private final HttpStatus status;
    private final String message;

    @Override
    public HttpStatus httpStatus() {
        return status;
    }

    @Override
    public String message() {
        return message;
    }
}