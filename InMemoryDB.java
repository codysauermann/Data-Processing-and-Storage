import java.util.HashMap;
import java.util.Map;

public class InMemoryDB {
    private Map<String, Integer> db;

    private Map<String,Integer> tempTransactionDB;
    private boolean inTransaction;

    InMemoryDB() {
        db = new HashMap<>();
        inTransaction = false;
    }
    Object get(String key) {
        return db.get(key);
    }

    void put(String key, int val) {
        if(inTransaction) {
            tempTransactionDB.put(key, val);
        }
        else {
            throw new RuntimeException("No transaction active");
        }
    }

    void begin_transaction(){
        if(!inTransaction) {
            inTransaction = true;
            tempTransactionDB = new HashMap<>(db);
        }
    }

    void commit() {
        db = tempTransactionDB;
        inTransaction = false;
    }

    void rollback(){
        tempTransactionDB = new HashMap<>();
        inTransaction = false;
    }

}
