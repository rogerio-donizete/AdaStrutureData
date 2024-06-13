package structureData;

public class Queue {
    private Node first;
    private Node last;
    private int lenght;

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        lenght++;
    }

    public void getFirst(){
        if(first != null){
            System.out.println("First: " + first.value);
        }else{
            System.out.println("Fila está vazia!");
        }
    }

    public void getLast(){
        if(last != null){
            System.out.println("Last: " + last.value);
        }else{
            System.out.println("Fila está vazia!");
        }
    }

    public void getLenght(){
        System.out.println("Lenght: " + lenght);
    }

    public void print(){
        System.out.println("##################################");
        Node temp = first;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("##################################");
    }


    public void enqueue(int value){
        Node newNode = new Node(value);
        if(lenght == 0){
            first=newNode;
            last=newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        lenght++;
    }

    public Node dequeue(){
        if(lenght==0){
            return null;
        }
        Node temp = first;
        if(lenght==1){
            first=null;
            last=null;
        }else{
            first=first.next;
            temp.next=null;
        }
        lenght--;
        return temp;
    }


    public static void main(String[] args) {
        Queue queue = new Queue(1);
        queue.enqueue(2);
        queue.enqueue(5);

        queue.getFirst();
        queue.getLast();
        queue.getLenght();
        queue.print();

        queue.dequeue();

        queue.getFirst();
        queue.getLast();
        queue.getLenght();
        queue.print();

    }
}
