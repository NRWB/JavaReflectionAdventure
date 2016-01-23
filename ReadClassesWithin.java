import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ReadClassesWithin {

	public static final boolean DEBUG = true;
	public static final String JAR_PATH = "C:\\Users\\Name\\Desktop\\test.jar";

	public static void main(String[] args) throws Exception {
		System.out.println(getClasseNames(JAR_PATH));
		System.out.println();

	}

	public static List<String> getAllFiles(final String str) {
		List<String> classes = new ArrayList<String>();
		JarInputStream jarFile = new JarInputStream(new FileInputStream(jarName));
		while (true) {
			JarEntry jarEntry = jarFile.getNextJarEntry();
			if (jarEntry == null)
				break;
			if (jarEntry.getName().endsWith(".class"))
				classes.add(jarEntry.getName().replaceAll("/", "\\."));
			else
				System.out.println(jarEntry.getName());
		}
		if (jarFile != null) {
			try {
				jarFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return classes;
	}
}
