import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ReadClassesWithin {

	public static final String JAR_PATH = "C:\\Users\\Name\\Desktop\\test.jar";

	public static void main(String[] args) throws Exception {
		System.out.println(getAllFiles(JAR_PATH).size());
		System.out.println(getAllClassFiles(JAR_PATH).size());
	}
	
	/**
	 * Obtains all the file names contained within the jar file.
	 * Uses try with resources statement, requires Java 7 or later.
	 * @param s The file pathname to the specified jar file.
	 * @return A list of jar file names. 
	 */
	public static List<String> getAllFiles(final String s) {
		List<String> list = new ArrayList<String>();

		try (JarInputStream jis = new JarInputStream(new FileInputStream(s))) {
			while (true) {
				JarEntry je = jis.getNextJarEntry();
				if (je == null)
					break;
				list.add(je.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	/**
	 * Obtains all the java class file names contained within the jar file.
	 * @param s The file pathname to the specified jar file.
	 * @return A list of jar file names. 
	 */
	public static List<String> getAllClassFiles(final String s) {
		List<String> list = getAllFiles(s);
		List<String> result = new ArrayList<String>();

		for (String str : list)
			if (str.contains(".class"))
				result.add(str);

		return result;
	}

}
