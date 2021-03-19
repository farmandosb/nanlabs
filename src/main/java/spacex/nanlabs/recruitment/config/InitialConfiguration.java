package spacex.nanlabs.recruitment.config;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spacex.nanlabs.recruitment.model.TrelloList;
import spacex.nanlabs.recruitment.service.TaskServiceImpl;

@Component
public class InitialConfiguration {

	@Autowired
	private TaskServiceImpl taskServiceImpl;

	private final String listName = "TO DO";

	private final Logger logger = LogManager.getLogger(InitialConfiguration.class);

	public static int counter;

	public TrelloList list = new TrelloList();

	public HashMap<String, String> labelIdMap = new HashMap<String, String>();
	
	public TrelloList getList() {
		return this.list;
	}

	public HashMap<String, String> getLabelIdMap() {
		return this.labelIdMap;
	}

	@PostConstruct
	public void init() {
		logger.info("Increment counter");
		counter++;

		this.list = taskServiceImpl.getListIfExistOrCreate(this.listName);
		this.labelIdMap = taskServiceImpl.getLabelMapIfExistOrCreate();

	}



}
