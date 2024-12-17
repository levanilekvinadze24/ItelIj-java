public class List {


    public int info;
    public List next;

    public List(int x , List l){
        info = x;
        next = l;
    }

    public void insert(int x){
        next = new List(x , next);
    }
    public void delete(){
        if(next != null){
            next = next.next;
        }
    }
    public boolean isEmpty(List l){
        if(l==null){
            return true;
        }else{
            return false;
        }
    }
    public static String toString(List l){
        if( l == null){
            return "[]";
        }else{
            return l.toString();
        }
    }
    public String toString(){
        String result = " [ " + info ;
        for(List t = next ; t!= null; t = t.next){
            result = result +  " , " + t.info;
        }
        return result + " ] ";
    }

    public static List ArrayToList(int[] a){
        List result = null ;
        for(int i = a.length - 1 ; i>=0 ; i--){
            result = new List( a[i] , result);
        }
        return result;
    }
    public int length(){
        int result = 1 ;
        for(List t = next ; t != null;t = t.next){
            result++;
        }
        return result;
    }

    public  int[] ListToArray(){
        List t = this;
        int n = length();
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++){
            a[i] = t.info;
            t = t.next;
        }
        return a;
    }
}
