package com.gnites.modules;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gnites.modules.person.model.Person;
import com.sylvan41.action.BaseAction;
import com.sylvan41.utils.AjaxPrinter;

/**
 * 工作流Actions
 * 
 * @author Sylvan__
 * 
 */
@Controller
@Scope(value = "prototype")
public class WorkflowAction extends BaseAction {

	private static final long serialVersionUID = 2915318787165876397L;

	@Resource
	private TaskService taskService;
	@Resource
	private RepositoryService repositoryService;
	@Resource
	private RuntimeService runtimeService;
	@Resource
	private HistoryService historyService;

	private String taskId;
	private String taskRole; // 我在任务中的角色
	private List<Task> tasks = new ArrayList<Task>();

	public String list() {

		Person user = (Person) session.get("user");
		String name = user.getNicName();
		TaskQuery tq = taskService.createTaskQuery();
		
		if("owner".equals(getTaskRole())){
			tq = tq.taskOwner(user.getId());
		}else if("assignee".equals(getTaskRole())){
			tq = tq.taskAssignee(name);
		}else if("candidate".equals(getTaskRole())){
			tq = tq.taskCandidateUser(name);
		}else{
			System.out.println("no task role.!");
		}
		setTasks(tq.list());

		for (Task t : tasks) {
			t.getAssignee();
			t.getProcessDefinitionId();
			t.getCreateTime();
			t.getId();
			t.getPriority();
			t.getOwner();
			System.out.println(t.getOwner()+","+tasks.size());
		}
		

		// List<Task> tasks =
		// taskService.createTaskQuery().taskAssignee(user.getNicName())
		// .list();

		// 定义流程查询
		ProcessDefinitionQuery pdq = repositoryService.createProcessDefinitionQuery();
		List<ProcessDefinition> pdList = pdq.orderByProcessDefinitionId().asc().list();
		for(ProcessDefinition pd :pdList){
			System.out.println("\n===================== 已经定义的流程  ===========================");
			System.out.print("流程定义文件:"+pd.getResourceName());
			System.out.print("流程Category:"+pd.getCategory());
			System.out.print("流程定义Diagram:"+pd.getDiagramResourceName());
		}
		
		
		// 处理中的流程实例查询
		List<ProcessInstance> piList = runtimeService.createProcessInstanceQuery().list();
		for(ProcessInstance pi :piList){
			System.out.println("\n===================== 正在处理中的流程  ===========================");
			System.out.print(pi.getActivityId());
			System.out.print(pi.getParentId());
			System.out.print(pi.getBusinessKey());
			System.out.print("流程参数:"+pi.getProcessVariables());
		}
		
		// 处理完成的流程查询实例
		HistoricProcessInstanceQuery hpiq = historyService.createHistoricProcessInstanceQuery();
		List<HistoricProcessInstance> hpiList = hpiq.finished().orderByProcessInstanceStartTime().asc().list();
		for(HistoricProcessInstance hpi :hpiList){
			System.out.println("\n===================== 处理完成的流程  ===========================");
			System.out.print("StartUser:"+hpi.getStartUserId()+hpi.getStartActivityId()+hpi.getDurationInMillis());
			System.out.print("开始时间:"+hpi.getStartTime()+"结束时间:"+hpi.getEndTime());
		}
		return SUCCESS;
	}

	/**
	 * 完成一个任务
	 */
	public String complete() {

		try {
			taskService.complete(getTaskId());
			AjaxPrinter.print("审批完成.!", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskRole() {
		return taskRole;
	}

	public void setTaskRole(String taskRole) {
		this.taskRole = taskRole;
	}

}
