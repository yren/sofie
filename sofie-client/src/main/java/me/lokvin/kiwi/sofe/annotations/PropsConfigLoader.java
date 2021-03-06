package me.lokvin.kiwi.sofe.annotations;

import com.google.common.io.Resources;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropsConfigLoader {
    private static final Logger logger = LoggerFactory.getLogger(PropsConfigLoader.class);
    public static Configuration load(ApplicationSettingsIdentity identity, String configName) {
        Configuration config = null;
        Parameters params = new Parameters();
        logger.info("file name {}", configName);
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                .configure(params.properties().setURL(Resources.getResource(configName)));

        try {
            config = builder.getConfiguration();


        } catch (ConfigurationException e) {
            logger.error("load config error", e);
        }
        return config;
    }
}
