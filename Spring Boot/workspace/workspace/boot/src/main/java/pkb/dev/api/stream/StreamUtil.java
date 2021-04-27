package pkb.dev.api.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtil {
    public List<String> arrayTolist(String[] arr) {
        return Arrays.asList(arr).stream().sorted().collect(Collectors.toList());
    }
}
