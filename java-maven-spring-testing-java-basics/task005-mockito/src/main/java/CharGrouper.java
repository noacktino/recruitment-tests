import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henning Gross
 */
@Service
public class CharGrouper {

    @Autowired
    private ArraySorter arraySorter;

    @Autowired
    private StringCompressor stringCompressor;

    public String group(String chars) {

        int[] sorted = arraySorter.sort(StringUtils.stringToIntArray(chars));
        if (sorted == null) {
            sorted = new int[0];
        }
        final String sortedString = StringUtils.intArrayToString(sorted);
        return stringCompressor.compress(sortedString);
    }
}
