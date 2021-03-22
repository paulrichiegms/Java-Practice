public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //addfirst addlast deletefirst deletelast contains indexof

    public void addLast(int item){
        var node =new Node(item);

        if (head==null){
            head=tail=node;
        }
        else{
            tail.next=node;
            tail=node;
        }

        size++;
    }

    public void addFirst(int item){
        var node=new Node(item);

        if(head==null){
            head=tail=node;
        }
        else{
            node.next=head;
            head=node;
        }
        size++;
    }

    public int indexOf(int item){
        int index=0;
        var current=head;
        while(current!=null){
            if(current.value==item){
                return index;
            }
            else{
                current=current.next;
                index++;
            }
        }
        return -1;
    }

    public boolean contains(int item){
        var current=head;
        while(current!=null){
            if(current.value==item){
                return true;
            }
            else{
                current=current.next;
            }
        }
        return false;
    }

    public void deleteFirst(){
        var second=head.next;
        head.next=null;
        head=second;
        /*var current=head;
        head=current.next;
        current.next=null;*/
        size--;
    }

    public void deleteLast(){
        /*if(isEmpty()){
        throw new NoSuchElementException();
        }*/

        if(head==tail){

            head=tail=null;
        }

        else {

            var previous = getPrevious(tail);
            tail = previous;
            tail.next = null;
        }
        size--;

    }

    private Node getPrevious(Node node){
        var current=head;
        while(current!=null){
            if(current.next==node){
                return current;
            }
            else{
                current=current.next;
            }
        }
        return null;
    }

    public int size(){
        return size;

    }

    public int[] toArray(){
        int[] a=new int[size];
        var current=head;
        var index=0;
        while(current!=null){
            a[index++]=current.value;
            current=current.next;
        }
        return a;
    }

    public void reverse(){
        /*if(isEmpty()) retunr;*/
        var previous= head;
        var current=head.next;
             while(current!=null) {
            var next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        tail=head;
        tail.next=null;
        head=previous;
    }

    public int getKthNodeFromEnd(int k){
        /*if(isEmpty()){
        throw new NoSuchElementException();
        }*/

        var a=head;
        var b=head;
        for(int i=0;i<k-1;i++){
            b=b.next;
            if(b==null){
                throw new IllegalArgumentException();
            }
        }
        while(b!=tail){
            a=a.next;
            b=b.next;
        }
        return a.value;
    }





}
