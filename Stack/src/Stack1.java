public class Stack1 {

    private int sp;

    private int[] a;

    public Stack1() {
        sp = -1;
        a = new int[4];
    }

    public boolean isEmpty() {
        if (sp < 0) {
            return true;
        } else {
            return false;
        }
        //return sp < 0 ; // Shortly
    }

    public int pop() {

            int result = a[sp];
            if (sp == a.length / 4 && sp >= 2) {
                int[] b = new int[2 * sp];
                for (int i = 0; i < sp; i++) {
                    b[i] = a[i];
                }
                a = b;
            }
            sp--;
            return result;
        }


        public void push ( int x){

            sp++;
            if (sp == a.length) {
                int[] b = new int[2 * sp];
                for (int i = 0; i < sp; i++) {
                    b[i] = a[i];
                }
                a = b;
            }
            a[sp] = x;
        }
    }



