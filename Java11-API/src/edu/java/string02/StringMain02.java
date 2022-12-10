package edu.java.string02; // 이런게 있구나~

class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override // toString 오버라이드 안하면 주소값만 나옴
	public String toString() {		
		return "(" + x + ", " + y + ")";
	}

	@Override // equals 오버라이드
	public boolean equals(Object obj) { // 이해어려운... 이게뭐시여
		boolean result = false;
		
		if (obj instanceof Point) { // 이게 뭐시여....
			Point pt = (Point) obj; // 강제 형 변환
			if (x == pt.x && y == pt.y) {
				result = true; // 두 개 좌표가 같으면 true로
			}
		}
		return result;
	}
}

public class StringMain02 { // equals가 String에서만 내용이 같은지 봐준대....

	public static void main(String[] args) {
		Point pt1 = new Point(1, 2);
		System.out.println(pt1);

		Point pt2 = new Point(1, 2);
		System.out.println(pt2);

		if (pt1.equals(pt2)) {// equals는 원래 주소값/좌표가 같은지부터 본대
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

	} // end main()

} // end StringMain02
