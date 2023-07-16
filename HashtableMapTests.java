// --== CS400 Project One File Header ==--
// Name: <JeeYoun Jung>
// CSL Username: <jeeyoun>
// Email: <jjung83@wisc.edu email address>
// Lecture #: <Lecture 002 - T/TH 1:00~ 2:15PM>
// Notes to Grader: <any optional extra notes to your grader>

import java.util.NoSuchElementException;

/**
 * This is the tester class which tests the HashTableMap
 * 
 * @author JeeYoun Jung
 */
public class HashtableMapTests {

    /**
     * tester1 tests the HashTableMap
     * 
     * @return true if the HashTableMap works well otherwise false
     */
    public static boolean test1() { 
        //create a new HashtableMap (default capacity)
        HashtableMap<Integer, Integer> tester1_hashtable = new HashtableMap<>();

        //boolean for checking exceptions
        boolean exceptionForTest1 = false;
        
        //check size and capacity of the new HashtableMap
        if(tester1_hashtable.getCapacity() != 8){
            return false;
        }

        if(tester1_hashtable.getSize() != 0){
            return false;
        }

        tester1_hashtable.put(1, 2);
        tester1_hashtable.put(10, 3);
        tester1_hashtable.put(5, 1);

        //check getsize
        if(tester1_hashtable.getSize() != 3){
            return false;
        }

        //check put exception
        try{tester1_hashtable.put(null,17);
        } catch (IllegalArgumentException e){
            exceptionForTest1 = true;
        }
        exceptionForTest1 = false;
        try{tester1_hashtable.put(10,2);
        } catch (IllegalArgumentException e){
            exceptionForTest1 = true;
        }
        exceptionForTest1 = false;

        tester1_hashtable.put(7, 5);
        tester1_hashtable.put(8, 12);

        //check containskey
        if(tester1_hashtable.containsKey(9) != false){
            return false;
        }
        if(tester1_hashtable.containsKey(7) == false){
            return false;
        }

        //check get(key) exception
        try{tester1_hashtable.get(15);
        } catch (NoSuchElementException e){
            exceptionForTest1 = true;
        }
        exceptionForTest1 = false;

        //check get(key)
        if(tester1_hashtable.get(8) != 12){
            return false;
        }

        //check rehash
        tester1_hashtable.put(3,0);
        if(tester1_hashtable.getCapacity() != 16){
            return false;
        }

        //check remove(key) exception
        try{tester1_hashtable.remove(15);
        } catch (NoSuchElementException e){
            exceptionForTest1 = true;
        }

        //check remove(key)
        if(tester1_hashtable.remove(10) != 3){
            return false;
        }

        //check clear
        tester1_hashtable.clear();

        if(tester1_hashtable.getSize() != 0){
            return false;
        }
        
        if(exceptionForTest1 == false){
            return false;
        }

        return true;
    }

    /**
     * tester2 tests the HashTableMap
     * 
     * @return true if the HashTableMap works well otherwise false
     */
    public static boolean test2() { 
        //create a new HashtableMap (default capacity)
        HashtableMap<String, Integer> tester2_hashtable = new HashtableMap<>();

        //boolean for checking exceptions
        boolean exceptionForTest2 = false;
        
        //check size and capacity of the new HashtableMap
        if(tester2_hashtable.getCapacity() != 8){
            return false;
        }
        if(tester2_hashtable.getSize() != 0){
            return false;
        }

        tester2_hashtable.put("Yang", 2);
        tester2_hashtable.put("Hae Won", 3);
        tester2_hashtable.put("Dong Won", 1);
        tester2_hashtable.put("SeungJun", 137);


        //check getsize
        if(tester2_hashtable.getSize() != 4){
            return false;
        }

        //check put exception
        try{tester2_hashtable.put(null,17);
        } catch (IllegalArgumentException e){
            exceptionForTest2 = true;
        }
        exceptionForTest2 = false;
        try{tester2_hashtable.put("Yang",2);
        } catch (IllegalArgumentException e){
            exceptionForTest2 = true;
        }
        exceptionForTest2 = false;

        //check rehash
        tester2_hashtable.put("MinChul", 5);
        tester2_hashtable.put("Jamie",0);
        if(tester2_hashtable.getCapacity() != 16){
            return false;
        }

        //check getsize
        if(tester2_hashtable.getSize() != 6){
            return false;
        }

        //check containskey
        if(tester2_hashtable.containsKey("JeeYoun") != false){
            return false;
        }
        if(tester2_hashtable.containsKey("Dong Won") == false){
            return false;
        }

        //check get(key) exception
        try{tester2_hashtable.get("SeungYeon");
        } catch (NoSuchElementException e){
            exceptionForTest2 = true;
        }
        exceptionForTest2 = false;

        //check get(key)
        if(tester2_hashtable.get("SeungJun") != 137){
            return false;
        }

        //check remove(key) exception
        try{tester2_hashtable.remove("Ki Min");
        } catch (NoSuchElementException e){
            exceptionForTest2 = true;
        }

        //check remove(key)
        if(tester2_hashtable.remove("Yang") != 2){
            return false;
        }

        //check getsize
        if(tester2_hashtable.getSize() != 5){
            return false;
        }

        //check clear
        tester2_hashtable.clear();

        if(tester2_hashtable.getSize() != 0){
            return false;
        }
        if(tester2_hashtable.getCapacity() != 16){
            return false;
        }
        
        if(exceptionForTest2 == false){
            return false;
        }

        return true;
    }

