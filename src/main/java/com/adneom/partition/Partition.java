package com.adneom.partition;

import java.util.List;

public class Partition {
    private List <Integer> listToPartition;
    private Integer sizeSubList;

    public Partition(List < Integer > listToPartition, Integer sizeSubList) {
        this.listToPartition = listToPartition;
        this.sizeSubList = sizeSubList;
    }

    public List < Integer > getListToPartition() {
        return listToPartition;
    }

    public Integer getSizeSubList() {
        return sizeSubList;
    }
}
