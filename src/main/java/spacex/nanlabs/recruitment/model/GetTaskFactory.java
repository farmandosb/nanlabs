package spacex.nanlabs.recruitment.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class GetTaskFactory {
	private final Logger logger = LogManager.getLogger(GetTaskFactory.class);

	public ManagedTask getManagedtask(String taskType) {
		logger.info("Type: " + taskType);
		if (taskType == null) {
			return null;
		}
		if (taskType.equalsIgnoreCase("ISSUE")) {
			return new IssueTask();
		} else if (taskType.equalsIgnoreCase("BUG")) {
			return new BugTask();
		} else if (taskType.equalsIgnoreCase("TASK")) {
			return new CommonTask();
		}
		return null;
	}

}