package day06.homework.rpcrobin.net_client;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import day06.homework.rpcrobin.net_common.IdPassException;
import day06.homework.rpcrobin.net_common.User;
import day06.homework.rpcrobin.net_common.UserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static day06.homework.rpcrobin.net_common.NetConstant.*;


/**
 * Created by robin on 2017/8/9.
 */
public class UserServiceClientProxyJSON implements UserService {
    @Override
    public User login(Integer id, String password) throws IdPassException {
        JSONObject request = new JSONObject();
        request.put(REQUEST_METHOD_NAME, "login");
        JSONArray paramsTypes = new JSONArray();
        paramsTypes.add(REQUEST_TYPE_INTEGER);
        paramsTypes.add(REQUEST_TYPE_STRING);
        request.put(REQUEST_PARAM_TYPES, paramsTypes);
        JSONArray objects = new JSONArray();
        objects.add(id);
        objects.add(password);
        request.put(REQUEST_OBJECTS, objects);
        JSONObject response = SocketUtil.remoteCallJson(request);
        if ((Boolean) response.get(RESPONSE_SUCCESS)) {
            JSONObject jsonObject = (JSONObject) JSON.parse((String) response.get("object"));
            User user = JSONObject.toJavaObject(jsonObject, User.class);
            return user;
        }
        throw new IdPassException((String) response.get(RESPONSE_EXCEPTIION));
    }

    @Override
    public List<User> getAllUsers() {
        JSONObject request = new JSONObject();
        request.put(REQUEST_METHOD_NAME, "getAllUsers");
        JSONObject response = SocketUtil.remoteCallJson(request);
        if ((Boolean) response.get(RESPONSE_SUCCESS)) {
            String array = (String) response.get(RESPONSE_OBJECT);
            List<JSONObject> list = parseJsonArrayToObjectList(array);
            List<User> result = new ArrayList<User>();
            for (JSONObject object : list) {
                result.add(JSON.toJavaObject(object, User.class));
            }
            return result;
        }
        return null;
    }

    private List<JSONObject> parseJsonArrayToObjectList(String data) {
        List<JSONObject> list = new ArrayList<JSONObject>();
        JSONArray jsonArray = JSON.parseArray(data);
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            list.add(jsonObject);
        }
        return list;
    }

    @Override
    public String getNameById(Integer id) {
        JSONObject request = new JSONObject();
        request.put(REQUEST_METHOD_NAME, "getNameById");
        JSONArray paramTypes = new JSONArray();
        paramTypes.add(REQUEST_TYPE_INTEGER);
        request.put(REQUEST_PARAM_TYPES, paramTypes);
        JSONArray objects = new JSONArray();
        objects.add(id);
        request.put(REQUEST_OBJECTS, objects);
        JSONObject response = SocketUtil.remoteCallJson(request);
        if ((Boolean) response.get(RESPONSE_SUCCESS)) {
            return (String) response.get(RESPONSE_OBJECT);
        }
        return null;
    }
}
