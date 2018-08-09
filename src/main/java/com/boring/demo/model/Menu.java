package com.boring.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document("test")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu {
    @Id
    private String id;

    @Field("menu_code")
    private String menuCode;

    @Field("menu_name")
    private String menuName;

    @Field("sub")
    private List<Menu> sub;

    @Field("button")
    private List<Menu> button;
}
