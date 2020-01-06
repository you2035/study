package designPattern.FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 10:42
 * @Description:
 */
public class CriteriaSingle implements Criteria {
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> singlePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
				singlePersons.add(person);
			}
		}
		return singlePersons;
	}
}
