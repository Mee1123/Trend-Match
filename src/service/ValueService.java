
package service;

import java.util.ArrayList;

import dao.table.ValuesDAO;
import model.Value;;



public class ValueService {
	private ValuesDAO valuesDAO = new ValuesDAO();


	public Value getValueID(String valueName) {
		Value value = new Value();
		value = valuesDAO.selectValueByName(valueName);
		return value;
	}

	public Value getValueName(int valueID) {
		Value value = new Value();
		value = valuesDAO.selectValueByID(valueID);
		return value;
	}

	public ArrayList<Value> getAllValue() {
		return valuesDAO.selectValueAll();
	}

	public void setValue(String valueName){
		valuesDAO.insertValue(valueName);
	}
/**
 * 価値観の名前からIdと名前をValue型で返します.ない場合はDBに登録してその後登録したものを返します.引数が""の場合はnullを返します.
 * @param valueName
 * @return
 */
	public Value getAndCreateValueByName(String valueName){
		System.out.println("ValueService.getAndCreateValueByName:valueName="+valueName);
		if (valueName==null|| valueName.equals("")) {
			return null;
		}
		Value value = valuesDAO.selectValueByName(valueName);
		if(value.getId()==0){
			valuesDAO.insertValue(valueName);
		}
		value = valuesDAO.selectValueByName(valueName);
		System.out.println("ValueService.getAndCreateValueByName:valueId="+value.getId());
		return value;
	}

}