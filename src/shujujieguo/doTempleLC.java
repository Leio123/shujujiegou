package shujujieguo;

public class doTempleLC {
	public static void doTemple(int temp, char from, char inter, char to) {
		if(temp == 1) {
			System.out.println("盘子1从："+from+"塔座到"+to+"塔座");
		} else {
			doTemple(temp - 1, from, to, inter);
			System.out.println("盘子"+temp+"从："+from+"塔座到"+to+"塔座");
			doTemple(temp - 1, inter, from, to);
		}
	}
	
	public static void main(String[] args) {
		doTemple(4, 'A', 'B', 'C');
	}
}
