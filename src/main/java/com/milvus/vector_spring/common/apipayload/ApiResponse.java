package com.milvus.vector_spring.common.apipayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.milvus.vector_spring.common.apipayload.status.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"statusCode", "message", "data"})
public class ApiResponse<T> implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String statusCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(null, null, data);
    }

    public static ApiResponse<String> fail(BaseCode errorCode) {
        return new ApiResponse<>(errorCode.getReasonHttpStatus().getStatusCode(), errorCode.getReasonHttpStatus().getMessage(), null);
    }
}