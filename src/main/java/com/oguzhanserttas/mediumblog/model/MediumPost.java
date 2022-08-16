package com.oguzhanserttas.mediumblog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MediumPost {
    private String title;
    private String contentFormat;
    private String content;
    private String publishStatus;
}
