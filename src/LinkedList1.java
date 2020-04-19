import java.util.*;
public class LinkedList1{
        private Skull head;
        private int numberEyes;
        public LinkedList1(Object bone ){
            this.head = new Skull(bone);
        }
        private class Skull{
            Skull next;
            Object bone;
            public Skull(Object bone){
                this.bone = bone;
            }
            public Object getBone(){
                return this.bone;
            }
        }
        public void addFirst(Object bone){
            Skull hat = head;
            head = new Skull(bone);
            head.next = hat;
            numberEyes++;
        }
        public void addLast(Object bone){
            Skull hat = head;
            for (int i = 0; i <= numberEyes -1  ; i++) {
                hat = hat.next;
            }
            hat.next = new Skull(bone);
            numberEyes++;
        }
        public  void  add(int where,Object bone){
            Skull hat = head;
            Skull bucket ;
            for (int i = 0; i < where -1 && hat.next != null ; i++) {
                hat = hat.next;
            }
            bucket = hat.next;
            hat.next =  new Skull(bone);
            hat.next.next = bucket;

        }
        public Object getIndex(int index){
            Skull hat = head;
            for (int i = 0; i < index ; i++) {
                hat = hat.next;
            }
            return hat.bone;
        }
        public int ofIndex(Object what){
            int count = 0 ;
            Skull hat = head;
            if( hat.bone == what)
                return count;
            for (int i = 0; i <= numberEyes ; i++) {
                hat = hat.next;
                count++;
                if(hat.bone == what)
                    return count;
            }
            return count -1;
        }
        public boolean isContain(Object what){
            Skull hat = head;
            if( hat.bone == what)
                return true;
            for (int i = 0; i <= numberEyes ; i++) {
                hat = hat.next;
                if(hat.bone == what)
                    return true;
            }
            return false;
        }
        public void remove(Object what){
            Skull hat = head;
            Object bucket;
            int count=0;
            for (int i = 0 ; i <= numberEyes ; i++) {
                count++;
                if( hat.next.bone == what ) {
                    break;
                }
                hat = hat.next;
            }
            hat.next = hat.next.next;
            for (int j = count; j <= numberEyes ; j++) {
                hat = hat.next;
            }

        }
        public void print(){
            Skull hat = head;
            while (hat!=null){
                System.out.println(hat.bone);
                hat = hat.next;
            }
        }

    public static void main(String[] args) {
        LinkedList1 myLiked = new LinkedList1(3);
        myLiked.addFirst(2);
        myLiked.addFirst(1);
        myLiked.addFirst(0);
        myLiked.addLast(0);
        myLiked.remove(0);
        myLiked.print();
    }
    }