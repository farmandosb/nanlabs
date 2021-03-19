package spacex.nanlabs.recruitment.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import spacex.nanlabs.recruitment.model.BugTask;
import spacex.nanlabs.recruitment.model.CommonTask;
import spacex.nanlabs.recruitment.model.GetTaskFactory;
import spacex.nanlabs.recruitment.model.IssueTask;
import spacex.nanlabs.recruitment.model.Tasktype;
import spacex.nanlabs.recruitment.model.TrelloList;
import spacex.nanlabs.recruitment.service.TaskServiceImpl;

@RestController
public class TaskController {

	ObjectMapper mapper = new ObjectMapper();

	private final Logger logger = LogManager.getLogger(TaskController.class);
	
	private final String listName = "TO DO";
	
	
	@Autowired
	private TaskServiceImpl taskServiceImpl;

	@Autowired
	private GetTaskFactory taskFactory;
	
	
	private TrelloList list = new TrelloList();
	
	private HashMap<String, String> labelIdMap  = new HashMap<String, String>(); 
	
	@PostMapping("/")
	public ResponseEntity<String> createCard(@RequestBody Map<String, String> body) {
	
		
		list = taskServiceImpl.getExistingList(listName);
		labelIdMap = taskServiceImpl.getExistingLabelMap();
		
		switch (body.get("type")) {
		case "issue":
			IssueTask issueTask = (IssueTask) taskFactory.getManagedtask(body.get("type"));
			issueTask.setType(Tasktype.ISSUE);
			issueTask.setDesc(body.get("description"));
			issueTask.setName(body.get("title"));
			issueTask.setIdList(list.getId());
			issueTask.setIdMembers(new String[]{""});
			taskServiceImpl.createCard(issueTask.getIdList(), issueTask.getName(), issueTask.getDesc(), issueTask.getIdMembers(), issueTask.getIdLabels());
			logger.info(issueTask);
			break;
		case "bug":
			BugTask bugTask = (BugTask) taskFactory.getManagedtask(body.get("type"));
			bugTask.setType(Tasktype.BUG);
			bugTask.setDesc(body.get("description"));
			bugTask.setName("");
			bugTask.setIdList(list.getId());
			bugTask.setIdLabels(new String[] {this.labelIdMap.get("Bug")});
			String[] arrMembers = {taskServiceImpl.getMembers()[(getRandomNumber(0,taskServiceImpl.getMembers().length))].getId()};
			bugTask.setIdMembers(arrMembers);
			taskServiceImpl.createCard(bugTask.getIdList(), bugTask.getName(), bugTask.getDesc(), bugTask.getIdMembers(), bugTask.getIdLabels());
			logger.info(bugTask);
			break;
		case "task":
			CommonTask commonTask = (CommonTask) taskFactory.getManagedtask(body.get("type"));
			commonTask.setType(Tasktype.TASK);
			commonTask.setDesc(body.get("description"));
			commonTask.setName(body.get("title"));
			commonTask.setIdList(list.getId());
			commonTask.setIdMembers(new String[]{""});
			
			switch (body.get("category")) {
			case "Maintenance":
				commonTask.setIdLabels(new String[] {labelIdMap.get("Maintenance")});
				break;
			case "Research":
				commonTask.setIdLabels(new String[] {labelIdMap.get("Research")});
				break;
			case "Test":
				commonTask.setIdLabels(new String[] {labelIdMap.get("Test")});
				break;
			}
			taskServiceImpl.createCard(commonTask.getIdList(), commonTask.getName(), commonTask.getDesc(), commonTask.getIdMembers(), commonTask.getIdLabels());
			logger.info(commonTask);
			break;
		}
		
		return ResponseEntity.ok("Task has been created successfully");

	}


	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	
	


}
