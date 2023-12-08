public class InMemoryDBTest {
    public static void main(String[] args) {

        System.out.println("test initial db");
        System.out.println("------------------------------------------------------");
        InMemoryDB inMemoryDB = new InMemoryDB();
        System.out.println("DB should be empty");
        System.out.println("Calling get on user1: " + inMemoryDB.get("user1") + "\n"); //should be null

        System.out.println("test put and get");
        System.out.println("------------------------------------------------------");
        System.out.println("Starting transaction");
        inMemoryDB.begin_transaction();
        System.out.println("Calling put on user1");
        inMemoryDB.put("user1", 1234);
        System.out.println("Calling get on user1 before commit: " +
                inMemoryDB.get("user1")); //should be null
        inMemoryDB.commit();

        System.out.println("Calling get on user1 after commit: " +
                inMemoryDB.get("user1") + "\n");

        System.out.println("test rollback");
        System.out.println("------------------------------------------------------");
        System.out.println("Starting new transaction");
        inMemoryDB.begin_transaction();
        System.out.println("Calling put on user2");
        inMemoryDB.put("user2", 5678);
        System.out.println("Calling rollback");
        inMemoryDB.rollback();
        System.out.println("Calling get on get on user2: " + inMemoryDB.get("user2") + "\n"); //should be null

        System.out.println("test invalid put");
        System.out.println("------------------------------------------------------");
        System.out.println("Calling put on user3 outside of transaction");
        try {
            inMemoryDB.put("user3", 4321);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}