package com.softronix.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softronix.entity.Plan;
import com.softronix.service.PlanService;




@RestController
public class PlanRestController<PlanSevive> {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> planCategories()
	{
		Map<Integer,String> categories =planService.getPlanCategeory();
		return new ResponseEntity<>(categories,HttpStatus.OK);
		
	}
	@PostMapping("/plan")
	public ResponseEntity<String> SavePlan(@RequestBody Plan plan)
	{
		String responseMgs="";
		boolean isSave=planService.savePlan(plan);
		if (isSave)
		{
			responseMgs="Plan Saved";
		}else {
			responseMgs="Plan not Saved";
		}
		return new ResponseEntity<>(responseMgs,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans()
	{
		List<Plan> allPlans=planService.getAllPlan();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId)
	{
		Plan plan=planService.getPlanById(planId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan )
	{
		String mgs="";
		boolean isUpdate=planService.updatePlan(plan);
		if(isUpdate)
		{
			mgs="Plan Update";
		}else
		{
			mgs="Plan not Update";
		}
		
		return new ResponseEntity<>(mgs,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId)
	{
		String mgs="";
		boolean isDeleted=planService.deletePlanById(planId);
		if(isDeleted)
		{
			mgs="Plan Deleted";
		}else
		{
			mgs="Plan not Deleted";
		}
		
		return new ResponseEntity<>(mgs,HttpStatus.OK);
	}
	
	@PutMapping("status-change")
	public ResponseEntity<String> statusChange(Integer planId,String status)
	{
		String mgs="";
		boolean isStatusChanged=planService.PlanStatusChange(planId, status);
		if(isStatusChanged)
		{
			mgs="Plan Deleted";
		}else
		{
			mgs="Plan not Deleted";
		}
		return new ResponseEntity<>(mgs,HttpStatus.OK);
	}
	

}
