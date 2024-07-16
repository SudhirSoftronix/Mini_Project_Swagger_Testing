package com.softronix.service;

import java.util.List;
import java.util.Map;

import com.softronix.entity.Plan;

public interface PlanService {
	
	public Map<Integer,String> getPlanCategeory();
	
	public boolean savePlan(Plan plan);
	
	public List<Plan> getAllPlan();
	
	public Plan getPlanById(Integer PlanId);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanById(Integer PlanId);
	
	public boolean PlanStatusChange(Integer planId,String status);

}
