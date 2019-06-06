package com.sairam.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sairam.project.modal.College;

public interface CollegeRepo extends JpaRepository<College,Long> {

}
