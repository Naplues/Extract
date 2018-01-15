package trans.run;

import java.util.ArrayList;
import java.util.List;

import trans.file.FileHandle;

/**
 * 
 * @author gzq
 *
 */
public class Main {
	public static void main(String[] args) {
		// new Window();

		get();
	}

	public static void get() {
		List<String> origins = FileHandle.readFileToLines("test.txt");
		List<String> lines = new ArrayList<>();
		int len = 0;
		boolean lastEmpty = false;

		for (String s : origins) {
			if (s.equals("")) {
				lastEmpty = true;
				continue;
			}
			// 上一行是空，说明该行是上一文献的一部分
			if (lastEmpty) {
				lines.set(len - 1, lines.get(len - 1) + s);
				lastEmpty = false;
				continue;
			}
			lines.add(s);
			len++;
		}

		for (String s : lines) {
			System.out.println(s);
		}

		System.out.println(lines.get(0));
		String[] temp = lines.get(0).split("\\.|\\[J\\]\\.|\\[M\\]\\.|\\[A\\]\\.");
		System.out.println(temp.length);
		for (String s : temp) {
			System.out.println(s);
		}

	}
}
