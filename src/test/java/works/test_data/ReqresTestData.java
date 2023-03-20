package works.test_data;

import java.util.HashMap;
import java.util.Map;

public class ReqresTestData {

    public Map<String, Object> expectedDataMethod(String name, String job){
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("name", name);
        expectedData.put("job", job);

        return expectedData;
    }

}
