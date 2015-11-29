

import java.util.LinkedList;
import java.util.List;


public class Driver {

    public static void main(String[] args) {
        
        // The number of waiting customers that qualifies for a new register to be open.
        int queueTNum = 5;
        
        // Max number of registers available in the store.
        int maxRNum = 4;
        
        // Counter to control simulation.
        int minutes = 0;
        
        // A flag that determines whether a customer arrives any given minute.
        boolean customerArrives = false;
        
        // Customer food order preparation time.
        int orderTime;
        
        // Customer sales register time.
        int registerTime;
        
        // Overall simulation time.
        int simulationTime = 100;
        
        // List of restaurants.
        List<Restaurant> storeCompare = new LinkedList<Restaurant>();
        
        // Initialize 10 different restaurants and add to a restaurant list.
        for (int i = 0; i < 10; i++) {
            Restaurant store = new Restaurant(queueTNum, maxRNum);
            storeCompare.add(store);
            
            // Either increment the max number of registers or the threshold value of customers
            if (i % 2 == 0)
                queueTNum++;
            else
                maxRNum++;
        
        }        
        
        // while the simulation is running
        while (minutes < simulationTime) {
            //update each store
            for (Restaurant store : storeCompare) {
                               
                customerArrives = true; // this is normally assigned based on some probability
                
                orderTime = 6;          // this is normally assigned based on some random number within a specified range
                registerTime = 5;       // this is normally assigned based on some random number within a specified range
                
                if (customerArrives)                    
                    store.addCustomer(orderTime, registerTime);    
                
                // update actual lines based on customers and registers data: 
                // waiting queue, customers at registers, customers waiting for food pick-up, and customers served             
                store.updateLines();
                
                // update times of customers and registers in all the lines
                store.updateTimes();               
            }
            
            minutes++;
        }
        
        for (Restaurant store : storeCompare) {
            store.writeStats();
        }

    }

}