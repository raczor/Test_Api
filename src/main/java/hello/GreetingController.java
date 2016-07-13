package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

/**
 * Created by OscarBarrios on 7/12/2016.
 */

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting-post", method = RequestMethod.POST)
    public Greeting greetingPost(@RequestBody RequestWrapper requestWrapper) {

        StringBuilder sb = new StringBuilder();
        for(NameDto tmp : requestWrapper.getNames()){
            sb.append(", " + tmp.getName());
        }

        return new Greeting(counter.incrementAndGet(),
                String.format(template, requestWrapper.getName().getName() + " - " + sb.substring(1)));
    }

    @RequestMapping(value = "/greeting-get", method = RequestMethod.GET)
    public Greeting greetingGet(@RequestParam(value = "name", defaultValue = "Name") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/greeting-put", method = RequestMethod.PUT)
    public Greeting greetingPut(@RequestParam(value = "name", defaultValue = "Name") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
