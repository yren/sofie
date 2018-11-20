package me.lokvin.kiwi.sofe.annotations;

import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

public class ApplicationSettingsIdentity {

    private static final String BASE_RT_DIR = "BASE_RT_DIR";
    private static File baseRtDir = null;
    private static final String ENVIRONMENT = "ENVIRONMENT";
    private static String environment = null;
    private final ReentrantLock configurationLock = new ReentrantLock();

}
