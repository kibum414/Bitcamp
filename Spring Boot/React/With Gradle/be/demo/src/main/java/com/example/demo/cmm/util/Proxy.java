package com.example.demo.cmm.util;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.example.demo.uss.domain.Admin;
import com.example.demo.uss.domain.User;

@Component
public class Proxy {
	public static Consumer<String> print = System.out::print;
	public static Function<Object, String> string = String::valueOf;
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
	public static Supplier<Double> random = Math::random;
	public static BiFunction<Integer, Integer, Integer> rangeUnderRandom = (t, u) -> (int) (Math.random() * (u - t)) + t;
	public static BiFunction<Integer, Integer, Integer> rangeBelowRandom = (t, u) -> (int) (Math.random() * (u - t + 1)) + t;
	public static Function<Double, Double> rint = Math::rint;
	public static Function<Double, Long> doubleRound = Math::round;
	public static Function<Float, Integer> floatRound = Math::round;
	
	public static Function<String, Byte> str2byte = Byte::parseByte;
	public static Function<String, Short> str2short = Short::parseShort;
	public static Function<String, Integer> str2int = Integer::parseInt;
	public static Function<String, Long> str2long = Long::parseLong;
	public static Function<String, Float> str2float = Float::parseFloat;
	public static Function<String, Double> str2double = Double::parseDouble;

	public static Supplier<User> newUser = User::new;
	public static Supplier<Admin> newAdmin = Admin::new;
}
