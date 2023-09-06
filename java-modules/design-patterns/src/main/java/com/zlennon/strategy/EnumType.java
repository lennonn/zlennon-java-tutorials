package com.zlennon.strategy;

public enum EnumType {

    ONE(1){
        @Override
        void statement() {
            System.out.println(type);
        }
    },
    SECONDE(2){
        @Override
        void statement() {
            System.out.println(type);
        }
    },
    OHTER(4){
        @Override
        void statement() {
            System.out.println(type);
        }
    };


    public int type;

    abstract  void statement();

    EnumType (int type){
        this.type =type;
    }
}
