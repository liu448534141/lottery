package com.liu.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author hollow
 * @date 2022/7/17 15:22:47
 * 概率实现类
 */
@Accessors(chain = true)
@Data
public class GoodsProbabilityDTO {
    /**名称*/
    private String name;
    /**概率*/
    private BigDecimal probability;

}
