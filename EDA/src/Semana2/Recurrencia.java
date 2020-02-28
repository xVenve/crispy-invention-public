package Semana2;

public class Recurrencia {
    public static int count(SStack s, char c) {
        int n = 0;
        if (!s.isEmpty()) {
            if (s.pop() == c) {
                n = count(s, c) + 1;
            } else {
                n = count(s, c);
            }
        }
        return n;
    }
    public static void main(String[] args) {
        //Test00
        char f = 'x';
        SStack h = new SStack();
        h.push('x');
        h.push('d');
        h.push('s');
        h.push('x');
        h.push('x');
        h.push('f');
        h.push('x');
        h.push('x');
        //5 x
        System.out.println(count(h, f));
        //Test01
        char g = 'j';
        SStack l = new SStack();
        l.push('j');
        l.push('i');
        l.push('s');
        l.push('m');
        l.push('j');
        l.push('j');
        l.push('v');
        l.push('y');
        l.push('f');
        l.push('d');
        //3 j
        System.out.print(count(l, g));
    }
}
