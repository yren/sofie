package me.lokvin.kiwi.sofe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        Logger log = LoggerFactory.getLogger(App.class);
        log.debug("hello slf4j, {}, {}, {}", "one", "two", "three");

        String[] strs = {"1", "2", "3"};
        log.debug("hello slf4j {}, {}, {}", strs);
    }
}
