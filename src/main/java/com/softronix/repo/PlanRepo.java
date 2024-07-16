package com.softronix.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softronix.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
