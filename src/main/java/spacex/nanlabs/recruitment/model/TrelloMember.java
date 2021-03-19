package spacex.nanlabs.recruitment.model;

public class TrelloMember {
	String id;
	String memberType;
	boolean unconfirmed;
	boolean deactivated;
	
	
	public TrelloMember() {
		super();
	}


	public TrelloMember(String id, String memberType, boolean unconfirmed, boolean deactivated) {
		super();
		this.id = id;
	
		this.memberType = memberType;
		this.unconfirmed = unconfirmed;
		this.deactivated = deactivated;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}





	


	public String getMemberType() {
		return memberType;
	}


	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}


	public boolean isUnconfirmed() {
		return unconfirmed;
	}


	public void setUnconfirmed(boolean unconfirmed) {
		this.unconfirmed = unconfirmed;
	}


	public boolean isDeactivated() {
		return deactivated;
	}


	public void setDeactivated(boolean deactivated) {
		this.deactivated = deactivated;
	}


	@Override
	public String toString() {
		return "TrelloMembers [id=" + id + ", memberType=" + memberType + ", unconfirmed="
				+ unconfirmed + ", deactivated=" + deactivated + "]";
	}
	
	
	
	
	

}
