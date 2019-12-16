package util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @Auther: liuxin
 * @Date: 2019/12/13 11:12
 * @Description:
 */
public class JSONUtil {

	public static String toJson(Map<String, List<String>> collect){
		JSONArray jsonArray = new JSONArray();
		return jsonArray.toString();
	}
}
