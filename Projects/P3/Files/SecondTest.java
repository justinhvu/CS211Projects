public class SecondTest {
	public static void main(String[] args)
    {
        String[] client1Request1Questions = {"why am i lonely"};
        Request client1Request1 = new InformationRequest("lol", 1, 1, client1Request1Questions);
        Request[] client1Requests = {client1Request1};
        Client client1 = new Client("Justin", "Vu", 1960, "MALE", 3, 2, client1Requests);
		
        String[] client2Request1Items = {"happiness"};
        Request client2Request1 = new BuyingProducts("lmao", 1, 1, client2Request1Items);
        Request[] client2Requests = {client2Request1};
        Client client2 = new Client("Sivalee", "Intachit", 1990, "FEMALE", 1, 3, client2Requests);

        String[] client3Request1Returns = {"depression"};
        Request client3Request1 = new ReturningItems("rofl", 1, 1, client3Request1Returns);
        Request[] client3Requests = {client3Request1};
        Client client3 = new Client("Thi", "Ley", 1980, "FEMALE", 2, 5, client3Requests);

		String[] client4Request1Items = {"alcohol"};
        Request client4Request1 = new BuyingProducts("haha", 1, 1, client4Request1Items);
        Request[] client4Requests = {client4Request1};
        Client client4 = new Client("James", "Horng", 1970, "MALE", 3, 2, client4Requests);

        String[] client5Request1Items = {"sunscreen"};
        Request client5Request1 = new BuyingProducts("ttyl", 1, 1, client5Request1Items);
        Request[] client5Requests = {client5Request1};
        Client client5 = new Client("Loc", "Nguyen", 1992, "MALE", 1, 3, client5Requests);

        String[] client6Request1Returns = {"oranges"};
        Request client6Request1 = new ReturningItems("nope", 1, 1, client6Request1Returns);
        Request[] client6Requests = {client6Request1};
        Client client6 = new Client("Jaden", "Tai", 2003, "MALE", 2, 5, client6Requests);
	
        String[] client7Request1Returns = {"keyboard"};
        Request client7Request1 = new ReturningItems("hehe", 1, 1, client7Request1Returns);
        Request[] client7Requests = {client7Request1};
        Client client7 = new Client("Alan", "Nguyen", 2004, "MALE", 6, 2, client7Requests);

        String[] client8Request1Returns = {"backpack"};
        Request client8Request1 = new ReturningItems("poopoo", 1, 1, client8Request1Returns);
        Request[] client8Requests = {client8Request1};
        Client client8 = new Client("Maria", "Loung", 2000, "FEMALE", 1, 3, client8Requests);

        String[] client9Request1Items = {"notebook"};
        Request client9Request1 = new BuyingProducts("peepee", 1, 1, client9Request1Items);
        Request[] client9Requests = {client9Request1};
        Client client9 = new Client("Annika", "Harusadangkul", 1990, "FEMALE", 3, 4, client9Requests);

        Client[] clientsWorld = {client1, client2, client3, client4, client5, client6, client7, client8, client9};
        Queue queue1 = new Queue("Queue1", 1);
        Queue queue2 = new Queue("Queue2", 1);
        Queue[] queues = {queue1, queue2};
        QueueSystem queueSystem = new QueueSystem(2, false, false);
        QueueSystem.setClientsWorld(clientsWorld);
        QueueSystem.setQueues(queues);
    
        System.out.println("-----CLIENTS IN WORLD-----");
        for (int i = 0; i < QueueSystem.getClientsWorld().length; i++) {
            System.out.println(QueueSystem.getClientsWorld()[i].toString());
            System.out.println();
        }

        System.out.println();
        System.out.println("-----INTIAL STATE-----");
        System.out.println("Clock:" + QueueSystem.getClock()); //0
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println();
        System.out.println("-----FIRST CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //1
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println();
        System.out.println("-----SECOND CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //2
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println();
        System.out.println("-----THIRD CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //3
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();
        for (int i = 0; i < QueueSystem.getQueues().length; i++) {
            for (int j = 0; j < QueueSystem.getQueues()[i].getClientsHistory().length; j++) {
                System.out.println(QueueSystem.getQueues()[i].getClientsHistory()[j].toString());
            }
        }
        System.out.println();

        System.out.println();
        System.out.println("-----FOURTH CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //4
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println();
        System.out.println("-----FIFTH CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //5
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println();
        System.out.println("-----SIXTH CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //6
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();
        for (int i = 0; i < QueueSystem.getQueues().length; i++) {
            for (int j = 0; j < QueueSystem.getQueues()[i].getClientsHistory().length; j++) {
                System.out.println(QueueSystem.getQueues()[i].getClientsHistory()[j].toString());
            }
        }
        System.out.println();

        System.out.println();
        System.out.println("-----SEVENTH CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //7
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();
        for (int i = 0; i < QueueSystem.getQueues().length; i++) {
            for (int j = 0; j < QueueSystem.getQueues()[i].getClientsHistory().length; j++) {
                System.out.println(QueueSystem.getQueues()[i].getClientsHistory()[j].toString());
            }
        }
        System.out.println();

        System.out.println();
        System.out.println("-----EIGHTH CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //8
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();

        System.out.println();
        System.out.println("-----NINTH CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //9
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();
        for (int i = 0; i < QueueSystem.getQueues().length; i++) {
            for (int j = 0; j < QueueSystem.getQueues()[i].getClientsHistory().length; j++) {
                System.out.println(QueueSystem.getQueues()[i].getClientsHistory()[j].toString());
            }
        }
        System.out.println();

        System.out.println();
        System.out.println("-----TENTH CALL-----");
        QueueSystem.increaseTime();
        System.out.println("Clock:" + QueueSystem.getClock()); //10
        System.out.println();
        System.out.println("***** toString *****");
        System.out.println(queueSystem.toString());
        System.out.println();
        System.out.println("***** toString TRUE *****");
        System.out.println(queueSystem.toString(true));
        System.out.println();
        for (int i = 0; i < QueueSystem.getQueues().length; i++) {
            for (int j = 0; j < QueueSystem.getQueues()[i].getClientsHistory().length; j++) {
                System.out.println(QueueSystem.getQueues()[i].getClientsHistory()[j].toString());
            }
        }
        System.out.println();
    }
}