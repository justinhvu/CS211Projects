
public class MainTester {
    public static void main(String[] args)
    {
        QueueSystem queueSystem = new QueueSystem(1, true, false);

        String[] client1Request1Questions = {"why am i lonely"};
        Request client1Request1 = new InformationRequest("lol", 1, 1, client1Request1Questions);
        String[] client1Request2Questions = {"let me be alone"};
        Request cleint1Request2 = new InformationRequest("lmao", 1, 1, client1Request2Questions);
        Request[] client1Requests = {client1Request1, cleint1Request2};
        Client client1 = new Client("Justin", "Vu", 1960, "MALE", 1, 0, client1Requests);
        
        String[] client2Request2Questions = {"return siv"};
        Request client2Request1 = new InformationRequest("haha", 1, 1, client2Request2Questions);
        Request[] client2Requests = {client2Request1};
        Client client2 = new Client("James", "Horng", 1821, "MALE", 1, 0, client2Requests);

        System.out.println();
        VIPQueue queue1 = new VIPQueue("Queue1", 1);
        Queue[] queues1 = {queue1};
        QueueSystem.setQueues(queues1);

        Client[] clientsWorld = {client1,client2};
        QueueSystem.setClientsWorld(clientsWorld);
        System.out.println();
        
        System.out.println("--------------------");
        System.out.println("Clock: " + QueueSystem.getClock()); //0
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println("--------------------");
        QueueSystem.increaseTime();
        System.out.println("Clock: " + QueueSystem.getClock()); //1
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println("--------------------");
        QueueSystem.increaseTime();
        System.out.println("Clock: " + QueueSystem.getClock()); //2
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println("--------------------");
        QueueSystem.increaseTime();
        System.out.println("Clock: " + QueueSystem.getClock()); //3
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println("--------------------");
        QueueSystem.increaseTime();
        System.out.println("Clock: " + QueueSystem.getClock()); //4
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println(queueSystem.toString(true));
        System.out.println();
    }
}
