package main;

import actionBase.SearchInforStudent;
import base.Student;
import base.Subject;

import java.util.List;

public class app_main {
    public static void main(String[] args) {
        SearchInforStudent n = new SearchInforStudent();
        List<String> a;
        a = n.searchListStudent("20183856", "");
        for (int i = 0; i < a.size(); i++){
            System.out.print(a.get(i));
        }
    }
}

