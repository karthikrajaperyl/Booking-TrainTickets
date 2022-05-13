package Book_TrainTickets;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

class MyException extends Exception {
	MyException(String s) {
		super(s);
	}
}

public class HomePage {
	static BufferedReader readerobj = new BufferedReader(new InputStreamReader(System.in));
	private static Map<Integer, TrainDetails> trainstoragemap = new HashMap<Integer, TrainDetails>();
	private static Map<Integer, PassengerDetails> passengerstoragemap = new HashMap<Integer, PassengerDetails>();
	private List<String> sourcelist = new ArrayList<>();

	// Adding the Train details
	private boolean addTrainDetails() {
		TrainDetails tempobj = new TrainDetails();
		try {
			SimpleDateFormat date = new SimpleDateFormat();
			Random random = new Random();
			int randomid = random.nextInt(100);
			tempobj.setTrainID(randomid);
			System.out.println("Enter the Source");
			String source = readerobj.readLine();
			tempobj.setSource(source);
			sourcelist.add(tempobj.getSource());
			System.out.println("Enter the Detination");
			String destination = readerobj.readLine();
			tempobj.setDestination(destination);
			System.out.println("Enter the Fare");
			int fareamount = Integer.parseInt(readerobj.readLine());
			System.out.println("Enter the Train Quota-\n1.General\n2.tatkal\n3.Ladies");
			int tempquota = Integer.parseInt(readerobj.readLine());
			if (!tempobj.setQuota(tempquota))
				throw new MyException("Given Value is not suit for Quota");

			System.out.println("Enter the sourcetime-Enter in the format dd-MM-yyyy HH:mm:ss");
			SimpleDateFormat dateformatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String sourcedate = readerobj.readLine();
			Date sourceparsedate = dateformatter1.parse(sourcedate);
			tempobj.setSourceTime(sourceparsedate);
			System.out.println("Enter the destinaitoneTime-Enter in the format dd-MM-yyyy HH:mm:ss");
			SimpleDateFormat dateformatter2 = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
			String destinationdate = readerobj.readLine();
			Date destinationparsedate = dateformatter2.parse(destinationdate);
			tempobj.setDestinationTime(destinationparsedate);
			System.out.println("Enter the number of passenger can Accomodate");
			int numberofseats = Integer.parseInt(readerobj.readLine());
			tempobj.setNumberOfSeats(numberofseats);
			trainstoragemap.put(tempobj.getTrainID(), tempobj);
			return true;
		} catch (NumberFormatException e) {
			System.out.println(e.toString());
			return false;
		} catch (InputMismatchException e) {
			System.out.println(e.toString());
			return false;
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (IOException e) {
			System.out.println("Given value is Invalid");
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.toString());
			return false;

		} catch (MyException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// Booking the train for passenger
	private boolean addPassengerDetails() {
		PassengerDetails passengerobj = new PassengerDetails();
		try {
			Random random = new Random();
			int passengerId = random.nextInt(100);
			System.out.println("Enter the source to travel");
			String sourcestr = readerobj.readLine();
			// showing Available Train
			System.out.println("Available Trains Detials-");
			if (!(availableTrain(sourcestr, false)))
				return false;
			passengerobj.setPassengerId(passengerId);
			System.out.println("Enter your Name");
			String name = readerobj.readLine();
			passengerobj.setPassengerName(name);
			System.out.println("Enter the flightid");
			int flightid = Integer.parseInt(readerobj.readLine());
			TrainDetails temperoryTrainObj = trainstoragemap.get(flightid);
			System.out.println("Enter the Number of Passenger");
			int numberofpassenger = Integer.parseInt(readerobj.readLine());
			while (numberofpassenger > temperoryTrainObj.getNumberOfSeats()) {
				System.out.println("Seats is not available");
				System.out.println("Do you want to continue-0 0r 1");
				int n = Integer.parseInt(readerobj.readLine());
				if (n == 0)
					break;
			}
			passengerobj.setNumberOfPassenger(numberofpassenger);
			System.out.println("Enter the Train Quota-\n1.General\n2.tatkal\n3.Ladies");
			int quotanumber = Integer.parseInt(readerobj.readLine());
			if (!passengerobj.setQuota(quotanumber)) {
				throw new MyException("Given Value is not suit for Quota");

			}
			int fareamount;
			fareamount = (temperoryTrainObj.getFareAmount() + temperoryTrainObj.getQuotaAmount(quotanumber))
					* numberofpassenger;
			passengerobj.setFareAmount(fareamount);
			passengerstoragemap.put(passengerobj.getPassengerId(), passengerobj);
			return true;
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (IOException e) {
			System.out.println("Input Mismatch Error");
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.toString());
			return false;
		} catch (MyException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	private boolean availableTrain(String source, boolean flag) throws Exception {
		boolean available = false;
		for (Map.Entry<Integer, TrainDetails> mapiter : trainstoragemap.entrySet()) {
			TrainDetails tempiter = mapiter.getValue();
			if (tempiter.getSource().equals(source) || flag == true) {
				System.out.println("\nTrianId-" + tempiter.getTrainID() + "\nTrain Source-" + tempiter.getSource()
						+ "\nTrain Destiantion-" + tempiter.getDestination() + "\nTrian SourceTime"
						+ tempiter.getSourceTime() + "\nTrain DestinationTime" + tempiter.getDetinationTime());
				available = true;
			}
		}
		if (!available) {
			System.out.println("No Train is Available for right now");

		}
		return available;
	}

	public static void main(String[] args) {
		try {
			boolean continuation = true;
			int itrCount1 = 0, choice = 0, itrcount2 = 0;
			while (continuation) {
				itrCount1++;
				// Throwing an StackOverFlow error if iteration runs for more than 10 times
				if (itrCount1 > 10)
					throw new StackOverflowError();
				HomePage homeobj = new HomePage();
				if (itrcount2 > 5) {
					throw new OutOfMemoryError();
				}
				try {
					System.out.println(
							"Enter Your Choice \n1.Add Train Details\n2.Available Trains\n3.Book Train\n4.Exist");
					choice = Integer.parseInt(readerobj.readLine());
				} catch (IOException e) {
					System.out.println("Enter the valid input");
					continue;
				} catch (NumberFormatException e) {
					System.out.println("Enter the Valid Input like 1,2,3");
				}
				switch (choice) {
				case 1:
					if (homeobj.addTrainDetails()) {
						System.out.println("Train Details added Successfully");
						itrcount2++;
					} else
						System.out.println("Train details Was not Added");
					;
					break;
				case 2:
					System.out.println("Available Trains Details\n");
					homeobj.availableTrain("", true);
					break;
				case 3:
					if (homeobj.addPassengerDetails())
						System.out.println("Train Booked Successfully with id");
					else
						System.out.println("Train was Not Booked Succesfully");

					break;
				case 4:
					System.out.println("Program Termination");
					continuation = false;
					break;
				default:
					System.out.println("Enter the valid choice");
				}
			}
		} catch (StackOverflowError e) {
			System.out.println("StackOverflow Exception");
		} catch (OutOfMemoryError e) {
			System.out.println("Running OutofMemory");
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Enter the Valid Input");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
