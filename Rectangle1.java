import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
import java.util.*;

public class Rectangle1 {

	public static void main(String[] args) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		// File file = new File(args[0]);
		String file = args[0];
		Scanner scan = new Scanner(new File(file));
		//FileProcessor fp = new FileProcessor();
		//while file has a next line
		while (scan.hasNextLine()) {
			//getting singular line from file
			String line = scan.nextLine();
			//fp.fileParser(line);
			try {
				Scanner scans = new Scanner(line);
				//System.out.print(scan);
				while (scans.hasNext()) 
				{
					System.out.println(line);
					//regex string delimeter we need to figure out to get rid of excess whitespace between parameters in text file
					String[] lineCMD = line.trim().split(" [+]");
					//for loop just for printing output for error checking
					for(int i = 0; i< lineCMD.length;i++)
					{
						System.out.print(lineCMD[i]);
					}
					//System.out.println(lineCMD);
					
					String cmd = lineCMD[0];
					//System.out.println(scan);
					// if (scan.equals("insert"))
					switch (cmd) {
					case "insert":
						String name = lineCMD[1];
						int xCord = Integer.parseInt(lineCMD[2]);
						int yCord = Integer.parseInt(lineCMD[3]);
						int width = Integer.parseInt(lineCMD[4]);
						int height = Integer.parseInt(lineCMD[5]);
						//System.out.println(name);
						if (width <= 0 || height <= 0 || (xCord + width > 1024) || (xCord + width < 0)
								|| (yCord + height > 1024) || (yCord + height < 0) || (xCord < 0) || (yCord < 0)) 
						{
							System.out.print("Rectangle rejected: ");
						}
						
						//Rectangle rect = new Rectangle(name, xCord, yCord, width, height);
						//KVPair<String, Rectangle> item= new KVPair<String, Rectangle>(name, rect);
						
						//System.out.println(scan.nextLine());
						// rect.insert();
						break;

					case "remove":
						//System.out.println(scan.nextLine());
						break;

					case "regionsearch":
						//System.out.println(scan.nextLine());
						break;

					case "intersections":
						//System.out.println(scan.nextLine());
						break;

					case "search":
						//System.out.println(scan.nextLine());
						break;

					case "dump":
						//System.out.println(scan.nextLine());
						break;
					
					}
					line = scan.nextLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		}
		// String line = scan.nextLine();
		// System.out.println(line);
		// System.out.println(file);
		// fileParser(file);
		// Rectangle1 rect = new Rectangle1();

	}

//}
