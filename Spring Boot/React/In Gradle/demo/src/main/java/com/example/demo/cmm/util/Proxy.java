package com.example.demo.cmm.util;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component
public class Proxy {

	public static Consumer<String> print = System.out::print;
	public static Function<Object, String> string = String::valueOf;
	public static Function<String, Integer> integer = Integer::parseInt;
	public static Function<Double, Double> doubleAbs = Math::abs;
	public static Function<Float, Float> floatAbs = Math::abs;
	public static Function<Integer, Integer> intAbs = Math::abs;
	public static Function<Long, Long> longAbs = Math::abs;
	public static Function<Double, Double> ceil = Math::ceil;
	public static Function<Double, Double> floor = Math::floor;
	public static BiFunction<Double, Double, Double> doubleMax = Math::max;
	public static BiFunction<Float, Float, Float> floatMax = Math::max;
	public static BiFunction<Integer, Integer, Integer> intMax = Math::max;
	public static BiFunction<Long, Long, Long> longMax = Math::max;
	public static BiFunction<Double, Double, Double> doubleMin = Math::min;
	public static BiFunction<Float, Float, Float> floatMin = Math::min;
	public static BiFunction<Integer, Integer, Integer> intMin = Math::min;
	public static BiFunction<Long, Long, Long> longMin = Math::min;
	public static Supplier<Double> random = Math::random;
	public static Function<Double, Double> rint = Math::rint;
	public static Function<Double, Long> doubleRound = Math::round;
	public static Function<Float, Integer> floatRound = Math::round;
	
	public static Function<String, Byte> b = Byte::parseByte;
	public static Function<String, Short> s = Short::parseShort;
	public static Function<String, Integer> i = Integer::parseInt;
	public static Function<String, Long> l = Long::parseLong;
	public static Function<String, Float> f = Float::parseFloat;
	public static Function<String, Double> d = Double::parseDouble;
	public static Function<String, Byte> B = Byte::valueOf;
	public static Function<String, Short> S = Short::valueOf;
	public static Function<String, Integer> I = Integer::valueOf;
	public static Function<String, Long> L = Long::valueOf;
	public static Function<String, Float> F = Float::valueOf;
	public static Function<String, Double> D = Double::valueOf;
	
	public static Function<String, Integer> i2 = Integer::parseInt;
	public static Function<String, Integer> i3 = Integer::valueOf;
	public static BiFunction<String, Integer, Integer> i4 = Integer::parseInt;
}
