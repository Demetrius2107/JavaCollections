package org.hua.Practice;

import org.hua.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListToMapNPE {
    public static void main(String[] args) {
        List<Person> booklist = new ArrayList<>();
        booklist.add(new Person("jack","1820334646"));
     //   booklist.add(new Person("martin",null));
        booklist.add(new Person("martin","111"));
        System.out.println(booklist.stream().collect(Collectors.toMap(Person::getName,Person::getPhoneNumber)));
    }
}
