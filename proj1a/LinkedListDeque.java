public class LinkedListDeque<T>{
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

    public void addFirst(T item){
        IntNode first = new IntNode(item, null, null);
        first.next = sentinel.next;
        first.next.previous = first;
        sentinel.next = first;
        first.previous = sentinel;
        size += 1;
    }

    public void addLast(T item){
        IntNode last = new IntNode(item, null, null);
        last.next = sentinel;
        last.previous = sentinel.previous;
        last.previous.next = last;
        sentinel.previous = last;
        size += 1;
    }

    public boolean isEmpty(){
        if(sentinel.next == sentinel && sentinel.previous == sentinel){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        IntNode p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

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

    private T getRecursive(int index, IntNode p){
        if (size == 0 | index >= size){
            return null;
        }
        if (index == 0){
            return p.item;
        }
        return getRecursive(index - 1, p.next);
    }
    public T getRecursive(int index){
        return getRecursive(index, sentinel.next);
    }

    /*public static void main(String[] args){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        System.out.println(L.isEmpty());
        L.addFirst(7);
        L.addLast(9);
        L.addFirst(10);
        L.addLast(3);
        System.out.println(L.isEmpty());
        System.out.println("size is " + L.size());
        L.printDeque();
        System.out.println(L.removeFirst());

        System.out.println("size is " + L.size());
        L.printDeque();
        System.out.println(L.get(10));
        System.out.println("get iterative: " + L.get(2));
        System.out.println("get recursive: " + L.getRecursive(2));
        System.out.println(L.removeFirst());
        System.out.println("get iterative: " + L.get(0));
        System.out.println("get recursive: " + L.getRecursive(0));
    }*/
}
