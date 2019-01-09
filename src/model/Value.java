package model;

public class Value extends Deflate{

	private int value_id;
	private String value;

	public int getValue_id(){
		return value_id;
	}
	public void setValue_id(int value_id){
		this.value_id=value_id;
	}


	public String getValue(){
		return value;
	}
	public void setValue(String value){
		this.value=value;
	}



}