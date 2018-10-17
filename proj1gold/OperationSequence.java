public class OperationSequence<T> extends ArrayDeque<T> {

    /* ArrayDeque that stores ArrayDequeOperation
    @Override
    /* print all the previous operations directly to the standard output. */
    public void printDeque() {
        int dequeSize = size();
        for(int i = 0; i < dequeSize; i++){
            ArrayDequeOperation operation = (ArrayDequeOperation) get(i);
            System.out.println(operation.getOperation());
        }
    }

    /* return all the previous operations as a String. */
    public String stringPrintDeque() {
        int dequeSize = size(); //important! otherwise the size would change
        String spd = "";
        for(int i = 0; i < dequeSize; i++) {
            ArrayDequeOperation operation = (ArrayDequeOperation) get(i); //DON'T use removeLast
            spd = spd + operation.getOperation() +"\n";
        }
        return spd;
    }
}
