package spacex.nanlabs.recruitment.model;

public interface ITrelloCard {

	public String getName();

	public void setName(String name);

	public String getDesc();

	public void setDesc(String desc);

	public String getIdList();

	public void setIdList(String idList);

	public String[] getIdMembers();

	public void setIdMembers(String[] idMembers);

	public String[] getIdLabels();

	public void setIdLabels(String[] idLabels);

}
