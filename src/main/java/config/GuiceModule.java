/**
 Created by IntelliJ IDEA.
 Author: Hicham B.I.
 Date: 27/09/15
 Time: 15:43
 */

package config;

import com.google.inject.Binder;
import com.google.inject.Module;
import service.HelloService;
import service.HelloServiceImpl;

public class GuiceModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(HelloService.class).to(HelloServiceImpl.class);
    }
}
