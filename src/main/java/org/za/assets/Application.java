package org.za.assets;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author unakho.kama
 */
@PropertySource("classpath:application.properties")
@SpringBootApplication
//@EnableTransactionManagement
@ComponentScan(basePackages = "org.za.assets")
@RestController
public class Application implements ApplicationRunner{

    //private static final Logger logger = LogManager.getLogger(Application.class);

    private AtomicInteger count = new AtomicInteger(0);
    private void incrementAndReport(){
        System.out.println(count.incrementAndGet() + " ");
    }

    @RequestMapping("/")
    public String halloDocker() {
        return "Hello Docker I am a Prof!";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException{
        SpringApplication.run(Application.class, args);
        //SpringApplication.run(Application.class, args);
  /*      Stream<Integer> s = Stream.of(1, 2, 3);
        System.out.println(s.mapToInt(x -> x).average());OptionalDouble[2.0]

        ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);

        int year = 1904;
        LocalDate date = LocalDate.of(year, 11, 20);
        LocalTime time = LocalTime.of(11, 11);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        if (((((year % 4) == 0)) && ((year % 100) != 0)) || ((year % 400) == 0))
            System.out.println("A leap year");
        else
            System.out.println("Not a leap year");

        java -ea Application or -enableassertions instead of -ea
        java -da Application or -disableassertions instead of -da

        int numGuests = -5;
        assert numGuests > 0;
        System.out.println(numGuests);

        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            //Runnable parameter
            service.submit(() -> {
                    for(int i = 0; i < 3; i++)
                        System.out.println("Hayi jonga!" + i);

        });
            //Runnable parameter
            service.submit(() -> {
                System.out.println("Hayi wesibini!");});

            ((ScheduledExecutorService) service).schedule(() ->
                    System.out.println("x started"), 2, TimeUnit.SECONDS);
        }
        finally {
            if (service != null)
                service.shutdown();
        }
        if (service != null){
            service.awaitTermination(1, TimeUnit.MICROSECONDS);
            if (service.isTerminated())
                System.out.println("All tasks are finished");
            else
                System.out.println("At least one task still running");
                System.out.println("Yes");
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(5);

            for (int i = 0; i < 100; i++)
                service.submit(() -> {c1.getAndIncrement();c2++;});

            Thread.sleep(100);
            System.out.println(c1+ " " + c2);
        }
        finally {
            if (service != null)
                service.shutdown();
        }

        }*/
         /*ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);

            Application a = new Application();
            //Runnable parameter
            for (int i = 0; i < 10; i++){
                synchronized (a) {
                    service.submit(() -> a.incrementAndReport());
                }
            }
            //System.out.println(f.get());
        }
       catch (ExecutionException e) {
            throw new ExecutionException(e);
        }
        finally {
            if (service != null)
                service.shutdown();
        }*/
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
      /*  logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");*/
    }
}
