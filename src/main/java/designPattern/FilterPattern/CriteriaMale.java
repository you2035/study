package designPattern.FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 10:41
 * @Description:
 */
public class CriteriaMale implements Criteria {
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> malePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if(person.getGender().equalsIgnoreCase("MALE")){
				malePersons.add(person);
			}
		}
		return malePersons;
	}
}
