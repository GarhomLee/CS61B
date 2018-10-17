public class ArrayDeque<T> implements Deque<T> {
    private int size;
    T[] items;
    private int first; //indicate the first position
    private int last; //indicate the last + 1 position
    public ArrayDeque(){
        items = (T []) new Object[8];
        size = 0;
        first = 0;
        last = 0;
    }

    @Override
    public void addFirst(T item){
        if (!this.isFull()) {
            first = (first - 1 + items.length) % items.length;
            items[first] = item;
        } else{
            T[] temp = (T[]) new Object[items.length * 2];
            for(int i = 1; i <= items.length; i++){
                temp[i] = items[(first + i - 1 + items.length) % items.length];
            }
            items = temp;
            items[0] = item;
            first = 0;
            last = size + 1;
        }
        size += 1;
    }

    @Override
    public void addLast(T item){
        if (!this.isFull()) {
            items[last] = item;
            last = (last + 1 + items.length) % items.length;
        } else{
            T[] temp = (T[]) new Object[items.length * 2];
            for(int i = 0; i < items.length; i++){
                temp[i] = items[(first + i + items.length) % items.length];
            }
            items = temp;
            items[size] = item;
            first = 0;
            last = size + 1;
        }
        size += 1;
    }

    @Override
    public boolean isEmpty(){
        return (first == last & items[first] == null);
    }

    public boolean isFull(){
        return (first == last & items[first] != null);
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        for(int i = 0; i < size; i++){
            System.out.print(items[(first + i + items.length) % items.length] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst(){
        T returnItem = items[first];
        size -= 1;
        if ((double)size / items.length > 0.25){
            first = (first + 1 + items.length) % items.length;
        } else{
            T[] temp = (T[]) new Object[items.length / 2];
            for(int i = 0; i < size; i++){
                temp[i] = items[(first + i + 1 + items.length) % items.length];
            }
            items = temp;
            first = 0;
            last = size;
        }
        return returnItem;
    }

    @Override
    public T removeLast(){
        T returnItem = items[(last - 1 + items.length) % items.length];
        size -= 1;
        if ((double)size / items.length > 0.25){
            last = (last - 1 + items.length) % items.length;
        } else{
            T[] temp = (T[]) new Object[items.length / 2];
            for(int i = 0; i < size; i++){
                temp[i] = items[(first + i + items.length) % items.length];
            }
            items = temp;
            first = 0;
            last = size;
        }
        return returnItem;
    }

    @Override
    public T get(int index){
        return items[(first + index + items.length) % items.length];
    }

}
