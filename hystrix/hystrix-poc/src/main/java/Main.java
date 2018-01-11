

public class Main {

    public static void main(String[] args) {
        String notFallback = new CommandHelloWorld("Dodivargas", (long) 0.5).execute();
        System.out.println(notFallback);


        String fallback = new CommandHelloWorld("Dodivargas", (long) 2).execute();
        System.out.println(fallback);
    }
}
