package my.examples.javaexam;

public class GenericBox<T> {
    private T obj;
    public void set(T obj){
        this.obj = obj;
    }

    public T get(){
        return obj;
    }
}
