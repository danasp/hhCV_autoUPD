package vereshchakov.main;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Created by Danila on 22.10.15.
 */
public class DummyHostnameVerifier implements HostnameVerifier {

    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}
