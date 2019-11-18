package com.java.tao.cases;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //l1 = 321
        ListNode l1 = new ListNode(1);
        ListNode i1 = new ListNode(2);
        ListNode i2 = new ListNode(3);
        l1.next = i1;
        i1.next = i2;

        //l2 = 654
        ListNode l2 = new ListNode(4);
        ListNode j1 = new ListNode(5);
        ListNode j2 = new ListNode(6);
        l2.next = j1;
        j1.next = j2;

        Solution s = new Solution();
        ListNode listNode = s.addTwoNumbers(l1, l2);
        System.out.println(s.getNumber(listNode));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer i1 = getNumber(l1);
        Integer i2 = getNumber(l2);
        System.out.println(i1+" + "+i2);
        Integer sum = i1 + i2;
        System.out.println("sum="+sum);
        //结果node
        return getNode(sum);
    }

    public ListNode getNode(Integer num) {
        if (num == 0) {
            return new ListNode(0);
        }
        List<Integer> arr = new ArrayList<Integer>();
        while ((num/10)>0){
            arr.add(num%10);
            num = num/10;
        }
        arr.add(num);
        ListNode n = new ListNode(arr.get(0));
        ListNode f = n;
        for(int i=1; i<arr.size();i++){
            ListNode nr = new ListNode(arr.get(i));
            f.next = nr;
            f = f.next;
        }
        System.out.println(JSONObject.toJSONString(arr));
        return n;
    }

    public Integer getNumber(ListNode node){
        int r = 0;
        int base = 1;
        while (node != null) {
            int value = node.value;
            node = node.next;
            r += value * base;
            base = base * 10;
        }
        return r;
    }

}
