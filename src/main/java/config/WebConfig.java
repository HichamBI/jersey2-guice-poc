/**
 Created by IntelliJ IDEA.
 Author: Hicham B.I.
 Date: 27/09/15
 Time: 16:11
 */

package config;

import com.google.inject.Guice;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;


@ApplicationPath("/resource/*")
public class WebConfig extends ResourceConfig {

    @Inject
    public WebConfig(ServiceLocator serviceLocator) {
        packages("resource");
        createGuiceBridge(serviceLocator);
    }

    private void createGuiceBridge(ServiceLocator serviceLocator) {
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(Guice.createInjector(new GuiceModule()));
    }
}