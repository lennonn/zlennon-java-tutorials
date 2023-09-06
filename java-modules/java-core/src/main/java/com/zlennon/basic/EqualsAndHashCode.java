package com.zlennon.basic;

public class EqualsAndHashCode {
    int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsAndHashCode that = (EqualsAndHashCode) o;
        return count == that.count;
    }


    public static void main(String[] args) {
        EqualsAndHashCode eahc = new EqualsAndHashCode();
        EqualsAndHashCode eahc1 = new EqualsAndHashCode();
        System.out.println(eahc.equals(eahc1));
        Object o = new Object();
        System.out.println(o.hashCode());
        System.out.println(eahc.hashCode()+" "+eahc1.hashCode());
    }
}
