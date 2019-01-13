package helper;

import model.Message;

public class SortHelper {
	public static int messageCreatedAt(Message a,Message b) {
		if (a.getId()<(b.getId())) {
			return 1;
		} else {
			return -1;
		}
	}

}
