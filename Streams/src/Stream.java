public interface Stream<T> {
    Pair<T> eval();
    class Pair<T>{
        private T value;
        private Stream<T> rest;
        public Pair(T value,Stream<T> rest){
            this.rest=rest;
            this.value=value;
        }
        static <T> Stream<T> empty(){
            return () ->null;//arafers ar igebs
        }
        Static <T> Stream<T> of(T x){

        }
    }
}
