package milca;

import java.net.URL;

import org.apache.pivot.beans.Bindable;
import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Window;
import org.apache.pivot.wtk.DesktopApplicationContext;


public class App implements Application, Bindable {

	// app entry
	public static void main(String[] args) {
	    DesktopApplicationContext.main(App.class, args);
	}

    private Window window = null;
 
    @Override
    public void startup(Display display, Map<String, String> properties) throws Exception {
        BXMLSerializer bxmlSerializer = new BXMLSerializer();
        window = (Window)bxmlSerializer.readObject(App.class, "app.bxml");
        window.open(display);
    }

    @Override
    public void initialize(Map<String, Object> namespace, URL location, Resources resources){
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