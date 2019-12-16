package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Auther: liuxin
 * @Date: 2019/12/13 10:43
 * @Description:
 */
public class StreamStudy {


	public static void main(String[] args) {
//		createStream();
//		testString2Stream();
//		mappingTest();
//		mapTest();
//		testConcatStream();
//		testReduce1();
//		testReduce2();
//		testStatistics();
//		streamFind();
		streamMatch();
	}

	/**
	 * 创建Stream
	 */
	public static void createStream() {
		//利用Stream.of方法创建流
		Stream<String> stream = Stream.of("hello", "world", "Java8");
		stream.forEach(System.out::println);
		System.out.println("##################");

		//利用Stream.iterate方法创建流，limit限制Stream的长度
		List<Integer> stream2 = Stream.iterate(10, n -> n + 1).limit(5).collect(Collectors.toList());
		stream2.forEach(System.out::println);
		System.out.println("##################");

		//利用Stream.generate方法创建流
		List<Double> stream3 = Stream.generate(Math::random).limit(5).collect(Collectors.toList());
		stream3.forEach(System.out::println);
		System.out.println("##################");

		//从现有的集合中创建流
		List<String> strings = Arrays.asList("hello", "world", "Java8");
		String string = strings.stream().collect(Collectors.joining(","));
		System.out.println(string);

		List<Double> doubles = DoubleStream.of(1.0, 2.0, 3.0).boxed().collect(Collectors.toList());
		doubles.forEach(System.out::println);
	}

	public static void testString2Stream() {
		//使用codePoints把字符串转成Stream，在使用collect转成字符串
		String s = "hello world Java8".codePoints()
						.collect(StringBuffer::new, StringBuffer::appendCodePoint, StringBuffer::append).toString();
		//使用chars把字符串转成Stream，在使用collect转成字符串
		String s1 = "hello world Java8".chars()
						.collect(StringBuffer::new, StringBuffer::appendCodePoint, StringBuffer::append).toString();
	}

	public static void mapTest() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("Java5"));
		list.add(new Person("Java6"));
		list.add(new Person("Java7"));

		List<String> strings = list.stream().map(Person::getName).collect(Collectors.toList());
		strings.forEach(System.out::println);
	}

	public static  void mappingTest(){

		ArrayList<OrderInfo> orderArrayList = new ArrayList<>();
		orderArrayList.add(new OrderInfo("order111", "AAAA"));
		orderArrayList.add(new OrderInfo("order111", "BBBB"));
		orderArrayList.add(new OrderInfo("order222", "cccc"));
		orderArrayList.add(new OrderInfo("order222", "DDDD"));

		Map<String, List<String>> collect = orderArrayList.stream().collect(Collectors.groupingBy(OrderInfo::getOrderNo,
						Collectors.mapping(OrderInfo::getGoodsName, Collectors.toList())));

		for (String s : collect.keySet()) {
			System.out.println("key = "+s);
			collect.get(s).stream().forEach(System.out::println);
		}

	}

	public static void testConcatStream() {
		//两个流的连接
		Stream<String> first = Stream.of("sihai", "sihai2", "sihai3");
		Stream<String> second = Stream.of("sihai4", "sihai5", "sihai6");
		Stream<String> third = Stream.of("siha7", "sihai8", "sihai9");
//		Stream<String> concat = Stream.concat(first, second);
//		concat.forEach(System.out::println);
//		System.out.println("-----------------------------");
		//多个流的连接
		Stream<String> stringStream = Stream.of(first, second, third).flatMap(Function.identity());
		stringStream.forEach(System.out::println);
	}

	public static void testReduce1() {
		String[] strings = {"hello3", "sihai", "hello", "Java8"};
		long count = Arrays.stream(strings).map(String::length).count();
		System.out.println(count);
		System.out.println("##################");

		int sum = Arrays.stream(strings).mapToInt(String::length).sum();
		System.out.println(sum);
		System.out.println("##################");

		OptionalDouble average = Arrays.stream(strings).mapToInt(String::length).average();
		System.out.println(average);
		System.out.println("##################");

		OptionalInt max = Arrays.stream(strings).mapToInt(String::length).max();
		System.out.println(max);
		System.out.println("##################");

		OptionalInt min = Arrays.stream(strings).mapToInt(String::length).min();
		System.out.println(min);

		DoubleSummaryStatistics statistics = DoubleStream.generate(Math::random).limit(1000).summaryStatistics();
		System.out.println(statistics);
	}

	public static void testReduce2() {
		int sum = IntStream.range(1, 20).reduce((x, y) -> x + y).orElse(0);
		System.out.println(sum);
		System.out.println("##################");

		int sum2 = IntStream.range(1, 20).reduce(0, (x, y) -> x +2*y);
		System.out.println(sum2);
		System.out.println("##################");

		int sum3 = IntStream.range(1, 20).reduce(0, Integer::sum);
		System.out.println(sum3);
	}

	public static void testStatistics() {
		//统计数量
		String[] strings = {"hello", "sihai", "hello", "Java8"};
		long count = Arrays.stream(strings).count();
		System.out.println(count);
		System.out.println("##################");

		Long count2 = Arrays.stream(strings).collect(Collectors.counting());
		System.out.println(count2);
	}

	public static void streamFind(){
		String[] strings = {"hello", "sihai", "hello1", "Java8"};
		Optional<String> first = Arrays.stream(strings).findFirst();
		System.out.println(first.get());
		System.out.println("##################");

		Optional<String> any = Arrays.stream(strings).findAny();
		System.out.println(any.get());
	}

	public static void streamMatch(){
		boolean b = Stream.of(1, 2, 3, 4, 5, 10).anyMatch(x -> x > 5);
		System.out.println(b);
		System.out.println("##################");

		boolean b2 = Stream.of(1, 2, 3, 4, 5, 10).allMatch(x -> x > 5);
		System.out.println(b2);
		System.out.println("##################");

		boolean b3 = Stream.of(1, 2, 3, 4, 5, 10).noneMatch(x -> x > 5);
		System.out.println(b3);
	}


}
