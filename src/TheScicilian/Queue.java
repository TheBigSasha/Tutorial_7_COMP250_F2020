package TheScicilian;

public class Queue<E> {
    private Stack<E> inputs;
    private Stack<E> outputs;

    public Queue(){
        inputs = new Stack<>();
        outputs = new Stack<>();
    }

    /**
     * Adds a thing to the queue
     * @param item - the thing we are adding
     */
    public void enqueue(E item){
        inputs.add(item);
    }

    /**
     * Get and remove the first thing we added!
     * @return first thing we added
     */
    public E dequeue(){
        if(outputs.isEmpty()){
            while(!inputs.isEmpty()){
                outputs.push(inputs.pop());     //This implementation is SLOW!
            }
        }
        return outputs.pop();
    }

    public boolean isEmpty(){
        return this.inputs.isEmpty() && this.outputs.isEmpty();
    }
}
