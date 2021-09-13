import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
import java.util.*;

public class Rectangle1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// File file = new File(args[0]);
		String file = args[0];
		Scanner scan = new Scanner(new File(file));
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner lineScanner = new Scanner(line);
			String cmd = scan.next();
			if (cmd.equals("insert")) {
				while (lineScanner.hasNext()) {
					System.out.println(line);
					System.out.println("command " + cmd);
					String name = scan.next();
					System.out.println("name " + name);
					int xCord = scan.nextInt();
					int yCord = scan.nextInt();
					int width = scan.nextInt();
					int height = scan.nextInt();
					
				}

			} else if (cmd.equals("remove")) {
				// System.out.print(cmd);
				while(lineScanner.hasNext())
				{
					
				}
			} else if (cmd.equals("regionsearch")) {
				while(lineScanner.hasNext())
				{
					
				}
				// System.out.print(cmd);
			} else if (cmd.equals("intersections")) {
				
				// System.out.print(cmd);
			} else if (cmd.equals("search")) {
				
				// System.out.print(cmd);
			} else {
				
				// System.out.print(cmd);
			}
		}
		// String line = scan.nextLine();
		// System.out.println(line);
		// System.out.println(file);
		// fileParser(file);
		// Rectangle1 rect = new Rectangle1();

	}

	/**
	 * @param file
	 */
	public static void fileParser(String file) {
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
				/*
				 * else if(scan.equals("remove")) { System.out.println(scan.nextLine()); } else
				 * if(scan.equals("regionsearch")) { System.out.println(scan.nextLine()); } else
				 * if(scan.equals("intersections")) { System.out.println(scan.nextLine()); }
				 * else if(scan.equals("search")) { System.out.println(scan.nextLine()); } else
				 * { //dump scenario System.out.println(scan.nextLine()); }
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insert(String name, int x, int y, int width, int height) {

	}

}
