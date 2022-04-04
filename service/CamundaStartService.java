package com.tk.adhaFileUpload.service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tk.adhaFileUpload.model.Members;

@Service
public class CamundaStartService {
	
	@Autowired
	RuntimeService runtimeService;
	
	public void startProcessByMessage(Members members) {
		runtimeService.createMessageCorrelation("msg-1")
		.setVariable("memberId", members.getMemberId())
		.setVariable("memberName", members.getMemberName())
		.correlate();
	}
	
	public void startProcessByMessage2(Members members) throws Exception{
		int id = members.getMemberId();
		String name = members.getMemberName();
		
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(members);
		
		ObjectValue typedMemberValue = Variables.objectValue(members).serializationDataFormat("application/json").create();
		
		runtimeService.createMessageCorrelation("msg-2")
		.setVariable("id", id)
		.setVariable("customSerialized", typedMemberValue)
		.setVariable("customJson", json)
		.correlate();
	}

}
