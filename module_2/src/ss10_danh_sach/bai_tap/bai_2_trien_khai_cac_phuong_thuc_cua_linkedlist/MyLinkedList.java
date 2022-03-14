package ss10_danh_sach.bai_tap.bai_2_trien_khai_cac_phuong_thuc_cua_linkedlist;

public class MyLinkedList<E> {
    public class Node{
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
        public Object getData(){
            return this.data;
        }
    }
    private Node head;
    private int numNodes=0;

    public MyLinkedList() {
    }
    public void addFirst(E element){
        Node temp= head;
        head=new Node(element);
        head.next=temp;
        numNodes++;
    }
    public void addLast(E element){
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(element);
        numNodes++;
    }
    public void add(int index,E element){
        Node temp=head;
        Node hoder;
        for (int i=0;i<index-1 && temp.next!=null;i++){
            temp= temp.next;
        }
        hoder=temp.next;
        temp.next=new Node(element);
        temp.next.next=hoder;
        numNodes++;
    }
    public Object get(int index){
        Node temp=head;
        for (int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    public int size(){
        return numNodes;
    }
    public E remove(int index){
        if (index<0 ||index>numNodes){
            throw new IllegalArgumentException("index: "+index);
        }
        Node temp=head;
        Object data;
        if (index==0){
            data=temp.data;
            head=head.next;
        }else {
            for (int i=0;i<index-1 && temp.next!=null;i++){
                temp=temp.next;
            }
            data=temp.next.data;
            temp.next=temp.next.next;
            numNodes--;
        }
        return (E) data;
    }
    public boolean remove(E element){
        if(head.data.equals(element)){
            remove(0);
        }else {
            Node temp=head;
            while (temp.next!=null){
                if (temp.next.data.equals(element)){
                    temp.next=temp.next.next;
                    return true;
                }
                temp=temp.next;
            }
        }
        return false;
    }
    public MyLinkedList<E> clone(){
        if (numNodes==0){
            throw new IllegalArgumentException("LinkedList này null ");
        }
        MyLinkedList<E> returnMyLinkedList=new MyLinkedList<>();
        Node temp=head;
        returnMyLinkedList.addFirst((E) temp.data);
        temp=temp.next;
        while (temp.next!=null){
            returnMyLinkedList.addLast((E) temp.data);
            temp=temp.next;
        }
        return returnMyLinkedList;
    }
    public boolean constrains(E element){
        Node temp=head;
        while (temp.next!=null){
            if (temp.data.equals(element)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public int indexOf(E element){
        Node temp=head;
        for (int i=0;i<numNodes;i++){
            if (temp.getData().equals(element)){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
}
