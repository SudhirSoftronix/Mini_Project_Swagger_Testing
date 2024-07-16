package com.softronix.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softronix.entity.Plan;
import com.softronix.entity.PlanCategeory;
import com.softronix.repo.PlanCategeoryRepo;
import com.softronix.repo.PlanRepo;
@Service
public class ServicePlanImpl implements PlanService {

	@Autowired
	public PlanRepo planRepo;
	
	@Autowired
	public PlanCategeoryRepo planCategeoryRepo;
	
	
	@Override
	public Map<Integer, String> getPlanCategeory() {
		List<PlanCategeory> categories=planCategeoryRepo.findAll();
		
		Map<Integer, String> categoryMap=new HashMap<Integer, String>();
		
		categories.forEach(categeory ->{ 
			categoryMap.put(categeory.getCategeoryId(),categeory.getCategeoryName());
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		 Plan saved=planRepo.save(plan);
		 /* if(saved.getPlanId() !=null)
		 {
			 return true;
		 }
		 else {
			 return false;
		 }
		 */
		// return saved.getPlanId()!=null ? true :false;
		 
		 return saved.getPlanId() !=null;
		 
	}

	@Override
	public List<Plan> getAllPlan() {
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan save = planRepo.save(plan); //upsert a method
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer PlanId) {
		
		boolean status=false;
		try {
			planRepo.deleteById(PlanId);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean PlanStatusChange(Integer planId,String status) {
		Optional<Plan> findById=planRepo.findById(planId);
		if(findById.isPresent())
		{
			Plan plan=findById.get();
			plan.setActivesw(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}
	
}
