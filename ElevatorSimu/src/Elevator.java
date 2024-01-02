import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private  int sysIdle  ;
    private     List<Customer> customers  ;
    private  double   AvgCustomerInSys ;
    private  double   AvgWaitingTime  ;
    private  double   proportionOfIdle;

    public  Elevator () {
        sysIdle = 0 ;
        customers = new ArrayList<>() ;
        AvgCustomerInSys = 0 ;
        AvgWaitingTime =  0 ;

        // add default customer to simplify coding
        Customer defaultCust = new Customer() ;
        defaultCust.setDefault() ;
        customers.add(defaultCust) ;
    }

    // add customer to the system
    public  void addCustomer () {
        Customer customer = new Customer() ;

        // to let the time of arrival for the first customer equal to  0
        if (customers.size() == 1 ) {
            customer.setSinceLastArrival(0);
        }

        calcArrival(customer , customers.getLast());
        calcServiceBegin(customer ,customers.getLast() ) ;
        calcServiceEnd(customer);
        calcCustomerInSys(customer);
        calcWaiting(customer );

        customers.add(customer) ;
    }


    public void calcSysIdle () {
        sysIdle = 0;
        for (int i =  1 ; i < customers.size() ; i++) {
            sysIdle+= customers.get(i).getServiceBegin() - customers.get(i-1).getServiceEnd()  ;
        }
    }


    // calculate arrival time for the customer according  to the last customer
    public  void calcArrival (Customer A , Customer B) {
        A.setArrival(B.getArrival() + A.getSinceLastArrival());
    }


    // calculate the time for start the service according to the last customer
    public  void calcServiceBegin (Customer A , Customer B) {
        A.setServiceBegin(Math.max(A.getArrival()  ,  B.getServiceEnd() ) );
    }


    // calculate the time for end of the service according to the start time
    public  void calcServiceEnd (Customer A ) {
        A.setServiceEnd(A.getServiceBegin() +  A.getServiceTime());
    }


    // calculate the time that the customer spend in the system
    public  void  calcCustomerInSys(Customer A) {
        A.setCustomerInSys(A.getServiceEnd() - A.getArrival());
    }


    // calculate the waiting time for the customer  before service begin since his arrival
    public  void calcWaiting(Customer A) {
        A.setCustomerWaiting(A.getServiceBegin() - A.getArrival());
    }


    // calculate the average for the customers in the system
    public  void  calcAvgInSys () {
        AvgCustomerInSys  =  0 ;
        for (int i =  1  ; i<customers.size() ; i++)  {
            AvgCustomerInSys += customers.get(i).getCustomerInSys() ;
        }
        AvgCustomerInSys /= customers.size() -1  ;
    }


    // calculate average waiting time for the customers before services begin since their arrival
    public void calcAvgWaiting() {
        AvgWaitingTime = 0 ;
        for (int i = 1 ; i<customers.size() ; i++) {
            Customer cus = customers.get(i) ;
            AvgWaitingTime+=cus.getCustomerWaiting() ;
        }
        AvgWaitingTime/= customers.size() -1  ;
    }


    //calculate the proportion for system idle
    public  void calcPropIdle () {
        calcSysIdle();

        proportionOfIdle = 1.0* sysIdle / customers.getLast().getServiceEnd() ;
    }


    public  void reset () {
        sysIdle = 0 ;
        AvgCustomerInSys = 0 ;
        AvgWaitingTime = 0 ;
        proportionOfIdle =  0 ;
        customers.clear();
    }


    // print statical info about the simulation
    public  void desc () {
        calcAvgInSys();
        calcSysIdle();
        calcAvgWaiting();
        calcPropIdle();
        System.out.println('\n');
        System.out.println("The average customer in the Elevator system : " + AvgCustomerInSys);
        System.out.println('\n');
        System.out.println("The average time for the  customer to get the service  in the Elevator system : " +  AvgWaitingTime);
        System.out.println('\n');
        System.out.println("The proportion of the Elevator system  idle : " + proportionOfIdle );

    }






}
