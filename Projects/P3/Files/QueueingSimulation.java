public class QueueingSimulation {

	public static void main(String[] arg) {

		{
			// Before the test
			QueueSystem.setClock(0);
			QueueSystem.setQueues(null);

			// Create the system objects for Test01
			Client client1 = new Client("John1", "Peter1", 1977, "MALE", 1, 50, null);
			String[] items1 = { "Q1" };
			InformationRequest r11 = new InformationRequest("IR1", 5, 5, items1);
			Request[] rList1 = { r11 };
			client1.setRequests(rList1);
			Queue q1 = new Queue("Noah", 2);
			QueueSystem qS = new QueueSystem(1, false, false);
			QueueSystem.setQueues(new Queue[1]);
			Client[] clientsInWorld = new Client[1];
			clientsInWorld[0] = client1;
			QueueSystem.setClientsWorld(clientsInWorld);
			QueueSystem.getQueues()[0] = q1;
			
			
			System.out.println("-- TEST 1 --");
			System.out.println(QueueSystem.getClock());
			//0
			System.out.println(q1.toString());
			//[Queue:1][  ]-----[  ][  ]
			System.out.println(q1.toString(false));
			//[Queue:1][  ]-----[  ][  ]
		}

		{
			// Before the test
			QueueSystem.setClock(0);
			QueueSystem.setQueues(null);
			
			// Create the system objects for Test02
			Client client1 = new Client("John1", "Peter1", 1977, "MALE", 1, 50, null);
			String[] items1 = { "Q1" };
			InformationRequest r11 = new InformationRequest("IR1", 5, 5, items1);
			Request[] rList1 = { r11 };
			client1.setRequests(rList1);
			Queue q1 = new Queue("Noah", 2);
			QueueSystem qS = new QueueSystem(1, false, false);
			QueueSystem.setQueues(new Queue[1]);
			Client[] clientsInWorld = new Client[1];
			clientsInWorld[0] = client1;
			QueueSystem.setClientsWorld(clientsInWorld);
			QueueSystem.getQueues()[0] = q1;

			//Simulation
			qS.increaseTime();

			System.out.println("-- TEST 2 --");

			System.out.println(QueueSystem.getClock());
			//1
			System.out.println(q1.toString());
			//[Queue:1][02]-----[  ][  ]
			System.out.println(q1.toString(false));
			//[Queue:1][05]-----[  ][  ]

		}

		{
			// Before the test
			QueueSystem.setClock(0);
			QueueSystem.setQueues(null);
			
			// Create the system objects for Test03
			Client client1 = new Client("John1", "Peter1", 1977, "MALE", 1, 50, null);
			String[] items1 = { "Q1" };
			InformationRequest r11 = new InformationRequest("IR1", 5, 5, items1);
			Request[] rList1 = { r11 };
			client1.setRequests(rList1);
			Queue q1 = new Queue("Noah", 2);
			QueueSystem qS = new QueueSystem(1, false, false);
			qS.setQueues(new Queue[1]);
			Client[] clientsInWorld = new Client[1];
			clientsInWorld[0] = client1;
			QueueSystem.setClientsWorld(clientsInWorld);
			qS.getQueues()[0] = q1;

			//Simulation
			qS.increaseTime();
			qS.increaseTime();

			System.out.println("-- TEST 3 --");

			System.out.println(QueueSystem.getClock());
			//2
			System.out.println(q1.toString());
			//[Queue:1][03]-----[  ][  ]
			System.out.println(q1.toString(false));
			//[Queue:1][04]-----[  ][  ]
		}

		{
			// Before the test
			QueueSystem.setClock(0);
			QueueSystem.setQueues(null);
			
			// Create the system objects for Test04
			Client client1 = new Client("John1", "Peter1", 1977, "MALE", 1, 50, null);
			String[] items1 = { "Q1" };
			InformationRequest r11 = new InformationRequest("IR1", 5, 5, items1);
			Request[] rList1 = { r11 };
			client1.setRequests(rList1);
			Queue q1 = new Queue("Noah", 2);
			QueueSystem qS = new QueueSystem(1, false, false);
			qS.setQueues(new Queue[1]);
			Client[] clientsInWorld = new Client[1];
			clientsInWorld[0] = client1;
			QueueSystem.setClientsWorld(clientsInWorld);
			qS.getQueues()[0] = q1;

			//Simulation
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();

			System.out.println("-- TEST 4 --");

			System.out.println(QueueSystem.getClock());
			//3
			System.out.println(q1.toString());
			//[Queue:1][04]-----[  ][  ]
			System.out.println(q1.toString(false));
			//[Queue:1][03]-----[  ][  ]
		}

		{
			/// Before the test
			QueueSystem.setClock(0);
			QueueSystem.setQueues(null);

			// Create the system objects for Test05
			Client client1 = new Client("John1", "Peter1", 1977, "MALE", 1, 50, null);
			String[] items1 = { "Q1" };
			InformationRequest r11 = new InformationRequest("IR1", 5, 5, items1);
			Request[] rList1 = { r11 };
			client1.setRequests(rList1);
			Queue q1 = new Queue("Noah", 2);
			QueueSystem qS = new QueueSystem(1, false, false);
			qS.setQueues(new Queue[1]);
			Client[] clientsInWorld = new Client[1];
			clientsInWorld[0] = client1;
			QueueSystem.setClientsWorld(clientsInWorld);
			qS.getQueues()[0] = q1;

			//Simulation
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();

			System.out.println("-- TEST 5 --");
			System.out.println(QueueSystem.getClock());
			//4
			System.out.println(q1.toString());
			//[Queue:1][05]-----[  ][  ]
			System.out.println(q1.toString(false));
			//[Queue:1][02]-----[  ][  ]
		}

		{
			// Before the test
			QueueSystem.setClock(0);
			QueueSystem.setQueues(null);
			
			// Create the system objects for Test06
			Client client1 = new Client("John1", "Peter1", 1977, "MALE", 1, 50, null);
			String[] items1 = { "Q1" };
			InformationRequest r11 = new InformationRequest("IR1", 5, 5, items1);
			Request[] rList1 = { r11 };
			client1.setRequests(rList1);
			Queue q1 = new Queue("Noah", 2);
			QueueSystem qS = new QueueSystem(1, false, false);
			qS.setQueues(new Queue[1]);
			Client[] clientsInWorld = new Client[1];
			clientsInWorld[0] = client1;
			QueueSystem.setClientsWorld(clientsInWorld);
			qS.getQueues()[0] = q1;

			//Simulation
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();

			System.out.println("-- TEST 6 --");
			System.out.println(QueueSystem.getClock());
			//5
			System.out.println(q1.toString());
			//[Queue:1][06]-----[  ][  ]
			System.out.println(q1.toString(false));
			//[Queue:1][01]-----[  ][  ]
		}

		{
			// Before the test
			QueueSystem.setClock(0);
			QueueSystem.setQueues(null);

			// Create the system objects for Test07
			Client client1 = new Client("John1", "Peter1", 1977, "MALE", 1, 50, null);
			String[] items1 = { "Q1" };
			InformationRequest r11 = new InformationRequest("IR1", 5, 5, items1);
			Request[] rList1 = { r11 };
			client1.setRequests(rList1);
			Queue q1 = new Queue("Noah", 2);
			QueueSystem qS = new QueueSystem(1, false, false);
			qS.setQueues(new Queue[1]);
			Client[] clientsInWorld = new Client[1];
			clientsInWorld[0] = client1;
			QueueSystem.setClientsWorld(clientsInWorld);
			qS.getQueues()[0] = q1;

			//Simulation
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();
			qS.increaseTime();

			System.out.println("-- TEST 7 --");
			System.out.println(QueueSystem.getClock());
			//6
			System.out.println(q1.toString());
			//[Queue:1][  ]-----[  ][  ]
			System.out.println(q1.toString(false));
			//[Queue:1][  ]-----[  ][  ]
		}
	}
}