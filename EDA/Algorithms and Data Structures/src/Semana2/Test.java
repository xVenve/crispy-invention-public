package Semana2;

public class Test {
	public static int count(SStack s, char c) {
		int n = 0;
		SStack aux = new SStack();
		while (!s.isEmpty()) {
			if (s.top().equals(c))
				n++;
			aux.push(s.pop());
		}
		while (!aux.isEmpty())
			s.push(aux.pop());
		return n;
	}

	public static void main(String[] args) {
		// Test00
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
		// 5 x
		System.out.println(count(h, f));
		// Test01
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
		// 3 j
		System.out.print(count(l, g));
	}
}
