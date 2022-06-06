package com.wbw.cloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页对象
 * @author wbw
 * @since 2022-6-6 19:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {

    private static final long serialVersionUID = -275582248840137389L;
    private int total;
    private List<T> data;
}
