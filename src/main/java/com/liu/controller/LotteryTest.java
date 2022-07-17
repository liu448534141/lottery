package com.liu.controller;

import com.liu.dto.GoodsProbabilityDTO;
import com.liu.util.LotteryUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author hollow
 * @date 2022/7/17 15:09:23
 */
public class LotteryTest {
    public static void main(String[] args) {
        ArrayList<GoodsProbabilityDTO> goodsList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            GoodsProbabilityDTO goodsProbabilityDTO = new GoodsProbabilityDTO();
            goodsProbabilityDTO.setName("商品" + i)
                    .setProbability(new BigDecimal(i + 1));
            goodsList.add(goodsProbabilityDTO);
        }
        List<BigDecimal> goodsProbabilityList = goodsList.stream().map(GoodsProbabilityDTO::getProbability).collect(Collectors.toList());
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            int lottery = LotteryUtil.lottery(goodsProbabilityList);
            GoodsProbabilityDTO goodsProbabilityDTO = goodsList.get(lottery);
            System.out.println("抽奖结果：" + goodsProbabilityDTO);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
