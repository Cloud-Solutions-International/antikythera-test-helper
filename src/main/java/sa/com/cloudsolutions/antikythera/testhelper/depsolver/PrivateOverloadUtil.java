package sa.com.cloudsolutions.antikythera.testhelper.depsolver;

import static sa.com.cloudsolutions.antikythera.testhelper.depsolver.FormatConstants.DEFAULT_FORMAT;
import static sa.com.cloudsolutions.antikythera.testhelper.depsolver.FormatConstants.ALT_FORMAT;
import static sa.com.cloudsolutions.antikythera.testhelper.depsolver.FormatConstants.FULL_FORMAT;

/**
 * Test helper class that has public methods calling private overloads.
 * The pattern here mirrors DateScheduleUtil:
 * - There is a PUBLIC no-arg version of formatDate()
 * - There are PRIVATE overloads (with args) of the same name
 * - Public methods call the private overloads using static import constants
 *   (which cannot be resolved by the dependency analyzer, forcing count-based matching)
 */
public class PrivateOverloadUtil {

    // Public no-arg version - same name as private overloads below
    public String formatDate() {
        return DEFAULT_FORMAT;
    }

    // Public methods that call the private overloads with static import constants
    public String getDate() {
        return formatDate(DEFAULT_FORMAT);
    }

    public String getAltDate() {
        return formatDate(ALT_FORMAT);
    }

    public String getFullDate() {
        return formatDate(FULL_FORMAT);
    }

    // Private 1-arg overload - shares name with public no-arg
    private String formatDate(String format) {
        return format + ":formatted";
    }

    // Public method calling a 2-arg private overload
    public String getDateWithOffset(String value, int offset) {
        return formatDate(value, offset);
    }

    // Private 2-arg overload - shares name with public no-arg and private 1-arg
    private String formatDate(String value, int offset) {
        return value + "+" + offset;
    }
}
