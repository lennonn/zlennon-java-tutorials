package com.zlennon.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class IfElseStatement {
    static   Map<Integer, Strategy> stategys = new HashMap<Integer,Strategy>(){{
        put(1, new StrategyOne());
        put(2, new StrategySecond());
        put(3, new StrategyOther());
     }};
    public static void main(String[] args) {
        conditionMethod(2);
        swithMethod(4);
        stategyMethod(3);
        enumMethod("ONE");
    }
    public static void  conditionMethod(Integer type){
        if (type==1)
            statementOne(type);
        else if(type==2)
            statementSecond(type);
        else
            statementOther(type);
    }

    public static  void swithMethod(Integer type){
        switch (type){
            case 1 :statementOne(type); break;
            case 2: statementSecond(type);break;
            default:statementOther(type);break;
        }
    }

    public static  void stategyMethod(Integer type){
       Strategy strategy= stategys.get(type);
       strategy.apply(type);
    }

    public static  void enumMethod(String type){
        EnumType et=    EnumType.valueOf(type);
        et.statement();
    }

    public static  void optionalMethod(String type){
        Optional<String> types =Optional.ofNullable(type);
       // types.map("action1").orElse("action2");
    }


    private static void statementOther(Integer type) {
        System.out.println(type);
    }

    private  static void statementSecond(Integer type) {
        System.out.println(type);

    }

    private static void statementOne(Integer type) {
        System.out.println(type);

    }


}
