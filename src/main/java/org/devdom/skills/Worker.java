package org.devdom.skills;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public class Worker implements Runnable{

    private static final int RUNNER = 2000; // +31 ?
    private static final Logger LOGGER = Logger.getLogger(Worker.class .getName());
    private static final int SLEEP = (60000*45);

    @Override
    public void run() {
        LOGGER.log(Level.INFO, "ping...");
        for (int i=0; i < RUNNER; i++) {
            try {
                Thread.sleep(SLEEP);

                URL url = new URL("http://skills-devdom.herokuapp.com/api/developer.json");
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("GET");
                http.setRequestProperty("Accept", "application/json");

                if(http.getResponseCode() == 200){
                    LOGGER.log(Level.INFO, "OK, count {0}", i);
                }else{
                    LOGGER.log(Level.WARNING, "http error, {0}", http.getResponseCode());
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
