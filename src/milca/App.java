package milca;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Window;
 
import org.apache.pivot.wtk.DesktopApplicationContext;
 
public class App implements Application {
	
	public static void main(String[] args) {
	    DesktopApplicationContext.main(App.class, args);
	}

    private Window window = null;
 
    @Override
    public void startup(Display display, Map<String, String> properties)
        throws Exception {
        BXMLSerializer bxmlSerializer = new BXMLSerializer();
        window = (Window)bxmlSerializer.readObject(App.class, "app.bxml");
        window.open(display);
    }
 
    @Override
    public boolean shutdown(boolean optional) {
        if (window != null) {
            window.close();
        }
 
        return false;
    }
 
    @Override
    public void suspend() {
    }
 
    @Override
    public void resume() {
    }
}