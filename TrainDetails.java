package Book_TrainTickets;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainDetails {
	// private static Map<Integer,HomePage> trainstoragemap=new
	// HashMap<Integer,HomePage>();
	// private static Map<Integer,PassengerDetails> passengerstoragemap=new
	// HashMap<Integer,PassengerDetails>();
	private List<String> sourcelist = new ArrayList<>();
	private int trainId;
	private String source;
	private String destination;
	private Date sourcetime;
	private Date deparatureTime;
	private String quota;
	private int fare;
	private int numberofseats;

	enum Quota {
		GENERAL(1, 100), TATKAL(2, 200), LADIES(3, 300);

		protected final int key, value;

		Quota(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}
	}

	protected void setTrainID(int id) {
		this.trainId = id;
	}

	protected int getTrainID() {
		return trainId;
	}

	protected void setSource(String source) {
		this.source = source;
	}

	protected String getSource() {
		return source;
	}

	protected void setDestination(String destination) {
		this.destination = destination;
	}

	protected String getDestination() {
		return destination;
	}

	protected void setSourceTime(Date sourcedate) {
		this.sourcetime = sourcedate;
	}

	protected Date getSourceTime() {
		return sourcetime;
	}

	protected void setDestinationTime(Date destination) {
		this.deparatureTime = destination;
	}

	protected Date getDetinationTime() {
		return deparatureTime;
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

	protected int getQuotaAmount(int n) {
		for (Quota enumiter : Quota.values()) {
			if (enumiter.getKey() == n) {
				return enumiter.getValue();
			}
		}
		return 0;
	}

	protected void setFareAmount(int amount) {
		this.fare = amount;
	}

	protected int getFareAmount() {
		return fare;
	}

	protected void setNumberOfSeats(int n) {
		this.numberofseats = n;
	}

	protected int getNumberOfSeats() {
		return numberofseats;
	}

	protected void reduceNumberOfSeats(int n) {
		this.numberofseats -= n;
	}
}
