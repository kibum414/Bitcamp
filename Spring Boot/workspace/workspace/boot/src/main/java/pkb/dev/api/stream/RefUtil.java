package pkb.dev.api.stream;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RefUtil {
    public static Consumer<String> print = System.out::print;
    public static Function<Object, String> objToStr = String::valueOf;

    public static Function<Double, Double> absDouble = Math::abs;
    public static Function<Float, Float> absFloat = Math::abs;
    public static Function<Integer, Integer> absInt = Math::abs;
    public static Function<Long, Long> absLong = Math::abs;
    public static Function<Double, Double> ceil = Math::ceil;
    public static Function<Double, Double> floor = Math::floor;
    public static BiFunction<Double, Double, Double> maxDouble = Math::max;
    public static BiFunction<Float, Float, Float> maxFloat = Math::max;
    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
    public static BiFunction<Long, Long, Long> maxLong = Math::max;
    public static BiFunction<Double, Double, Double> minDouble = Math::min;
    public static BiFunction<Float, Float, Float> minFloat = Math::min;
    public static BiFunction<Integer, Integer, Integer> minInt = Math::min;
    public static Supplier<Double> random = Math::random;
    public static BiFunction<Integer, Integer, Integer> rangeUnderRandom = (t, u) -> (int) (Math.random() * (u - t)) + t;
    public static BiFunction<Integer, Integer, Integer> rangeBelowRandom = (t, u) -> (int) (Math.random() * (u - t + 1)) + t;
    public static Function<Double, Double> rint = Math::rint;
    public static Function<Double, Long> roundDouble = Math::round;
    public static Function<Float, Integer> roundFloat = Math::round;

    public static Function<String, Byte> strToByte = Byte::parseByte;
    public static Function<String, Short> strToShort = Short::parseShort;
    public static Function<String, Integer> strToInt = Integer::parseInt;
    public static Function<String, Long> strToLong = Long::parseLong;
    public static Function<String, Float> strToFloat = Float::parseFloat;
    public static Function<String, Double> strToDouble = Double::parseDouble;

    public static BiFunction<String, String, Boolean> equals = String::equals;
}
