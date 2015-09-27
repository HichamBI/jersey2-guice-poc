/**
 Created by IntelliJ IDEA.
 Author: Hicham B.I.
 Date: 27/09/15
 Time: 15:45
 */

package service;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}
