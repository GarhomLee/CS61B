public class LinkedListDeque<T> implements Deque<T> {
    public class IntNode {
        public T item;
        public IntNode previous;
        public IntNode next;
        public IntNode(T i, IntNode p, IntNode n) {
            item = i;
            previous = p;
            next = n;
        }
    }

    //The first item (if exists) is at sentinel.next
    private int size;
    private IntNode sentinel;
    public LinkedListDeque(){
        sentinel = new IntNode(null, null, null);
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item){
        IntNode first = new IntNode(item, null, null);
        first.next = sentinel.next;
        first.next.previous = first;
        sentinel.next = first;
        first.previous = sentinel;
        size += 1;
    }

    @Override
    public void addLast(T item){
        IntNode last = new IntNode(item, null, null);
        last.next = sentinel;
        last.previous = sentinel.previous;
        last.previous.next = last;
        sentinel.previous = last;
        size += 1;
    }

    @Override
    public boolean isEmpty(){
        if(sentinel.next == sentinel && sentinel.previous == sentinel){
            return true;
        }
        return false;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        IntNode p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst(){
        if (sentinel.next == sentinel){
            return null;
        }
        T itemReturn = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        size -= 1;
        return itemReturn;
    }

    @Override
    public T removeLast(){
        if (sentinel.previous == sentinel){
            return null;
        }
        T itemReturn = sentinel.previous.item;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        size -= 1;
        return itemReturn;
    }

    @Override
    public T get(int index){
        if (size == 0 | index >= size){
            return null;
        }
        IntNode p = sentinel;
        for (int i = 0; i <= index; i++){
            p = p.next;
        }
        return p.item;
    }

    //this is a helper method
    private T getRecursive(int index, IntNode p){
        if (size == 0 | index >= size){ //exception: if no items in the linked list or out of index
            return null;
        }
        if (index == 0){ //base case
            return p.item;
        }
        return getRecursive(index - 1, p.next);
    }

    public T getRecursive(int index){
        return getRecursive(index, sentinel.next);
    }

}
