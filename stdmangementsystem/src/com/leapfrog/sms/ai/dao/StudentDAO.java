/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sms.ai.dao;

import com.leapfrog.sms.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author Abhash
 */
public interface StudentDAO {
    int insert(Student s);
    int delete(int id);
    Student getById(int id);
    ArrayList<Student> getAll();
    void getbyany(String s);
    int getid();
    
}
