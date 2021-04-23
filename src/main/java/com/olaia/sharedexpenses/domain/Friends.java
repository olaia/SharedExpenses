package com.olaia.sharedexpenses.domain;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Friends {
    private Hashtable<String, Person> group = new Hashtable<>();

    public Person getPerson(String fullName){
        return group.get(fullName);
    }

    public void addFriend(Person person){
        if (!isFriend(person.getFullName()))
            group.put(person.getFullName(), person);
    }

    public List<Person> getList(){
        return new ArrayList<>(group.values());
    }

    public boolean isFriend(String fullName){
        return group.containsKey(fullName);
    }
}
