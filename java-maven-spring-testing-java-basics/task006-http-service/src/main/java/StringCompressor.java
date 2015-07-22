import org.springframework.stereotype.Service;

/**
 * @author Henning Gross
 */
@Service
public class StringCompressor {

    public String compress(String uncompressed) {

        // stringbuilder for result
        StringBuilder compressedStringBuilder = new StringBuilder();

        // count equal chars
        int charCount = 0;

        // remember last char
        char lastChar = 0;

        // get chars
        char[] chars = uncompressed.toCharArray();
        // iterate over chars
        for (char currentChar : chars) {

            // current char
            // if its the same as the previous (or no previous), increment counter
            if (currentChar == lastChar || lastChar == 0) {
                charCount++;
            } else {

                // append previous char
                buildSegmentAndAppend(compressedStringBuilder, lastChar, charCount);

                // reset counter
                charCount = 1;
            }
            lastChar = currentChar;
        }

        if (lastChar != 0) {
            buildSegmentAndAppend(compressedStringBuilder, lastChar, charCount);
        }

        // return compressed string only if shorter than original
        String compressedString = compressedStringBuilder.toString();
        if (compressedString.length() < uncompressed.length()) {
            return compressedString;
        }
        return uncompressed;
    }

    private StringBuilder buildSegmentAndAppend(StringBuilder builder, char lastChar, int charCount) {
        StringBuilder result = builder.append(lastChar);
        if (charCount != 1) {
            result.append(charCount);
        }
        return result;
    }
}
