package com.tk.adhaFileUpload.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class TriggerCADMail implements JavaDelegate{

		@Override
		public void execute(DelegateExecution execution) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("Email sent to CAD Checker !!");
			
		}

}
