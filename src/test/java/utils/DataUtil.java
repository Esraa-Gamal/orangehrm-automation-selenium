package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class DataUtil {
    private static final String DATA_PATH = "src/test/resources/data/dynamicData.json";

    public static JsonNode getData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(new File(DATA_PATH));
    }
}
