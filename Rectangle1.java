import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
import java.util.*;

public class Rectangle1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		SkipList<String, Rectangle> list = new SkipList<String, Rectangle>();
		String file = args[0];
		Scanner scan = new Scanner(new File(file));
		// FileProcessor fp = new FileProcessor();
		// fp.fileParser(line);
		try {
			String lineReader = "";
			while (scan.hasNextLine()) {
				lineReader = scan.nextLine();
				// regex string delimeter we need to figure out to get rid of excess whitespace
				// between parameters in text file
				String CMD = lineReader.trim();
				String[] lineCMD = CMD.split("\\s+");
				// switch statement for all situations
				switch (lineCMD[0]) {
				case "insert":
					String name = lineCMD[1];
					int xCord = Integer.parseInt(lineCMD[2]);
					int yCord = Integer.parseInt(lineCMD[3]);
					int width = Integer.parseInt(lineCMD[4]);
					int height = Integer.parseInt(lineCMD[5]);
					Rectangle rect = new Rectangle(name, xCord, yCord, width, height);
					KVPair<String, Rectangle> item = new KVPair<String, Rectangle>(name, rect);
					if (width <= 0 || height <= 0 || (xCord + width > 1024) || (xCord + width < 0)
							|| (yCord + height > 1024) || (yCord + height < 0) || (xCord < 0) || (yCord < 0)) {
						System.out.println("Rectangle rejected: (" + name + ", " + xCord + ", " + yCord + ", " + width
								+ ", " + height + ")");
					} else {
						list.insert(name, rect);
						System.out.println("Rectangle Inserted: (" + name + ", " + xCord + ", " + yCord + ", " + width
								+ ", " + height + ")");
					}
					break;

				case "remove":
					// System.out.println(scan.nextLine());
					break;

				case "regionsearch":
					// System.out.println(scan.nextLine());
					break;

				case "intersections":
					// System.out.println(scan.nextLine());
					break;

				case "search":
					// System.out.println(scan.nextLine());
					break;

				case "dump":
					System.out.println("SkipList dump: ");
					break;

				}
				System.out.println(lineCMD[0]);
			}
		}
		// line = scan.nextLine();
		catch (Exception e) {
			e.printStackTrace();
		}

		// String line = scan.nextLine();
		// System.out.println(line);
		// System.out.println(file);
		// fileParser(file);
		// Rectangle1 rect = new Rectangle1();

	}
}
//}
