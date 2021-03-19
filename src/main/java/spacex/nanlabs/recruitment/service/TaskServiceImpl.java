package spacex.nanlabs.recruitment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import spacex.nanlabs.recruitment.model.CategoryEnum;
import spacex.nanlabs.recruitment.model.TrelloLabel;
import spacex.nanlabs.recruitment.model.TrelloList;
import spacex.nanlabs.recruitment.model.TrelloMember;

@Service
public class TaskServiceImpl implements ITaskService {

	ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

	private final String APP_KEY = spacex.nanlabs.recruitment.config.PropertiesReader.getProperty("APP_KEY");
	private final String APP_SECRET = spacex.nanlabs.recruitment.config.PropertiesReader.getProperty("APP_SECRET");
	private final String URL_BASE = spacex.nanlabs.recruitment.config.AditionalPropertiesReader.getProperty("URL_BASE");
	private final String BOARD_ID = spacex.nanlabs.recruitment.config.AditionalPropertiesReader.getProperty("BOARD_ID");

	private final String URL_LABELS = URL_BASE + "/boards/" + BOARD_ID + "/labels";
	private final String URL_MEMBERS = URL_BASE + "/boards/" + BOARD_ID + "/members";
	private final String URL_LISTS = URL_BASE + "/boards/" + BOARD_ID + "/lists";

	private final Logger logger = LogManager.getLogger(TaskServiceImpl.class);


	@Override
	public TrelloLabel[] getLabels() {
		TrelloLabel[] trelloLabelArray = null;
		HttpResponse<String> response = null;

		try {
			response = Unirest.get(URL_LABELS).queryString("key", APP_KEY).queryString("token", APP_SECRET).asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			trelloLabelArray = mapper.readValue(response.getBody(), TrelloLabel[].class);

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return trelloLabelArray;
	}

	@Override
	public TrelloList[] getLists() {

		TrelloList[] trelloListArray = null;
		HttpResponse<String> response = null;

		try {
			response = Unirest.get(URL_LISTS).queryString("key", APP_KEY).queryString("token", APP_SECRET).asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			trelloListArray = mapper.readValue(response.getBody(), TrelloList[].class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return trelloListArray;

	}

	@Override
	public TrelloMember[] getMembers() {
		TrelloMember[] trelloMemberArray = null;
		HttpResponse<String> response = null;

		try {
			response = Unirest.get(URL_MEMBERS).queryString("key", APP_KEY).queryString("token", APP_SECRET).asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			trelloMemberArray = mapper.readValue(response.getBody(), TrelloMember[].class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return trelloMemberArray;
	}

	@Override
	public ResponseEntity<String> createCard(String idList, String name, String desc, String[] idMembers,
			String[] idLabels) {
		HttpResponse<JsonNode> response = null;
	

		try {
			logger.info("Creating Card with name:" + name);
			response = Unirest.post(URL_BASE + "/cards").queryString("key", APP_KEY).queryString("token", APP_SECRET)
					.queryString("idList", idList).queryString("name", name).queryString("desc", desc)
					.queryString("idMembers", Arrays.asList(idMembers)).queryString("idLabels", Arrays.asList(idLabels))
					.asJson();
			
			logger.info("IdList: "+idList);
			logger.info("Response body: "+response.getBody().getObject().toString());
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			logger.error("Exception has ocurred creating the list. Message: " + e.getMessage());
		}

		return ResponseEntity.ok("Task has been created successfully");

	}

	@Override
	public TrelloList createList(String name) {
		HttpResponse<JsonNode> response = null;
		TrelloList newList = new TrelloList();
		try {
			logger.info("Creating List with name: " + name);
			response = Unirest.post(URL_BASE + "/lists").queryString("key", APP_KEY).queryString("token", APP_SECRET)
					.queryString("idBoard", BOARD_ID).queryString("name", name).asJson();
			logger.info("List with name: " + name + " has been created successfully");
			try {
				newList = mapper.readValue(response.getBody().toString(), TrelloList.class);
				logger.info(newList);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Exception has ocurred creating the list. Message: " + e.getMessage());
		}

		return newList;

	}

	@Override
	public TrelloLabel createLabel(String name) {
		HttpResponse<JsonNode> response = null;
		TrelloLabel newLabel = new TrelloLabel();
		try {
			logger.info("Creating Label with name: " + name);
			response = Unirest.post(URL_BASE + "/labels").queryString("key", APP_KEY).queryString("token", APP_SECRET)
					.queryString("idBoard", BOARD_ID).queryString("name", name).asJson();
			logger.info("Label with name: " + name + " has been created successfully");
			try {
				newLabel = mapper.readValue(response.getBody().toString(), TrelloLabel.class);
				logger.info(newLabel);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Exception has ocurred creating the list. Message: " + e.getMessage());
		}

		return newLabel;

	}

	public TrelloList getListIfExistOrCreate(String name) {
		List<TrelloList> listOfLists = new ArrayList<TrelloList>(Arrays.asList(getLists()));
		TrelloList list = new TrelloList();
		list = null;
		if (listOfLists.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent()) {
			list = listOfLists.stream().filter(o -> o.getName().equals(name)).findFirst().get();
			logger.info("List with name: " + name + " , already exist");
		} else {
			logger.info("List with name: " + name + " , doesn't exist");
			createList(name).getId();
		}

		return list;
	}
	
	public TrelloList getExistingList(String name) {
		List<TrelloList> listOfLists = new ArrayList<TrelloList>(Arrays.asList(getLists()));
		TrelloList list = new TrelloList();
		list = null;
		if (listOfLists.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent()) {
			list = listOfLists.stream().filter(o -> o.getName().equals(name)).findFirst().get();
			logger.info("List with name: " + name + " , already exist");
		} 
		return list;
	}

	public HashMap<String, String> getLabelMapIfExistOrCreate() {
		List<TrelloLabel> listOfLabels = new ArrayList<TrelloLabel>(Arrays.asList(getLabels()));
		HashMap<String, String> labelIdMap = new HashMap<String, String>();
		TrelloLabel label = new TrelloLabel();
		label = null;

		for (CategoryEnum category : CategoryEnum.values()) {
			if (listOfLabels.stream().filter(o -> o.getName().equals(category.getName())).findFirst().isPresent()) {
				label = listOfLabels.stream().filter(o -> o.getName().equals(category.getName())).findFirst().get();
				labelIdMap.put(label.getName(), label.getId());
				logger.info("Label with with name: " + label.getName() + " , already exist");
			} else {
				label = createLabel(category.getName());
				labelIdMap.put(label.getName(), label.getId());
				logger.info("Label with with name: " + label.getName() + " , has been created");
			}
		}
		return labelIdMap;
	}
	
	public HashMap<String, String> getExistingLabelMap() {
		List<TrelloLabel> listOfLabels = new ArrayList<TrelloLabel>(Arrays.asList(getLabels()));
		HashMap<String, String> labelIdMap = new HashMap<String, String>();
		TrelloLabel label = new TrelloLabel();
		label = null;

		for (CategoryEnum category : CategoryEnum.values()) {
			if (listOfLabels.stream().filter(o -> o.getName().equals(category.getName())).findFirst().isPresent()) {
				label = listOfLabels.stream().filter(o -> o.getName().equals(category.getName())).findFirst().get();
				labelIdMap.put(label.getName(), label.getId());
			} 
		}
		return labelIdMap;
	}

	

}