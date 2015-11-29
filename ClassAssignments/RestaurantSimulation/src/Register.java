/**
 * Represents a sales register that can process one customer
 * at a time.
 * @author Letian Sun
 * @version 1/28/15
 */
public class Register {
	
	/**
	 * The customer that the register is currently processing
	 */
	private Customer currentCustomer;
	
	/**
	 * Assign the register to process a given register
	 * @param thecustomer the given customer for register to process
	 */
	public void assignCustomer(Customer thecustomer){
		currentCustomer = thecustomer;
	}
	
	/**
	 * Simulate one minute that the customer has spent at the register
	 */
	public void processOneMove(){
		//decrement register waiting time
		if(currentCustomer != null)
			currentCustomer.updateRegisterWait();
	}
	
	/**
	 * Return if the register is done processing its current customer
	 * @return if register is done processing its current customer
	 */
	public boolean isDoneProcessing() {
		return currentCustomer != null && currentCustomer.getServingTime() == 0;
	}
	
	/**
	 * Return the customer the register is currently working with
	 * @return customer register is currently working with 
	 */
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	
	/**
	 * Return if the register is open 
	 * @return if the register is oepn 
	 */
	public boolean isOpen() {
		return currentCustomer == null;
	}
}