    /**
     * tester3 tests the HashTableMap
     * 
     * @return true if the HashTableMap works well otherwise false
     */
    public static boolean test3() { 
        //create a new HashtableMap (default capacity)
        HashtableMap<Integer, Double> tester3_hashtable = new HashtableMap<>(3);
        
        //check size and capacity of the new HashtableMap
        if(tester3_hashtable.getCapacity() != 3){
            return false;
        }
        if(tester3_hashtable.getSize() != 0){
            return false;
        }

        tester3_hashtable.put(2,3.22);
        if(tester3_hashtable.getSize() != 1){
            return false;
        }

        tester3_hashtable.put(4,2.76);
        tester3_hashtable.put(5, 3.22);
        if(tester3_hashtable.getCapacity() != 6){
            return false;
        }

        if(tester3_hashtable.containsKey(2) != true || tester3_hashtable.containsKey(34) != false){
            return false;
        }
        
        if(tester3_hashtable.remove(4) != 2.76){
            return false;
        }

        if(tester3_hashtable.getSize() != 2){
            return false;
        }

        tester3_hashtable.clear();
        if(tester3_hashtable.getCapacity() != 6 || tester3_hashtable.getSize() != 0){
            return false;
        }

        return true;
    }

    /**
     * tester4 tests the HashTableMap
     * 
     * @return true if the HashTableMap works well otherwise false
     */
    public static boolean test4() { 
         //create a new HashtableMap (default capacity)
         HashtableMap<String, String> tester4_hashtable = new HashtableMap<>(5);

         //boolean for checking exceptions
         boolean exceptionForTest4 = false;
        
         //check size and capacity of the new HashtableMap
         if(tester4_hashtable.getCapacity() != 5){
             return false;
         }
         if(tester4_hashtable.getSize() != 0){
             return false;
         }
 
         tester4_hashtable.put("Apple","pie");
         tester4_hashtable.put("Banana", "milk");
         if(tester4_hashtable.getSize() != 2){
             return false;
         }
 
         tester4_hashtable.put("Cherry","ice cream");
         tester4_hashtable.put("Coconut", "Juice");
         if(tester4_hashtable.getCapacity() != 10){
             return false;
         }

         try{tester4_hashtable.put("Coconut","Pie");
        } catch (IllegalArgumentException e){
            exceptionForTest4 = true;
        }
        exceptionForTest4 = false;

        //check containskey
        if(tester4_hashtable.containsKey("Pineapple") != false){
            return false;
        }
        if(tester4_hashtable.containsKey("Apple") == false){
            return false;
        }

        //check remove(key) exception
        try{tester4_hashtable.remove("Blueberry");
        } catch (NoSuchElementException e){
            exceptionForTest4 = true;
        }

        //check remove(key)
        if(tester4_hashtable.remove("Banana") != "milk"){
            return false;
        }

        return true;
    }

    /**
     * tester5 tests the HashTableMap
     * 
     * @return true if the HashTableMap works well otherwise false
     */
    public static boolean test5() {
        //create a new HashtableMap (default capacity)
        HashtableMap<Double, String> tester5_hashtable = new HashtableMap<>();
        
        //check size and capacity of the new HashtableMap
        if(tester5_hashtable.getCapacity() != 8){
            return false;
        }
        if(tester5_hashtable.getSize() != 0){
            return false;
        }

        tester5_hashtable.put(2.5, "Piano");
        tester5_hashtable.put(55.3, "Guitar");
        tester5_hashtable.put(2.019, "Drum");

        if(tester5_hashtable.containsKey(2.5) != true){
            return false;
        }

        if(tester5_hashtable.containsKey(82.22) != false){
            return  false;
        }

        tester5_hashtable.remove(55.3);
        if(tester5_hashtable.getSize() != 2){
            return false;
        }

        if(tester5_hashtable.getCapacity() != 8){
            return false;
        }

        tester5_hashtable.clear();

        if(tester5_hashtable.getSize() != 0){
            return false;
        }


        return true;
    }

    /**
     * Main method for testing all testers are working well
     * 
     * @return true if all testers work well otherwise false
     */
    public static void main(String[] args) {
        System.out.println("Test 1 passed: " + test1());
        System.out.println("Test 2 passed: " + test2());
        System.out.println("Test 3 passed: " + test3());
        System.out.println("Test 4 passed: " + test4());
        System.out.println("Test 5 passed: " + test5());
    }
}
