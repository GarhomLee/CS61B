public class ArrayDequeOperation<T> {
    /* stores every operation */

    private String operation;
    private boolean hasArgument;
    private T argument;

    public ArrayDequeOperation(String op){
        operation = op;
        hasArgument = false;
    }

    public ArrayDequeOperation(String op, T arg) {
        operation = op;
        hasArgument = true;
        argument = arg;
    }

    /* get the operation and output as String. */
    public String getOperation(){
        if (hasArgument) {
            return operation + "(" + argument + ")";
        } else {
            return operation + "()";
        }
    }
}
