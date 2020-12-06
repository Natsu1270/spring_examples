package org.example;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class BizLogic {

    public Integer addTwoValue(Integer n1, Integer n2) throws LogicException{
        if (n1 == 0) {
            throw new LogicException("Value 1 cannot equal zero!");
        }
        return n1 + n2;
    }

    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Oh it's delay I guess a heavy traffic today =)";
    }

    public String getFortune(boolean isBlock) {
        if (isBlock) {
            throw new RuntimeException("Major problem baby");
        }
        return getFortune();
    }

}
