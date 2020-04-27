//package tema2;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.Enumeration;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MyReverseEngineeringToolMain {
	public static void main(String[] args) {
		int i, j;
		if (args.length == 0)
			System.exit(1);
		try {
			JarFile jarFile = new JarFile(args[0]);
			Enumeration<JarEntry> enumeration = jarFile.entries();

			File path = new File(args[0]);
			URL[] url = { new URL("jar:file:" + path + "!/") };
			URLClassLoader cl = URLClassLoader.newInstance(url);

			while (enumeration.hasMoreElements()) {
				JarEntry jarEntry = enumeration.nextElement();
				if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")) {
					continue;
				}

				String className = jarEntry.getName().substring(jarEntry.getName().toString().lastIndexOf("/") + 1, jarEntry.getName().length() - 6);
				Class c = cl.loadClass(className);

				String simpleClassName = c.getSimpleName();
				boolean isabstract = Modifier.isAbstract(c.getModifiers());
				if (isabstract) {
					System.out.println(simpleClassName + ": abstract ");
				}
				if (c.isInterface()) {
					System.out.println(simpleClassName + ": interface ");
				}
				if ((isabstract == false) && !c.isInterface()) {
					System.out.println(simpleClassName + ": public class ");
				}
				Package packageName = c.getPackage();
				System.out.println(packageName);
				
				Class nameOfSuperClass = c.getSuperclass();
				System.out.println("Superclass: " + nameOfSuperClass);
				Class[] getImplementedInterfaces = c.getClass().getInterfaces();
				System.out.println("Implemented interfaces: ");
				for (i = 0; i < getImplementedInterfaces.length; i++) {
					System.out.println("--> " + getImplementedInterfaces[i] + " ");
				}

				Constructor[] constructors = c.getDeclaredConstructors();
				for (i = 0; i < constructors.length; i++) {
					System.out.print("Constructor: ");
					System.out.print(constructors[i].getName() +"( ");
					Class[] params = constructors[i].getParameterTypes();
					for (j = 0; j < params.length; j++) {
						String paramType = params[j].getName();
						System.out.print(paramType + " ");
					}
					System.out.println(")");
				}

				Field[] publicFields = c.getFields();
				for (i = 0; i < publicFields.length; i++) {
					int accessSpecifier = publicFields[i].getModifiers();
					switch(accessSpecifier){
						case 1:
							System.out.print("public ");break;
						case 2:
							System.out.print("private ");break;
						case 4:
							System.out.print("protected ");break;
						case 8:
							System.out.print("static ");break;
						case 10:
							System.out.print("private static ");break;
						case 12:
							System.out.print("protected static ");break;
						case 9:
							System.out.print("public static ");break;
						case 25:
							System.out.print("public static final ");break;
					}
					System.out.println(publicFields[i].getName() + ": " + publicFields[i].getType().getName());
				}

				Field[] publicDeclaredFields = c.getDeclaredFields();
				for (i = 0; i < publicDeclaredFields.length; ++i) {
					int accessSpecifier = publicDeclaredFields[i].getModifiers();
					switch(accessSpecifier){
						case 1:
							System.out.print("public ");break;
						case 2:
							System.out.print("private ");break;
						case 4:
							System.out.print("protected ");break;
						case 8:
							System.out.print("static ");break;
						case 10:
							System.out.print("private static ");break;
						case 12:
							System.out.print("protected static ");break;
						case 9:
							System.out.print("public static ");break;
						case 25:
							System.out.print("public static final ");break;
					}
					System.out.println(publicDeclaredFields[i].getName() + ": " + publicDeclaredFields[i].getType().getName());
				}

				Method[] publicMethods = c.getMethods();
				for (i = 0; i < publicMethods.length; ++i) {
					int accessSpecifier = publicMethods[i].getModifiers();
					switch(accessSpecifier){
						case 1:
							System.out.print("public ");break;
						case 2:
							System.out.print("private ");break;
						case 4:
							System.out.print("protected ");break;
						case 8:
							System.out.print("static ");break;
						case 10:
							System.out.print("private static ");break;
						case 12:
							System.out.print("protected static ");break;
						case 9:
							System.out.print("public static ");break;
					}
					System.out.print(publicMethods[i].getName() + "( ");
					Class[] params = publicMethods[i].getParameterTypes();
					for (j = 0; j < params.length; ++j) {
						System.out.print(params[j].getName() + " ");
					}
					Class retType = publicMethods[i].getReturnType();
					System.out.println("): " + retType.getName());
				}

				Method[] publicDeclaredMethods = c.getDeclaredMethods();
				for (i = 0; i < publicDeclaredMethods.length; ++i) {
					int accessSpecifier = publicDeclaredMethods[i].getModifiers();
					switch(accessSpecifier){
						case 1:
							System.out.print("public ");break;
						case 2:
							System.out.print("private ");break;
						case 4:
							System.out.print("protected ");break;
						case 8:
							System.out.print("static ");break;
						case 10:
							System.out.print("private static ");break;
						case 12:
							System.out.print("protected static ");break;
						case 9:
							System.out.print("public static ");break;
					}
					System.out.print(publicDeclaredMethods[i].getName() + "( ");
					Class[] parameters = publicDeclaredMethods[i].getParameterTypes();
					for (j = 0; j < parameters.length; ++j) {
						System.out.print(parameters[j].getName() + " ");
					}
					Class returnType = publicDeclaredMethods[i].getReturnType();
					System.out.println("): " + returnType.getName());
				}
				System.out.println();

			}
			jarFile.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}

}
