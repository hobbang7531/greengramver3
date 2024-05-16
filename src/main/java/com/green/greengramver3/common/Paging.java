package com.green.greengramver3.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;

@Getter
@ToString
public class Paging {
    private int page;
    private int size;
    @JsonIgnore private int startIdx;

    @ConstructorProperties({"page", "size"})
    public Paging(Integer page, Integer size){
        this.page = page == null ? 1 : page;
        this.size = size == null ? 10 : size;
        this.startIdx = (this.page -1 ) * this.size;
    }
}