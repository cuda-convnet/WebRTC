package com.webrtc.netty.common;

import java.io.IOException;
 
import java.util.List;

import com.webrtc.netty.manager.WcsUserManager;
import com.webrtc.wcs.dao.WcsUser;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtil {
  
  public static<T> Object JSONToObj(String jsonStr,Class<T> obj) {
    T t = null;
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      t = objectMapper.readValue(jsonStr,
          obj);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return t;
  }
 
  public static<T> JSONObject objectToJson(T obj) throws JSONException, IOException {
    ObjectMapper mapper = new ObjectMapper(); 
    // Convert object to JSON string 
    String jsonStr = "";
    try {
       jsonStr = mapper.writeValueAsString(obj);
    } catch (IOException e) {
      throw e;
    }
    return new JSONObject(jsonStr);
  }
  public static void main(String[] args) throws JSONException, IOException {

    List<WcsUser> aaa = WcsUserManager.findWcsUserByUser_Id("9999");
    JSONArray jsons = new JSONArray();
    
    for(int index=0; index<aaa.size(); index++){
       JSONObject jo = objectToJson(aaa.get(index));
       jsons.put(jo);
    }
    
    JSONObject result = new JSONObject();
    result.put("result", jsons);
    System.out.println(result.toString());
    
  }
}