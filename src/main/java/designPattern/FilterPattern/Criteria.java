package designPattern.FilterPattern;

import java.util.List;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 10:40
 * @Description:
 */
public interface Criteria {
	public List<Person> meetCriteria(List<Person> persons);
}
