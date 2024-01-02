import java.util.Random;

public class Customer {
    private int  sinceLastArrival   ;
    private   int  serviceTime  ;
    private   int arrival  ;
    private  int serviceBegin  ;
    private  int  serviceEnd ;
    private  int  customerInSys  ;
    private  int  customerWaiting ;

    public  Customer () {
        sinceLastArrival = new Random().nextInt(10 )  ;
        serviceTime = new Random().nextInt( 7 ) +1   ;
        arrival = serviceBegin = serviceEnd = 0 ;
    }


    public void setSinceLastArrival(int sinceLastArrival) {
        this.sinceLastArrival = sinceLastArrival;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getSinceLastArrival() {
        return sinceLastArrival;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getArrival() {
        return arrival;
    }

    public int getServiceBegin() {
        return serviceBegin;
    }

    public int getServiceEnd() {
        return serviceEnd;
    }

    public void setServiceBegin(int serviceBegin) {
        this.serviceBegin = serviceBegin;
    }

    public void setServiceEnd(int serviceEnd) {
        this.serviceEnd = serviceEnd;
    }

    public  void  calcCustomerInSys () {
        this.customerInSys = serviceEnd - arrival ;
    }

    public int getCustomerInSys() {
        return customerInSys;
    }

    public void setCustomerInSys(int customerInSys) {
        this.customerInSys = customerInSys;
    }

    public  void setDefault() {
        sinceLastArrival = serviceTime = 0 ;
    }

    public int getCustomerWaiting() {
        return customerWaiting;
    }

    public void setCustomerWaiting(int customerWaiting) {
        this.customerWaiting = customerWaiting;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "sinceLastArrival=" + sinceLastArrival +
                ", serviceTime=" + serviceTime +
                ", arrival=" + arrival +
                ", serviceBegin=" + serviceBegin +
                ", serviceEnd=" + serviceEnd +
                ", customerInSys=" + customerInSys +
                ", customerWaiting=" + customerWaiting +
                '}';
    }
}
