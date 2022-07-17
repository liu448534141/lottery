package com.liu.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hollow
 */

public class LotteryUtil {

    public static int lottery(List<BigDecimal> originalRates) {
        if (originalRates == null || originalRates.isEmpty()) {
            throw new RuntimeException("数组异常中断");
        }
        int size = originalRates.size();
        // 计算总概率，这样可以保证不一定总概率是1
        BigDecimal totalRates = originalRates.stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        // 计算每个物品在总概率的基础下的概率情况
        List<BigDecimal> sortOriginalRates = new ArrayList<BigDecimal>(size);
        BigDecimal sumRate = BigDecimal.ZERO;
        for (BigDecimal rate : originalRates) {
            sumRate = sumRate.add(rate);
            sortOriginalRates.add(DecimalUtils.div(sumRate,totalRates,8));
        }
        // 根据区块值来获取抽取到的物品索引
        BigDecimal range = BigDecimal.valueOf(Math.random());
        sortOriginalRates.add(range);
        Collections.sort(sortOriginalRates);
        return sortOriginalRates.indexOf(range);
    }


}