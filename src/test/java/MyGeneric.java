public class MyGeneric<T> {
    public T obj;
    public MyGeneric(T obj){
        this.obj=obj;
        if (obj instanceof ClassA) {
            ClassA a = (ClassA) obj;
            a.methodA();
        }
    }

    public T getObj() {
        return obj;
    }
}
