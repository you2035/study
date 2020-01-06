package designPattern.FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 10:41
 * @Description:
 */
public class CriteriaFemale implements Criteria {
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
			List<Person> femalePersons = new ArrayList<Person>();
			for (Person person : persons) {
				if(person.getGender().equalsIgnoreCase("FEMALE")){
					femalePersons.add(person);
				}
			}
			return femalePersons;
	}
}
