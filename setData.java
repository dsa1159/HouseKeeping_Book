public class setData {

	String sequence, name, notes;
	int price, usedate;

	public setData(String name, int price, int usedate, String notes) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.usedate = usedate;
		this.notes = notes;
		
	}

	public String getSequence() {

		return sequence;

	}

	public void setSequence(String sequence) {

		this.sequence = sequence;

	}

	public String getname() {

		return name;

	}

	public void setname(String name) {

		this.name = name;

	}

	public int getPrice() {

		return price;

	}

	public void setPrice(int price) {

		this.price = price;

	}
	public int getUsedate() {

		return usedate;

	}

	public void setUsedate(int usedate) {

		this.usedate = usedate;
	}
	
	public String getNotes() {

		return notes;

	}

	public void setNotes(String notes) {

		this.notes = notes;
	}

		

}
