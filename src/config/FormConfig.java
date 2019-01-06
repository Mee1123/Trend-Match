package config;

public enum FormConfig {
	EMAIL(1,40,"^.+@.+"),
	PASSWORD(8,20,"");
	private static int MIN;
	private static int MAX;
	private static String REGULAR_EXPRESSION;

	private FormConfig(int mIN, int mAX, String rEGULAR_EXPRESSION) {
	}

	public static int getMIN() {
		return MIN;
	}
	public static int getMAX() {
		return MAX;
	}
	public static String getREGULAR_EXPRESSION() {
		return REGULAR_EXPRESSION;
	}
}
