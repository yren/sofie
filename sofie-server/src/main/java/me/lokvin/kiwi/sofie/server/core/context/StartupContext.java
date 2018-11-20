package me.lokvin.kiwi.sofie.server.core.context;

/**
 * context used for server first stat up
 */
public interface StartupContext {

    String getStaticConfName();
    String getDynamicConfName();

}
