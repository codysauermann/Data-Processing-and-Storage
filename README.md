# Data-Processing-and-Storage

## Instructions
To use the InMemoryDB.java, import InMemoryDB.java (if necessary), and create a new InMemoryDB object within your code.
- begin_transaction() starts a new transaction.
- put(key, val) will create a new key with the provided value if a key doesn’t exist. Otherwise it will update the value of an existing key.
- get(key) will return the value associated with the key or null if the key doesn’t exist.
- commit() applies changes made within the transaction to the main state.
- rollback() aborts all the changes made within the transaction.

## Included Test
The included test file demonstrates the functionality of each function.

## Assignment modifications
Before making this assignment official, I would possibly add a remove(String key) method to to the specification. The remove(String key) method would remove a key from the DB. I would also add some clarification on the grading criteria for working code. Fig 1 is of an interface and I was unsure if I was to create the interface and a class that implements it or just a class version of the provided interface.