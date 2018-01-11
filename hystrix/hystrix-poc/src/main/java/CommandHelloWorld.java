import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class CommandHelloWorld extends HystrixCommand<String> {

    private static String name;
    private static Long time;
    private static String fallback = "isso é um fallback";
    private static String examplegroup = "ExampleGroup";
    private static String hello = "hello";

    public CommandHelloWorld(String name,Long time) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(examplegroup))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(1000)));
        this.name = name;
        this.time = time;
    }

    @Override
    protected String run() {
        try {
            Thread.sleep(time * 1000);
        }catch (InterruptedException e){

        }
        return hello + name ;
    }

    @Override
    protected String getFallback(){


        return fallback;
    }
}
