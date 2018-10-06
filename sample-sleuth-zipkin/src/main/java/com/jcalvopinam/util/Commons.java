package com.jcalvopinam.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */
public class Commons {

    private static final Logger LOGGER = LoggerFactory.getLogger(Commons.class);

    private static final String TARGET = "target";
    private static final String PACKAGE_SEPARATOR = "\\/";

    public static String getArtifactName(Class clazz) {
        String artifactName = "";
        try {
            URI uri = clazz.getProtectionDomain().getCodeSource().getLocation().toURI();
            String[] path = uri.getPath().split(PACKAGE_SEPARATOR);

            for (int i = path.length - 1; i >= 0; i--) {
                if (path[i].equals(TARGET)) {
                    artifactName = path[i - 1];
                    break;
                }
            }

        } catch (URISyntaxException e) {
            LOGGER.info("Error retrieving the artifact name: {}", e.getMessage());
            return clazz.getName();
        }
        return artifactName;
    }

}
