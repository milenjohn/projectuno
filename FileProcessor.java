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
			while (scan.hasNext()) 
			{
				String line = scan.nextLine().trim();
				String cmd = scan.next();
				System.out.println(scan);
				// if (scan.equals("insert"))
				switch (cmd) {
				case "insert":
					String name = scan.next();
					int xCord = scan.nextInt();
					int yCord = scan.nextInt();
					int width = scan.nextInt();
					int height = scan.nextInt();

					if (width <= 0 || height <= 0 || (xCord + width > 1024) || (xCord + width < 0)
							|| (yCord + height > 1024) || (yCord + height < 0) || (xCord < 0) || (yCord < 0)) 
					{
						System.out.print("Rectangle rejected: ");
					}
					
					Rectangle rect = new Rectangle(name, xCord, yCord, width, height);
					KVPair<String, Rectangle> item= new KVPair<String, Rectangle>(name, rect);
					
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
