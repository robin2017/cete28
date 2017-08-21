package robin_permission_check.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by robin on 2017/8/21.
 */
public class PermissionData {
    public  static Map<String,List<String>> maps=new HashMap<String,List<String>>();
    static {
        List<String> permissions=new ArrayList<String>();
        permissions.add("save");
//        permissions.add("update");
        maps.put("zhangshan",permissions);
    }
}
