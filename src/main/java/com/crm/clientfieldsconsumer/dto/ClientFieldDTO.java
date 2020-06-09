package com.crm.clientfieldsconsumer.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientFieldDTO {

    private String idField;
    private String name;
    private Boolean required;
    private Long length;
    private String maskRegex;
    private String placeholder;
    private Integer position;

}