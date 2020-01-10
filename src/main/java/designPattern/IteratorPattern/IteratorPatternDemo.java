package designPattern.IteratorPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 17:07
 * @Description: 迭代器模式
 */
public class IteratorPatternDemo {
	public static void main(String[] args) {
		NameRepository namesRepository = new NameRepository();

		for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
			String name = (String)iter.next();
			System.out.println("Name : " + name);
		}
	}
}
