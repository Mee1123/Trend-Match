package service;

import java.sql.Connection;

import dao.table.ValuesDAO;
import model.Value;;



public class ValueService {
	private Connection connection = null;
	ValuesDAO valuesDAO = new ValuesDAO();


	public Value getValueID(String valueName) {
		ValuesDAO dao = new ValuesDAO();
		this.connection = dao.createConnection();
		Value value = new Value();
		value = dao.selectValueByName(valueName);
		this.connection = null;
		return value;
	}


}
