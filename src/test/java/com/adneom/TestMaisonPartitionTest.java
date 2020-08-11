package com.adneom;

import com.adneom.partition.Partition;
import com.adneom.partition.PartitionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMaisonPartitionTest {
    private List <Integer> listToTest;

    @Before
    public void init() {
        listToTest = new ArrayList <Integer>();
        for (int i = 1; i <= 5; i++) {
            listToTest.add(new Integer(i));
        }
    }

    @Test
    public void givenList_whenParitioningIsNull_thenCorrect(){

        List<List<Integer>> expected = new ArrayList <List< Integer>>();
        Integer partitionSize=2;
        Partition partition=new Partition(null, partitionSize);
        Assert.assertEquals(expected,new PartitionService().listPartitionOfSublist(partition));
    }

    @Test
    public void givenList_whenParitioningIsEmpty_thenCorrect(){

        List<List<Integer>> expected = new ArrayList <List< Integer>>();
        Integer partitionSize=2;
        Partition partition=new Partition(new ArrayList < Integer >(), partitionSize);
        Assert.assertEquals(expected,new PartitionService().listPartitionOfSublist(partition));
    }

    @Test
    public void givenList_whenSublistsOfZeroOrNegative_thenCorrect(){

        List<List<Integer>> expected = new ArrayList <List< Integer>>();
        Integer partitionSizeZero=0;
        Integer partitionSizeNegative=-1;
        expected.add( listToTest);

        Partition partitionOfSizeZero=new Partition(listToTest, partitionSizeZero);
        Partition partitionOfSizeNegative=new Partition(listToTest, partitionSizeNegative);
        Assert.assertEquals(expected,new PartitionService().listPartitionOfSublist(partitionOfSizeZero));
        Assert.assertEquals(expected,new PartitionService().listPartitionOfSublist(partitionOfSizeNegative));
    }


    // case correct: partition([1,2,3,4,5], 2) retourne: [ [1,2], [3,4], [5] ]
    @Test
    public void givenList_whenParitioningOf_2_Sublists_thenCorrect(){

        ArrayList<ArrayList<Integer>> expected = new ArrayList < ArrayList < Integer > >();
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)1,(Integer)2)));
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)3,(Integer)4)));
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)5)));

        Integer partitionSize=2;

        Partition partition=new Partition(listToTest, partitionSize);
        Assert.assertEquals(expected,new PartitionService().listPartitionOfSublist(partition));
    }

    // case incorrect: partition([1,2,3,4,5], 2) retourne: [ [1,2], [3,4,5] ]
    @Test
    public void givenList_whenParitioningOf_2_Sublists_thenIncorrect(){

        ArrayList<ArrayList<Integer>> expected = new ArrayList < ArrayList < Integer > >();
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)1,(Integer)2)));
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)3,(Integer)4,(Integer)5)));

        Integer partitionSize=2;

        Partition partition=new Partition(listToTest, partitionSize);
        Assert.assertNotEquals(expected,new PartitionService().listPartitionOfSublist(partition));
    }

    // case correct: partition([1,2,3,4,5], 3) return: [ [1,2,3], [4,5] ]
    @Test
    public void givenList_whenParitioningOf_3_Sublists_thenCorrect(){

        ArrayList<ArrayList<Integer>> expected = new ArrayList < ArrayList < Integer > >();
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)1,(Integer)2,(Integer)3)));
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)4,(Integer)5)));

        Integer partitionSize=3;

        Partition partition=new Partition(listToTest, partitionSize);
        Assert.assertEquals(expected,new PartitionService().listPartitionOfSublist(partition));
    }

    // case correct: partition([1,2,3,4,5], 1) return: [ [1], [2], [3], [4], [5] ]
    @Test
    public void givenList_whenParitioningOf_1_Sublists_thenCorrect(){

        ArrayList<ArrayList<Integer>> expected = new ArrayList < ArrayList < Integer > >();
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)1)));
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)2)));
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)3)));
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)4)));
        expected.add(new ArrayList<Integer>(Arrays.asList((Integer)5)));

        Integer partitionSize=1;

        Partition partition=new Partition(listToTest, partitionSize);
        Assert.assertEquals(expected,new PartitionService().listPartitionOfSublist(partition));
    }
}
