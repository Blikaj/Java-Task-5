public class MyGeneric2 {
    public class MyGeneric<T extends ClassA> {
        public T obj;
        public MyGeneric(T obj){
            this.obj=obj;
            obj.methodA();
        }

        public T getObj() {
            return obj;
        }
    }
}
