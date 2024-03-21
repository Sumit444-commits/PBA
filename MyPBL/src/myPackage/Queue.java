package myPackage;

public class Queue {
    LinkedList ll = null;
    Node head;
    Node tail;

    public Queue(LinkedList ll) {
        this.ll = ll;
    }

    private boolean isEmpty() {
        return head==null;
       }

    public void enqueue(State s) {
        Node newNode = new Node(s);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void sort(){
        State[] dummy = new State[10000];
        int currentIndex =0;
        LinkedList temp =ll; 
        while(temp.getHead()!=null){
            dummy[currentIndex++] = temp.getHead().data;
             temp.setHead(temp.getHead().next);
        }

        for(int i=0;i<currentIndex-1;i++){
            for(int j=0;j<currentIndex-1-i;j++){
                if(dummy[j].year>dummy[j+1].year){
                    State s = dummy[j];
                    dummy[j] = dummy[j+1];
                    dummy[j+1] = s;
                }
            }
        }
        for(int i=0;i<currentIndex-1;i++){
            enqueue(dummy[i]);
        }
        
    }
    
    public String RecentCrop(){
        return " Crop Name : "+tail.data.crop+", Year "+tail.data.year;
    }
    
    public String OldestCrop(){
        return " Crop Name : "+head.data.crop+", Year "+head.data.year;
    }
    public void printQueue(){
        Node temp = head;
        while (temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    
}
