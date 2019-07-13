package basic_class_07;

import java.util.Arrays;
import java.util.Comparator;
//会议
public class Code_06_BestArrange {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			if (start <= programs[i].start) {
				result++;
				start = programs[i].end;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Program program1 = new Program(6, 7);
		Program program2 = new Program(7, 8);
		Program program3 = new Program(8, 9);
		Program program4 = new Program(9, 10);
		Program program5 = new Program(10, 11);
		Program program6 = new Program(11, 12);
		Program program7 = new Program(12, 13);
		
		Program[] programs = {program2, program1, program4, program3, program5, program7, program6};
		Arrays.sort(programs, new ProgramComparator());
		for (int i = 0; i < programs.length; i++) {
			System.out.println(programs[i].start + " " + programs[i].end);
		}
		int res = bestArrange(programs, 9);
		System.out.println(res);
	}
	
}
