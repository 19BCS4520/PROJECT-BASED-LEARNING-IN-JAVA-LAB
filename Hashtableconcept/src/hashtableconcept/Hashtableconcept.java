/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hashtableconcept;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author dell
 */
public class Hashtableconcept {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hashtable h1=new HashTable();
        h1.put(67,"Rahul");
        h1.put(98,"asdftth");
        h1.put(99,"adfhug");
        h1.put(97,"ytcbno");
        Enumeration e=h1.keys();
        while(e.hasMoreElements()){
        System.out.println(e.nextElement());
        }
    }
    
}
