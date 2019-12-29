package com.java.tao.design.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> list = new ArrayList<Person>();
        for (Person p : persons){
            if(p.getGender().equalsIgnoreCase("SINGLE")){
                list.add(p);
            }
        }
        return list;
    }
}
