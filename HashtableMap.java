// --== CS400 Project One File Header ==--
// Name: <JeeYoun Jung>
// CSL Username: <jeeyoun>
// Email: <jjung83@wisc.edu email address>
// Lecture #: <Lecture 002 - T/TH 1:00~ 2:15PM>
// Notes to Grader: <any optional extra notes to your grader>

import java.util.NoSuchElementException;

/**
 * This class is a implementation of the MapADT
 * On this class we will create a new HashTable and initialize it with the specified values
 * 
 * @author JeeYoun Jung
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

    /**
     * This is a helper class of the HashTable class
     * It will group key types and values types
     * 
     * @author JeeYoun Jung
     */
    // Hash node to group key-value pairs
    public class HashNode<KeyType, ValueType> {
        public KeyType key;
        public ValueType value;

        /**
         *  Constructor of the HashNode class
         * 
         * @param key - the key type of the HashNode
         * @param value - the value type of the HashNode
         */
        public HashNode(KeyType key, ValueType value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;   // The capacity of the hash table
    private int size = 0;   // number of elements in the Hashtable
    protected HashNode<KeyType, ValueType>[] table;  // the hash table

    /**
     * Constructor when capacity is specified
     * 
     * @param capacity - Capacity of the HashtableMap (can be vary)
     */
    @SuppressWarnings("unchecked")
    public HashtableMap(int capacity) {
        this.capacity = capacity;
        table = new HashNode[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
    }

    /**
     * Constructor when capacity is not specified
     * Capacity always be 8 for default value
     */
    @SuppressWarnings("unchecked")
    public HashtableMap() { // with default capacity = 8
        this.capacity = 8;
        table = new HashNode[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
    }

    /**
     * If load factor >= 70%, then Double capacity and rehash
     */
    private void rehash() {
        int newCap = capacity * 2;
        boolean success = false;
        HashNode<KeyType, ValueType>[] newTable = new HashNode[newCap];

        for (int i = 0; i < table.length; i++) {
            // Check if current index is empty
            if (table[i] == null) {
                continue;
            }

            // Get index of current node
            int index = Math.abs(table[i].key.hashCode()) % newCap;
            
            // Check if location in the table from index to the end is empty
            for (int j = index; j < newTable.length; j++) {
                if (newTable[j] == null) {
                    newTable[j] = table[i];
                    success = true;
                    break;
                }
            }
            // Check if location in the table from beginning to the index is empty
            if (!success) {
                for (int j = 0; j < index; j++) {
                    if (newTable[j] == null) {
                        newTable[j] = table[i];
                        break;
                    }
                }
            }

            success = false;
        }

        // Reassign the table
        table = newTable;
        capacity = newCap;
    }

    /**
     * add a new key-value pair/mapping to this collection
     * 
     * @param key - the key type of the HashNode
     * @param value - the value type of the HashNode
     * @throws IllegalArgumentException - throws exception when key is null or duplicate of one already stored
     */
    @Override
    public void put(KeyType key, ValueType value) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (containsKey(key)) {
            throw new IllegalArgumentException("Key already exists");
        }

        // Check for rehashing condition
        if ((double)size / capacity >= 0.7) {
            rehash();
        }

        int index = Math.abs(key.hashCode()) % capacity;
        boolean success = false;

        // Check if location in the table from index to the end is empty
        for (int i = index; i < capacity; i++) {
            if (table[i] == null) {
                table[i] = new HashNode<KeyType, ValueType>(key, value);
                success = true;
                break;
            }
        }

        // Check if location in the table from beginning to the index is empty
        if (!success) {
            for (int i = 0; i < index; i++) {
                if (table[i] == null) {
                    table[i] = new HashNode<KeyType, ValueType>(key, value);
                    break;
                }
            }
        }

        this.size++;

        // Check for rehashing condition
        if ((double)size / capacity >= 0.7) {
            rehash();
        }
    }

    /**
     * check whether a key maps to a value within this collection
     * 
     * @param key - the key type of the HashNode
     * @return true if the key is in the table otherwise false
     */
    @Override
    public boolean containsKey(KeyType key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * retrieve the specific value that a key maps to
     * 
     * @param key - the key type of the HashNode
     * @return return the value of the key otherwise return null
     * @throws NoSuchElementException - throws exception when key is not stored in this collection
     */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        if (containsKey(key) == false) {
            throw new NoSuchElementException("Key not found");
        }
        for(int i = 0 ; i < table.length; i++) {
            if(table[i] != null && key.equals(table[i].key)) {
                return table[i].value;
            }
        }
        return null;
    }

    /**
     * remove the mapping for a given key from this collection
     * @param key - the key type of the HashNode
     * @return return the value of the removed key type
     * @throws NoSuchElementException - throws exception when key is not stored in this collection
     */
    @Override
    public ValueType remove(KeyType key) throws NoSuchElementException {
        if (containsKey(key) == false) {
            throw new NoSuchElementException("Key not found");
        }
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null && table[i].key.equals(key)) {
                ValueType curValue = table[i].value;
                table[i] = null;
                size --;
                return curValue;
            } else {
                continue;
            }
        }
        return null;
    }

    /**
     * remove all key-value pairs from this collection
     */
    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i< table.length; i++){
            table[i] = null;
        }
    }

    /**
     * retrieve the number of keys stored within this collection
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * retrieve this collection's capacity (size of its underlying array)
     */
    @Override
    public int getCapacity() {
        return this.capacity;
    }
}