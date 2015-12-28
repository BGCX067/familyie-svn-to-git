class Person {
	private BloodGroup _bloodGroup;

	public Person(BloodGroup bloodGroup) {
		_bloodGroup = bloodGroup;
	}

	public void setBloodGroup(BloodGroup arg) {
		_bloodGroup = arg;
	}

	public BloodGroup getBloodGroup() {
		return _bloodGroup;
	}

	public static void main(String[] args) {
		Person person = new Person(BloodGroup.AB);
		BloodGroup bloodGroup = person.getBloodGroup();
		System.out.println(bloodGroup.code());
	}
}