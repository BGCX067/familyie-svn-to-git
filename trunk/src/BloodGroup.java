public class BloodGroup {
	public static final BloodGroup O = new BloodGroup(0);
	public static final BloodGroup A = new BloodGroup(1);
	public static final BloodGroup B = new BloodGroup(2);
	public static final BloodGroup AB = new BloodGroup(3);

	private int _code = 0;

	public BloodGroup(int code) {
		_code = code;
	}

	public int code() {
		return _code;
	}

}
