package myPackage;

import java.sql.*;
import java.util.Stack;

public class LinkedList {
   private String stateName;
   private Node head = null;
   private Crop[] cropCount = new Crop[300];
   private int currentIndex =0;
   private Stack<Crop> CropStack = new Stack<>();

    public LinkedList() {}

    public LinkedList(String stateName) {
        this.stateName = stateName;
    }

    public void insert(State s) {
        if (head == null) {
            head = new Node(s);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(s);
        }
    }

    public void insertStateData() {
        try {
            Connection conn = DB.dbConnect();
            String query = Querry.getData(stateName);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                State s = new State(rs.getString(1), rs.getString(2), rs.getInt(3));
                this.insert(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void StackInsert(){
        for(int i=0;i<currentIndex-1;i++){
            for(int j=0;j<currentIndex-1-i;j++){
                if (cropCount[j].count<cropCount[j+1].count) {
                    Crop c = cropCount[j];
                    cropCount[j] = cropCount[j+1];
                    cropCount[j+1] = c;
                }
            }
        }
        for(int i=0;i<currentIndex;i++){
            CropStack.push(cropCount[i]);
        }
      
    }
   
    public void calculateCropCount(Crop c) {
        String cpName = c.cropName;
        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (cropCount[i] != null && cropCount[i].cropName.equals(cpName)) {
                cropCount[i].count++;
                found = true;
                break;
            }
        }
        if (!found) {
            cropCount[currentIndex] = new Crop(cpName, 1);
            currentIndex++;
        }
    }

    public void CountAndInsertSTACK(){
        Node temp = head;
        while(temp!=null){
            calculateCropCount(new Crop(temp.data.crop, 1));
            temp=temp.next;
        }
        StackInsert();
    }

    public void popularCrop(int year){
        Node current = head;
        int count1 = 0;
        String popularCropName = "";
        while(current!=null){
        if (current.data.year==year) {
            Node temp = current.next;
            int count2 =1;
            while (temp!=null) {
                if (temp.data.getYear()==year && temp.data.getCrop().equals(current.data.getCrop())) {
                    count2++;
                }
                temp = temp.next;
            }
            if (count2>count1) {
                count1 = count2;
                popularCropName = current.data.getCrop();
            }
        }
        current = current.next;
    }
    System.out.println("\n\n The Popular crop in year "+year+" is "+popularCropName+" with occurance of "+count1+" in State : "+stateName);
    }

    public void printLinkedList() {
        System.out.println("State Name : " + this.stateName);
        System.out.println();
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    public void printStack(){
     for (Crop crop : CropStack) {
          System.out.println("Crop Name : "+crop.cropName+" , total crops : "+crop.count);
     }
    }

    public String PopularCrop(){
        return "State Name : "+stateName+", Crop : "+CropStack.peek().cropName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Crop[] getCropCount() {
        return cropCount;
    }

    public void setCropCount(Crop[] cropCount) {
        this.cropCount = cropCount;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Stack<Crop> getCropStack() {
        return CropStack;
    }

    public void setCropStack(Stack<Crop> cropStack) {
        CropStack = cropStack;
    }

}
