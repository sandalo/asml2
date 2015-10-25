package asmlbuilder.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class ASMLClassLoader extends URLClassLoader {

	public ASMLClassLoader(URL[] arg0, ClassLoader classLoader) {
		super(arg0,classLoader);
	}
	
	@Override
    public void addURL(URL url) {
    	super.addURL(url);
    }
}
