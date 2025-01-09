package com.nipun.Spring.Security.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseBean {

    private String responseMasg;
    private String responseCode;
    private Object responseData;

}
