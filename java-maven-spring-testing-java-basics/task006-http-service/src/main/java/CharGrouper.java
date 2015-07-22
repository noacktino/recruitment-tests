import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Henning Gross
 */
@RestController
public class CharGrouper {

    @Autowired
    private ArraySorter arraySorter;

    @Autowired
    private StringCompressor stringCompressor;

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    @ResponseBody
    public String group(@RequestParam String chars) {

        int[] sorted = arraySorter.sort(StringUtils.stringToIntArray(chars));
        if (sorted == null) {
            sorted = new int[0];
        }
        final String sortedString = StringUtils.intArrayToString(sorted);
        return stringCompressor.compress(sortedString);
    }
}
