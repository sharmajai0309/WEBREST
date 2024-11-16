package com.Backend.jai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.jai.Model.Student;

public interface IStudentRepo extends JpaRepository<Student,Integer> {

}
