import java.io.File;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author milenjohn
 *
 */
public class FileProcessor {

	private SkipList<String, Rectangle> list;

	public FileProcessor() {
		list = new SkipList<String, Rectangle>();
	}

	public void fileParser(String file) {
		try {
			Scanner scan = new Scanner(new File(file));
			System.out.print(scan);
			while (scan.hasNext()) {
				String cmd = scan.next();
				System.out.println(scan);
				// if (scan.equals("insert"))
				switch (cmd) {
				case "insert":
					int xCord = scan.nextInt();
					int yCord = scan.nextInt();
					int width = scan.nextInt();
					int height = scan.nextInt();
					System.out.println(scan.nextLine());
					// rect.insert();
					break;

				case "remove":
					System.out.println(scan.nextLine());
					break;

				case "regionsearch":
					System.out.println(scan.nextLine());
					break;

				case "intersections":
					System.out.println(scan.nextLine());
					break;

				case "search":
					System.out.println(scan.nextLine());
					break;

				case "dump":
					System.out.println(scan.nextLine());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
