package Book_TrainTickets;

public class PassengerDetails {
	private int id;
	private String name;
	private int numberofpassenger;
	private String quota;
	private int fareamount;
	private boolean seater;
	private boolean sleeperclass;
	private boolean ACclass;

	protected void setPassengerId(int id) {
		this.id = id;
	}

	protected int getPassengerId() {
		return id;
	}

	protected void setPassengerName(String name) {
		this.name = name;
	}

	protected String getPassengerName() {
		return name;
	}

	protected void setNumberOfPassenger(int id) {
		this.numberofpassenger = id;
	}

	protected int getNumberOfPassenger() {
		return numberofpassenger;
	}

	protected boolean setQuota(int quotanumber) {
		boolean available = false;
		for (TrainDetails.Quota enumiter : TrainDetails.Quota.values()) {
			if (enumiter.getKey() == quotanumber) {
				this.quota = enumiter.toString();
				available = true;
			}
		}
		return available;
	}

	protected String getQuota() {
		return quota;
	}

	protected void setFareAmount(int number) {
		switch (number) {
		case 1:
			this.seater = true;
			break;
		case 2:
			this.sleeperclass = true;
			break;
		case 3:
			this.ACclass = true;
			break;
		}
	}

	protected void setClass(int number) {
		switch (number) {
		case 1:
			this.seater = true;
			break;
		case 2:
			this.sleeperclass = true;
			break;
		case 3:
			this.ACclass = true;
			break;
		}
	}

	protected boolean getClass(int number) {
		switch (number) {
		case 1:
			return seater;
		case 2:
			return sleeperclass;
		case 3:
			return ACclass;
		default:
			return false;
		}
	}
}
