/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsetex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author dell
 */
public class Hashsetex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Set<String> mySet1 = new HashSet<String>();
        // We add a few elements
        mySet1.add("A");
        mySet1.add("C");
        mySet1.add("B");
        mySet1.add("A");
        
        System.out.println("mySet1: " + mySet1);
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("C");
        list.add("A");
        list.add("A");
        list.add("B");
        list.add("C");
        
        Set<String> mySet2 = new HashSet<String>(list);
        
        System.out.println("list: " + list);
        System.out.println("mySet2: " + mySet2);
 

        System.out.println("MySet1 matches mySet2: " + mySet1.equals(mySet2));
 
        
        mySet2.remove("A");
        System.out.println("mySet2: " + mySet2);
        System.out.println("MySet1 matches mySet2: " + mySet1.equals(mySet2));
        
        System.out.println("MySet1 contains all the elements: " + mySet1.containsAll(list));
        System.out.println("MySet2 contains all the elements: " + mySet2.containsAll(list));
 

        Iterator<String> iterator = mySet1.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator loop: " + iterator.next());
        }
 

        for (String str : mySet1) {
            System.out.println("for-each loop: " + str);
        }
 

        mySet1.clear();
        System.out.println("mySet1 is Empty: " + mySet1.isEmpty());
 

        System.out.println("mySet1 has: " + mySet1.size() + " Elements");
        System.out.println("mySet2 has: " + mySet2.size() + " Elements");
 

        String[] array = mySet2.toArray(new String[mySet2.size()]);
        System.out.println("The array:" + Arrays.toString(array));
    }
}
    }
    
}
