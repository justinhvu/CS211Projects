public class VIPClient extends Client implements Prioritizable{
    //fields
    private int memberSince;
    private int priority;

    //getters and setters
    public void setMemberSince(int memberSince) {
        this.memberSince = memberSince;
    }

    public int getMemberSince() {
        return memberSince;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public int getPriority() {
        return priority;
    }

    //constructor
    public VIPClient(String firstName, String lastName, int birthYear, String gender, int arrivalTime, int patience, Request[] requests, int memberSince, int priority){
        super(firstName, lastName, birthYear, gender, arrivalTime, patience, requests);

        setMemberSince(memberSince);
        setPriority(priority);
    }

    //other methods
    public String toString() {
        return (super.toString() + 
                "\n** VIP since         : " + memberSince + 
                "\n** priority          : " + priority);
    }
}
