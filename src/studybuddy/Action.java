package studybuddy;

import java.util.Date;

public class Action {
	private Subject actor;
	private Date date;
	private String action;
	
	public Action(Subject person, Date time, String msg)
	{
		actor = person;
		date = time;
		action = msg;
	}
	
	public void setActor(Subject person){actor = person;}
	
	public void setDate(Date time){ date = time;}
	
	public void setAction(String msg){ action = msg;}
	
	public String getAction(){ return action;}
	
	public Date getDate(){ return date;}
	
	public Subject getActor(){ return actor;}

}
