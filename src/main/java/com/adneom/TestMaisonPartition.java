package com.adneom;

import com.adneom.partition.Partition;
import com.adneom.partition.PartitionService;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TestMaisonPartition {
    public static void main(String[] args) {
        List <Integer> numbers = new ArrayList < Integer >(
                Arrays.asList(1,2,3,4,5)
        );
        int partitionSize = 1;

        Partition partition =new Partition(numbers,partitionSize);

        System.out.println(new PartitionService().listPartitionOfSublist(partition));
    }
}
