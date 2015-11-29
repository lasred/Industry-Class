import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a simulation for a fast food restaurant.
 * 
 * @author Letian Sun
 * @verison 1/25/15
 */
public class Restaurant {
	/**
	 * One register always has to be open 
	 */
	private static final int MIN_REGS_OPEN = 1;
	
	/**
	 * At any point, the crew can work on the first four orders.
	 */
	private static final int CREW_WORK = 4;
	
	/**
	 * Customers who are waiting for food.
	 */
	private List<Customer> foodPickUpLine;
	
	/**
	 * List of served customers
	 */
	private List<Customer> servedCustomers;
	
	/**
	 * Queue to model the customer line.
	 */
	private MyQueue<Customer> customerLine;
	
	/**
	 * List of sales registers.
	 */
	private List<Register> registers;

	/**
	 * Stated threshold for a new sales register to open
	 */
	private int queueTNum;
	
	/**
	 * Number of  registers in the restaurant
	 */
	private int maxRNum;
	
	/**
	 * Constructs a Restaurant with a given threshold and number of registers.
	 * @param queueTNum Stated threshold that when exceede, a new sales register should open,
	 * if possible
	 * @param maxRNum The number of registers in the restaurant
	 */
	public Restaurant(int queueTNum, int maxRNum) {
		this.maxRNum = maxRNum;
		this.queueTNum = queueTNum;
		customerLine = new MyQueue<Customer>();
		foodPickUpLine = new LinkedList<Customer>();
		registers = new ArrayList<Register>();
		//must always be one register
		registers.add(new Register());
		servedCustomers = new LinkedList<Customer>();
	}
	
	/**
	 * Return average turnaround time of served customers
	 * @return average turnaround time of served customers.
	 */
	private float getAverageTurnAroundTime() {
		int totalTurnAroundTime = 0;
		for(Customer served: servedCustomers) {
			totalTurnAroundTime += served.calculateOverallTime();
		}
		return ((float)totalTurnAroundTime) / servedCustomers.size();
	}
	
	/**
	 * Writes out information for this restaurant - queue threshold,
	 * total number of customers served, number of customers still 
	 * waiting for food at time simulation ends, etc....
	 */
	public void writeStats() {
		File file = new File("stats.txt");
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.append(String.format("queue threshold: %d "
					+ "max number of registers: %d\n", queueTNum, maxRNum));
			fw.append(String.format("total number of served customers: %d\n",
					servedCustomers.size()));
			fw.append(String.format("Average turnaround time of served"
					+ " customers in minutes: %f\n", getAverageTurnAroundTime() ));
			fw.append(String.format("At simulation's end, number of people"
					+ " still waiting for food: %d\n", foodPickUpLine.size()));
			fw.append(String.format("At simulation's end, number of people"
					+ " still waiting in queue: %d\n\n", customerLine.getSize()));
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Add a customer to restaurant line.
	 * @param orderTime how long the customer should wait for his/her food.
	 * @param registerTime time customer should spend at a register
	 */
	public void addCustomer(int orderTime, int registerTime) {
		if(customerLine.getSize() + 1 > queueTNum * registers.size()
				&& registers.size() < maxRNum) {
			//add new register
			registers.add(new Register());
		}
		//	customerLine.enqueue();
		Customer toAddCustomer = new Customer();
		toAddCustomer.setRegWait(registerTime);
		toAddCustomer.setFoodWait(orderTime);
		customerLine.enqueue(toAddCustomer);
	}
	
    /**
     * update actual lines based on customers and registers data: 
     * waiting queue, customers at registers, 
     *customers waiting for food pick-up, and customers served             
     */
	public void updateLines() {
		for(int count = registers.size() - 1; count >= 0; count --) {
			Register register = registers.get(count);
			//if the current register is removed as result of waiting queue shrinking
			boolean removedRegister = false;
			if(register.isDoneProcessing()) {
				foodPickUpLine.add(register.getCurrentCustomer());
				if(customerLine.getSize() <= queueTNum * registers.size()
						&& registers.size() >MIN_REGS_OPEN ) {
					removedRegister = true;
					registers.remove(count);
				} else {
					//done processing
					register.assignCustomer(null);
				}
			}
			if(!removedRegister && register.isOpen() && !customerLine.isEmpty()) {
				register.assignCustomer(customerLine.dequeue());
			}
		}
		//only possibility is that the first at most four are done
		int start = foodPickUpLine.size() > 4? 3 : foodPickUpLine.size() - 1;
		for(int count = start; count >= 0; count --) {
			Customer customerWaiting = foodPickUpLine.get(count);
			if(customerWaiting.getFoodWait() == 0) {
				//done, add to list of served customers
				servedCustomers.add(customerWaiting);
				foodPickUpLine.remove(customerWaiting);
			}
		}
	}
	//MVP Code Print out code you da real mvp for this assignment
//	public void printRegister() {
//		for(int count = 0; count < registers.size(); count ++) {
//			Customer currentCust = registers.get(count).getCurrentCustomer();
//			System.out.println("register homie: " + currentCust.getServingTime() + " "
//					 + currentCust.getLineWait());
//		}
//	}
//	public void print() {
//		customerLine.printOut();
//	}
	/**
	 * update times of customers and registers in all lines.
	 */
	public void updateTimes() {
		//iterate through waiting queue, update waiting time
		Iterator<Customer> customers = customerLine.iterator();
		//while there are still elements in waiting queue to update
		while(customers.hasNext()) {
			customers.next().updateLineWait();
		}
		for(Register r: registers) {
			r.processOneMove();
		}
		int currentCost = 0;
		//crew works on the first four
		while(currentCost < foodPickUpLine.size() && currentCost < CREW_WORK) {
			foodPickUpLine.get(currentCost).updateFoodWait();;
			currentCost ++;
		}
	}

}
