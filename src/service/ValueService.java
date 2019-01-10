package service;

import dao.table.ValuesDAO;
import model.Value;;



public class ValueService {
	ValuesDAO valuesDAO = new ValuesDAO();


	public Value getValueID(String valueName) {
		ValuesDAO dao = new ValuesDAO();
		Value value = new Value();
		value = dao.selectValueByName(valueName);
		return value;
	}


}
