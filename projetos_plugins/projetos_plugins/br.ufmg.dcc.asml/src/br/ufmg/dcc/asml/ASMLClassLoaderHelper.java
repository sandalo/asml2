package br.ufmg.dcc.asml;

import java.net.URL;
import java.net.URLClassLoader;

public class ASMLClassLoaderHelper {

	static public void main(String args[]) throws Exception {
		String path = "file:/C:/eclipse-luna/runtime-EclipseApplication/vaccine/target/classes/";
		URL myurl[] = { new URL(path) };
		URLClassLoader x = new URLClassLoader(myurl);
		Class c = x.loadClass("br.ufmg.vaccine.Vaccinne");
		System.out.println(c.newInstance());
	}
}
