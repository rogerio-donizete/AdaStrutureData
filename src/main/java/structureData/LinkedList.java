package structureData;

public class LinkedList {

    private Node head;
    private Node tail;
    private int lenght;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
        }
    }
    public  LinkedList(String data){
        lenght=1;
        Node newNode = new Node(data);
        head=newNode;
        tail=newNode;
    }
    public void getTail(){
        if(tail==null){
            System.out.println("Lista vazia");
        }else{
            System.out.println("tail: " + tail.data);
        }

    }
    public void getHead(){if(head==null){
        System.out.println("Lista vazia");
    }else{
        System.out.println("Head: " + head.data);
        }
    }
    public  void getLenght(){
        System.out.println("Lenght: " + this.lenght);
    }

    public void makeEmpty(){
        tail =null;
        head=null;
        lenght=0;
    }

    public void print(){
        System.out.println("###########################");
        Node temp = this.head;
        while (temp != null){
            System.out.println(temp.data);
            temp=temp.next;
        }
        System.out.println("###########################");
    }

    public void append(String data){
        Node newNode = new Node(data);
        if(lenght==0){
            head=newNode;
            tail=newNode;
        }else {
            tail.next=newNode;
            tail=newNode;
        }
        lenght++;
    }

    public Node removeLast() {
        if (lenght == 0) return null;
        Node pre = head;
        Node temp = null;
        while (pre.next != tail) {
            pre = pre.next;
        }
        temp = tail;
        tail = pre;
        tail.next=null;
        lenght--;
        if(lenght==0){
            head=null;
            tail=null;
        }
        return temp;
    }

    public void prepend(String data){
        Node newNode= new Node(data);
        if(lenght==0){
            head=newNode;
            tail=newNode;
        }else{
           newNode.next=head;
           head=newNode;
        }
        lenght++;
    }

    public Node removeFirst(){
        if(lenght==0)return null;
        Node temp = head;
        head=head.next;
        temp.next = null;
        lenght--;
        if(lenght == 0){
            head=null;
            tail=null;
        }
        return temp;
    }

    public Node get(int index){
        if(index<0 || index >= lenght) return null;
         Node temp = head;
         for(int i = 0; i<index;i++){
             temp = temp.next;
         }
         return temp;
    }
    public boolean insert(int index, String data){
        if(index<0 || index >= lenght) return false;
        if(index==0){ prepend(data);return true;}
        if(index == lenght){append(data);return true;}

        Node newNode = new Node(data);
        Node temp = get(index-1);
        newNode.next= temp.next;
        temp.next=newNode;
        lenght++;
        return true;
    }

    public boolean set(int index, String data){
        if(index<0 || index >= lenght) return false;
        Node temp = get(index);
        temp.data = data;
        return true;
    }

    public Node remove(int index){
        if(index<0 || index >= lenght) return null;
        if(index==0)return removeFirst();
        if(index==lenght-1) return removeLast();
        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next =null;
        lenght--;
        return temp;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList("Elemento 1");
        list.append("Elemento 2");
        list.append("Elemento 3");
        list.getHead();
        list.getTail();
        list.getLenght();
        list.print();
        System.out.println(list.removeLast().data);
        list.print();
        list.prepend("Elemento 0");
        list.print();
        System.out.println(list.removeFirst().data);
        list.print();
        list.getLenght();
        list.getHead();
        list.getTail();
        list.append("Elemento 3");
        list.append("Elemento 4");
        System.out.println(list.get(3).data);
        list.insert(3, "Elemnto 3.5");
        list.print();
        list.set(3, "Elemnto 4");
        list.set(4, "Elemnto 5");
        list.print();
        System.out.println(list.remove(2).data);
        list.print();
    }

}
