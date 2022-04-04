package com.tk.adhaFileUpload.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.rest.dto.VariableValueDto;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceWithVariablesDto;
import org.camunda.bpm.engine.rest.dto.runtime.StartProcessInstanceDto;
import org.camunda.bpm.engine.rest.dto.task.CompleteTaskDto;
import org.camunda.bpm.engine.rest.dto.task.TaskDto;
import org.camunda.bpm.engine.rest.dto.task.UserIdDto;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tk.adhaFileUpload.ProcessConstants;
import com.tk.adhaFileUpload.model.MemberList;
import com.tk.adhaFileUpload.model.Members;
import com.tk.adhaFileUpload.model.TaskDetails;
import com.tk.adhaFileUpload.service.CamundaStartService;

@RestController
@CrossOrigin
public class AdhaController {
	
	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	CamundaStartService camundaStartService;

	/* Logger */
	private final Logger LOGGER = Logger.getLogger(AdhaController.class.getName());
	
	
	@GetMapping("/member-details")
	public String getDetails() {
		return "This is getDetails() method";
	}
	
	
	/* Multiple Users Task */
	@PostMapping("/init/adha-file")
	public ResponseEntity<HttpStatus> cadResponseChecker(@RequestBody MemberList members) {
		
		//boolean cadCheckerApprove = true;
		
//		Iterator<Members> it = members.iterator();
//		
//		while(it.hasNext()) {
		
		for(Members m : members) {
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		Map<String,Object> processVariable = new HashMap<>();
		processVariable.put("memberList",m);
		
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProcessConstants.PROCESS_DEFINITION_KEY2,processVariable);
		
		System.out.println(m);
		
		}
//		}
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	
//	@PostMapping("/member-details")
//	public ResponseEntity<HttpStatus> startTheProcess(@RequestBody MemberList members){
//		
//		LOGGER.info("EmployeeController: startProcess called");
//		
//		// to start a BPMN Process, get access of ProcessEngine (bcoz it will provide you the Runtime service)
//		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//		
//		// get the RuntimeService
//		RuntimeService runtimeService = processEngine.getRuntimeService();
//		
//		
//		// to send some process data 
//		Map<String,Object> processVariable = new HashMap<>();
//	
//
//		processVariable.put("memberList",members);
//		
//		ProcessInstance pi = runtimeService.startProcessInstanceByKey(ProcessConstants.PROCESS_DEFINITION_KEY,processVariable);
//		
//		/*
//		 * if(members.isWantLoan()=="yes") { LOGGER.info("Loan Approval Sent"); } else {
//		 * LOGGER.info("Loan Approval Not Sent to CAD"); }
//		 */
//		
//		
//		// Spin
//		//camundaStartService.startProcessByMessage2(members);
//		
//		//LOGGER.info("Process instance id is: "+pi.getId());
//		return ResponseEntity.ok(HttpStatus.OK);		
//	}
	
	
	
//	// Start the process with RestTemplate
//	@PostMapping("/member-details")
//	public ProcessInstanceWithVariablesDto placeOrderDuplicate(@RequestBody Members members) {
//		StartProcessInstanceDto startProcessInstanceDto = new StartProcessInstanceDto();
//		startProcessInstanceDto.setBusinessKey(UUID.randomUUID().toString());
//		startProcessInstanceDto.setWithVariablesInReturn(Boolean.TRUE);
//		
//		VariableValueDto variable = new VariableValueDto();
//		variable.setType("Integer");
//		variable.setValue(members.getMemberId());
//		
//		VariableValueDto variable1 = new VariableValueDto();
//		variable1.setType("String");
//		variable1.setValue(members.getMemberName());
//		
////		VariableValueDto variable2 = new VariableValueDto();
////		variable1.setType("String");
////		variable1.setValue(members.isWantLoan());
//		
//		HashMap<String, VariableValueDto> variables = new HashMap<>();
//		variables.put("memberId", variable);
//		variables.put("memberName", variable1);
//		//variables.put("isWantLoan", variable2);
//		startProcessInstanceDto.setVariables(variables);
//
//		ResponseEntity<ProcessInstanceWithVariablesDto> responseEntity = this.restTemplate.exchange(
//				"http://localhost:8080/engine-rest/process-definition/key/adha-File-Upload/start", HttpMethod.POST,
//				new HttpEntity<>(startProcessInstanceDto), ProcessInstanceWithVariablesDto.class);
//		if (!responseEntity.hasBody()) {
//			throw new RuntimeException("failed.initialize.instance");
//		} else {
//			return responseEntity.getBody();
//		}
//
//	}
	
	
//	/* Get Task details */
//	@GetMapping("/orders/task/{id}")
//	public TaskDetails getTaskDetails(@PathVariable String id) {
//
//		ResponseEntity<TaskDto[]> responseEntity = this.restTemplate.exchange(
//				"http://localhost:8080/engine-rest/task?processInstanceId=" + id, HttpMethod.GET, null,
//				TaskDto[].class);
//		if (!responseEntity.hasBody()) {
//			throw new RuntimeException("Failed get Task");
//		} else {
////			return responseEntity.getBody();
//			List<TaskDto> taskList = Arrays.asList(responseEntity.getBody());
//			taskList.get(0).getId();
//			return new TaskDetails(taskList.get(0).getAssignee(), taskList.get(0).getId(),
//					processEngine.getFormService().getTaskFormData(taskList.get(0).getId()).getFormFields());
//		}
//
//	}
	
	
//	/* Claim Task */
//	@GetMapping("/members/task/{id}/claim/{userId}")
//	public String claimTask(@PathVariable String id, @PathVariable String userId) {
//		UserIdDto body = new UserIdDto();
//		body.setUserId(userId);
//		HttpEntity<UserIdDto> requestEntity = new HttpEntity<UserIdDto>(body);
//
//		ResponseEntity<Void> responseEntity = this.restTemplate.exchange(
//				"http://localhost:8080/engine-rest/task/" + id + "/claim", HttpMethod.POST, requestEntity, Void.class);
//		
//		if (responseEntity.getStatusCode() != HttpStatus.NO_CONTENT) {
//			throw new RuntimeException("Failed Claiming of Task");
//		} else {
//			return "Success";
//		}
//	}
//	
	
//	/* Complete Task */
//	@PostMapping("/orders/task/{id}/complete")
//	public String completeTask(@PathVariable String id, @RequestBody Map<String, Object> request) {
//		Map<String, VariableValueDto> variableMap = new HashMap<>();
//		request.forEach((key, value) -> {
//			VariableValueDto variable = new VariableValueDto();
//			variable.setValue(value);
//			variableMap.put(key, variable);
//		});
//		
//		CompleteTaskDto input = new CompleteTaskDto();
//		input.setVariables(variableMap);
//		HttpEntity<CompleteTaskDto> requestEntity = new HttpEntity<>(input);
//
//		ResponseEntity<Void> responseEntity = this.restTemplate.exchange(
//				"http://localhost:8080/engine-rest/task/" + id + "/complete", HttpMethod.POST, requestEntity,
//				Void.class);
//		
//		if (responseEntity.getStatusCode() != HttpStatus.NO_CONTENT) {
//			throw new RuntimeException("Failed Completion of Task");
//		} else {
//			return "Success";
//		}
//	}
}
