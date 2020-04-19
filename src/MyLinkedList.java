public class MyLinkedList {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data){
        head = new Node(data);
    }
    private class Node{
        private Node next;
        private Object data;
        public Node(Object data){
            this.data = data;
        }
        public Object getData(){
            return this.data;
        }
        public void add(int index, Object element ){
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
    }

}
