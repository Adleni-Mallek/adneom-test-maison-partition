package com.adneom.partition;

import java.util.List;
import java.util.ArrayList;

public class PartitionService {
    public List< List <Integer> > listPartitionOfSublist(Partition partition){
        List<List<Integer>> partitions = new ArrayList <List< Integer>>();
        try {
            //list of partition is null or empty
            if(partition.getListToPartition()==null ||partition.getListToPartition().isEmpty() ){
                return partitions;
            }

            // size of subList is zero or negative
            if(partition.getSizeSubList()<=0){
                partitions.add( partition.getListToPartition());
                return partitions;
            }

            for (int i=0; i<partition.getListToPartition().size(); i += partition.getSizeSubList()) {
                partitions.add(
                        partition.getListToPartition()
                                .subList(i, Math.min(i + partition.getSizeSubList(), partition.getListToPartition().size())));
            }
            return partitions;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList <List< Integer>>();
    }
}
