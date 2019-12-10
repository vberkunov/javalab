package ua.procamp;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class CrazyLambdas {


    public static Supplier<String> helloSupplier() {
        return () -> "Hello";
    }


    public static Predicate<String> isEmptyPredicate() {
        return String::isEmpty;
    }


    public static Function<BigDecimal, String> toDollarStringFunction() {
        return bigDecimal -> "$" + bigDecimal;
    }


    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        return str -> str.length() >= min && str.length() < max;
    }


    public static IntSupplier randomIntSupplier() {
        return () -> ThreadLocalRandom.current().nextInt();
    }



    public static IntUnaryOperator boundedRandomIntSupplier() {
        return bound -> ThreadLocalRandom.current().nextInt(bound);
    }


    public static IntUnaryOperator intSquareOperation() {
        return a -> a * a;
    }


    public static LongBinaryOperator longSumOperation() {
        return (a, b) -> a + b;
    }


    public static ToIntFunction<String> stringToIntConverter() {
        return Integer::parseInt;
    }


    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {
        return () -> a -> n * a;
    }


    public static Supplier<Thread> runningThreadSupplier(Runnable runnable) {
        return () -> {
            Thread thread = new Thread(runnable);
            thread.start();
            return thread;
        };
    }


    public static Consumer<Runnable> newThreadRunnableConsumer() {
        return runnable -> new Thread(runnable).start();
    }


    public static Function<Runnable, Supplier<Thread>> runnableToThreadSupplierFunction() {
        return runnable -> () -> {
            Thread thread = new Thread(runnable);
            thread.start();
            return thread;
        };
    }


    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        return (intOperation, intPredicate) -> a -> intPredicate.test(a) ? intOperation.applyAsInt(a) : a;
    }


    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        return () -> () -> () -> "WELL DONE!";
    }
}