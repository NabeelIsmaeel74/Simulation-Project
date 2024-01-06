In this code we tried to show simulation for the operation of elevator that take one person just to the up stairs in each time, using Java Programming Language, the simulation is designed to model the behavior of an elevator system with randomly generated customer arrival times and service times.

*Here is a description of each class:

1-Customer Class:
          The Customer class represents an individual customer in the elevator system.                              	  
	  *Each customer has the following attributes:
		1-sinceLastArrival: The time elapsed since the arrival of the last customer.
		2-serviceTime: The time required for the service for this customer.
		3-arrival: The arrival time of the customer.
		4-serviceBegin: The time at which the service for the customer begins.
		5-serviceEnd: The time at which the service for the customer ends.
		6-customerInSys: The total time the customer spends in the elevator system.
		7-customerWaiting: The waiting time of the customer before the service begins since their arrival.
2-Elevator Class:
          The Elevator class represents the overall elevator system and manages a list of customers. 
	  *It has the following attributes:
		1-sysIdle: The total idle time of the elevator system.
		2-customers: A list of Customer objects representing the customers in the system.
		3-AvgCustomerInSys: The average time customers spend in the elevator system.
		4-AvgWaitingTime: The average waiting time for customers before their service begins.
		5-proportionOfIdle: The proportion of time the elevator system is idle.
3-Main Class:
	The Main class serves as the entry point for the elevator simulation program. It interacts with the user through the console, prompting them to input the number of customers they 	want to simulate in the elevator system. The essential functionality of the class is to create an instance of the Elevator class, generate a specified number of random customers, and 	then display statistical information about the simulated elevator system.