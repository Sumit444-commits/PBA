package myPackage;

import java.sql.*;

public class Main {
    static int count = 0;

    public static String[] getStates() {
        String stateName[] = new String[50];
        try {

            Connection conn = DB.dbConnect();
            String query = Querry.getStates();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                stateName[count++] = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stateName;
    }

    public static void main(String[] args) {

// Q1 Make linkedlists, one for each state containing district, crop and year data.
        String[] st = getStates();
        LinkedList[] ll = new LinkedList[count];
        for (int i = 0; i < count; i++) {
            ll[i] = new LinkedList(st[i]);
            ll[i].insertStateData();
        }

        // ll[1].printLinkedList();
        // end of question 1

        /*
         * Q2 Make a stack containing count of same crops with crop name for each state
         * using Step 1. The crop
         * with higher count sits at the bottom where as crop with lower count sits at
         * the top.
         */

        for (int i = 0; i < count; i++) {
            ll[i].CountAndInsertSTACK();
            ll[i].StackInsert();
        }
        // System.out.println("\n Print the stack\n");
        // ll[1].printStack();
        
        // End of Q2
        System.out.println();
        // Q3 Make queue for ‘Andhra Pradesh’ state and keep crop data based on year column.
        Queue Andhra_Prades = new Queue(ll[1]);
        Andhra_Prades.sort();
        
        // Andhra_Prades.printQueue();

        // End of Q3

        // Problem 1: How to find the most popular crop in a particular year. 
        ll[0].popularCrop(2005);
        System.out.println();

        // Problem 2: Which state is popular for which type of crop? 

        System.out.println(ll[5].PopularCrop());


        System.out.println("Oldest crop in Andhra Pradesh is " + Andhra_Prades.OldestCrop());
        System.out.println("Recent crop in Andhra Pradesh is " + Andhra_Prades.RecentCrop());

    }
}
