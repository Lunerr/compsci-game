package Utility;

import java.util.Comparator;

import org.json.simple.JSONObject;

public class Sort_Ascending implements Comparator<JSONObject> {
   @Override
   public int compare(JSONObject a, JSONObject b) {
      return (int)a.get("odds") - (int)b.get("odds");
   }
}
