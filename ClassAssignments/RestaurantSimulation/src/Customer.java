

/**
 * Represents a single customer.
 * @author Monika
 * @version Jan. 19, 2014
 */
public class Customer {
    
    /**
     * Represents time remaining at customer pick-up line.
     */
    private int foodWaitRemaining;
    
    /**
     * Represents order preparation time for this customer.
     */
    private int foodWaitAssigned;
    
    /**
     * Represents register queue wait time.
     */
    private int lineWait;
    
    /**
     * Represents time spent at a register.
     */
    private int registerTime;
    
    /**
     * Represents overall waiting time spent in the store.
     */
    private int overallTime;

	private int registerWaitAssigned;

    /**
     * Constructs a customer.
     */
    public Customer() {
        foodWaitRemaining = 0;
        foodWaitAssigned = 0;
        lineWait = 0;
        registerTime = 0;
        overallTime = 0;
    }
    
  
    /**
     * Returns time remaining at customer pick-up line.
     * @return time remaining at customer pick-up line.
     */
    public int getFoodWait() {
        return foodWaitRemaining;
    }

    /**
     * Returns register queue wait time.
     * @return register queue wait time.
     */
    public int getLineWait() {
        return lineWait;
    }
    
    /**
     * Returns time spent at a register.
     * @return time spent at a register.
     */
    public int getServingTime() {
        return registerTime;
    }
    
    /**
     * Returns overall customer waiting time.
     * @return overallTime = lineWait + foodWaitAssigned + registerTime
     */
    public int calculateOverallTime() {
        overallTime = foodWaitAssigned + lineWait + registerWaitAssigned;
        return overallTime;
    }
    
    /**
     * Assigns order waiting time.
     * @param foodWait > 0
     */
    public void setFoodWait(int foodWait) {
        foodWaitRemaining = foodWait;
        foodWaitAssigned = foodWait;
    }
    
    /**
     * Assigns register waiting time.
     * @param regWait > 0
     */
    public void setRegWait(int regWait) {
    	registerWaitAssigned = regWait;
        registerTime = regWait;
    }

    /**
     * Updates time spent in a registers' queue.
     */
    public void updateLineWait() {
        lineWait++;
    }
    
    /**
     * Updates time spent at the actual register.
     */
    public void updateRegisterWait() {
    	registerTime --;
    }
    
    /**
     * Updates time remaining until the order is ready.
     */
    public void updateFoodWait() {
        foodWaitRemaining--;
    }
    
    public String toString() {
    	return "" + registerTime + " " + lineWait;
    }
}