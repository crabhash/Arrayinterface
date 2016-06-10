/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sms.dao.impl;

import com.leapfrog.sms.ai.dao.StudentDAO;
import com.leapfrog.sms.entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abhash
 */
public class StudentDAOimpl implements StudentDAO {

    ArrayList<Student> studentList = new ArrayList<>();

    @Override
    public int insert(Student s) {
        studentList.add(s);
        return 1;
    }

    @Override
    public int delete(int id) {

        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            if (s.getId() == id) {
                studentList.remove(i);
                for (int j = 0; j < studentList.size(); j++) {
                    studentList.get(j).setId(j + 1);
                }
            }
        }
        return 0;
    }

    @Override
    public Student getById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.get(i);
            }

        }
        return null;
    }

    @Override
    public ArrayList<Student> getAll() {
        return studentList;
    }

    @Override
    public int getid() {
        return (studentList.size() + 1);
    }

    @Override
    public void getbyany(String s) {
        int count  = 0;
        for (int i = 0; i < studentList.size(); i++) {
            Student se = studentList.get(i);
            if (se != null && ((se.getFirstName().equalsIgnoreCase(s)) || (se.getLastName().equalsIgnoreCase(s)) || (se.getEmail().equalsIgnoreCase(s)))) {
                System.out.println(studentList.get(i).getAll());
                count++;
            }
        }

        if(count == 0) System.out.println("No record match ");
    }
}
