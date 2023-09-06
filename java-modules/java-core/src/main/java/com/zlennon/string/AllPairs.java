package com.zlennon.string;

import java.util.List;
import java.util.stream.Collectors;

public class AllPairs {
    public List<String[]> returnAllPairsList(List<String> first,List<String> second){
        return first.stream()
                .flatMap(i->second.stream()
                        .map(j->new String[]{i,j})
                )
                .collect(Collectors.toList());
    }

}
