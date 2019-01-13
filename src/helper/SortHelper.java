package helper;

import model.Message;

public class SortHelper {
	public static int messageCreatedAt(Message a,Message b) {
		if (a.getCreatedAt().before(b.getCreatedAt())) {
			return 1;
		} else {
			return -1;
		}
	}

}
