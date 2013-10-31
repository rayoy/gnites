package test;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestActiviti extends TestBaseTemplate {

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Test
	public void dd() {
		// 部署流程定义
		repositoryService.createDeployment()
				.addClasspathResource("test.bpmn20.xml").deploy();
		// 启动流程实例
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("articlePublish");

		// ProcessInstance processInstance =
		// runtimeService.startProcessInstanceById("articlePublish");
		// List<Task> tasks = taskService.createTaskQuery()
		// .taskCandidateUser("admin").list();

		TaskQuery query = taskService.createTaskQuery()
				.processInstanceId(processInstance.getId()).orderByTaskName()
				.asc();

		List<Task> tasks = taskService.createTaskQuery().taskAssignee("kermit")
				.list();
		// List<Task> tasks = query.list();
		// taskService.createTaskQuery().
		List<Deployment> deploymentList = repositoryService
				.createDeploymentQuery().list();
		System.out.println(tasks.size() + "," + deploymentList.size() + ","
				+ processInstance.getId());

		for (Task task : tasks) {
			// 执行任务
			taskService.complete(task.getId());
			System.out.println("Task id :" + task.getId() + ",name :"
					+ task.getName());
		}

		tasks = taskService.createTaskQuery().taskAssignee("kermit").list();

		for (Task task : tasks) {
			// 执行任务
			taskService.complete(task.getId());
			System.out.println("Task id :" + task.getId() + ",name :"
					+ task.getName());
		}
	}

	public static void main(String[] args) {

		/**
		 * // 创建Activiti流程引擎 ProcessEngine pe = ProcessEngineConfiguration.
		 * createStandaloneProcessEngineConfiguration().buildProcessEngine();
		 * 
		 * // 获得Activiti的服务 RepositoryService repositoryService =
		 * pe.getRepositoryService(); RuntimeService runtimeService =
		 * pe.getRuntimeService(); // 部署流程定义
		 * repositoryService.createDeployment()
		 * .addClasspathResource("test.bpmn20.xml") .deploy(); // 启动流程实例
		 * runtimeService.startProcessInstanceByKey("financialReport");
		 */

	}

}
