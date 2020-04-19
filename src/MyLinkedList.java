public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes = 0;

    public MyLinkedList(E data){
        head = new Node(data);
        tail = head;
        numNodes++;
    }
    public MyLinkedList(){

    }
    private class Node{
        private Node next;
        private E data;
        public Node(E data){
            this.data = data;
        }
        public E getData(){
            return this.data;
        }
    }
    public void add(int index, E element ){
        Node temp = head;
        Node holder;
        for( int i=0; i< index - 1 && temp.next != null; i++){
            temp = temp.next;
        }
        //lưu giá trị trỏ của node index-1 tới node index
        holder = temp.next;
        //tạo node mới , liên kết của index-1 trỏ đến node mới
        temp.next = new Node(element);
        // vị trí trỏ đến của nút mới được tạo chính là con trỏ của index-1 tới index cũ
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst( E element){
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        // có cần thiết ko?
        if(newNode.next == null){
            tail = newNode;
        }
            numNodes++;
    }
    public void addLast(E element){
        Node newNode = new Node(element);
        tail.next = newNode;
        tail = tail.next;
        numNodes++;
    }
    public void remove(int index){
        Node previous = head;
        for( int i=0; i< index-1; i++ ){
            previous = previous.next;
        }
        Node current = previous.next;
        previous.next = current.next;
        numNodes--;
    }
    // mới chỉ xóa được 1 phần tử
    public void remoteElement(E element){
        Node previous = head;
        if(previous.data == element){
            head = previous.next;
        }
        else{
            for( int i=0; i< numNodes; i++ ){
                previous = previous.next;
                if( previous.next.data == element) {
                    break;
                }
            }
        }
        Node current = previous.next;
        previous.next = current.next;
        numNodes--;
    }
    public E get(int index){
        Node current = head;
        if( index == 0){
            return current.data;
        }
        for(int i=0; i< index-1; i++){
            current = current.next;
        }
        return current.next.data;
    }
    public int getSize(){
        return numNodes;
    }
    public MyLinkedList<E> clone(){
        MyLinkedList<E> cloneList = new MyLinkedList<>();
        Node current = head;
        cloneList.addFirst(current.data);
        for( int i=0; i<numNodes-1; i++){
            current = current.next;
            cloneList.addLast(current.data);
        }
        return cloneList;
    }
    public boolean Contains(E element){
        boolean isContains = false;
        Node previous = head;
        if(previous.data == element){
            isContains = true;
        }
        else {
           for( int i=1; i< numNodes-1; i++){
               previous = previous.next;
               if(previous.next.data == element){
                   isContains = true;
               }
           }
        }
        return isContains;
    }
    public int indexOf(E element){
        int index = -1;
        Node previous = head;
        if( previous.data == element){
            return 0;
        }
        for( int i=1; i< numNodes; i++){
            previous = previous.next;
            if(previous.data == element ){
                index = i;
                break;
            }
        }
        return index;
    }
    public void print(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLiked = new MyLinkedList<>(3);

        myLiked.addFirst(2);
        myLiked.addFirst(1);
        myLiked.addFirst(-1);
        myLiked.addLast(0);
        myLiked.remove(1);
        myLiked.remoteElement(0);

        MyLinkedList<Integer> clone = myLiked.clone();
        clone.print();

        System.out.println("Value of element:" +  myLiked.get(0));
        System.out.println("Index of element:" +  myLiked.indexOf(3));
        System.out.println("Size of array:" +  myLiked.getSize());
        System.out.println(        myLiked.Contains(5));
        System.out.println(        myLiked.Contains(2));

        myLiked.print();
    }


}
