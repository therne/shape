package com.shape.dictionary;

import com.shape.util.Dictionary;

public class AndroidDictionary {

    public static final String RESOURCE_TYPES[] = new String[] {
        "anim", "animator", "bool", "color", "drawable", "dimen", "id", "integer",
                "layout", "menu", "string", "style"
    };

    private static final Dictionary<String, String>
            SHP_TO_XML_CLASS_NAMES = new Dictionary<String, String>(),
            SHP_TO_XML_ATTRS = new Dictionary<String, String>(),
            SHP_TO_XML_PARAMS = new Dictionary<String, String>(),
            XML_TO_SHP_CLASS_NAMES = new Dictionary<String, String>(),
            XML_TO_SHP_ATTRS = new Dictionary<String, String>(),
            XML_TO_SHP_PARAMS = new Dictionary<String, String>();

    private static final String FOUR_SIDES[] = {"Top", "Left", "Right", "Bottom", "Start", "End"};

    static {
        /**
         * Class Name Aliases
         */
        // Layouts
        addClassName("AbsoluteLayout", "Absolute");
        addClassName("LinearLayout", "Linear");
        addClassName("RelativeLayout", "Relative");
        addClassName("FrameLayout", "Frame");
        addClassName("TableLayout", "Table");
        addClassName("TableRow", "Row");

        // Widget
        addClassName("TextView", "Text");
        addClassName("Button", "Button");
        addClassName("RadioButton", "Radio");
        addClassName("CheckBox", "Check");
        addClassName("Switch", "Switch");
        addClassName("ToggleButton", "Toggle");
        addClassName("ImageButton");
        addClassName("ImageView", "Image");
        addClassName("ProgressBar", "Progress");
        addClassName("SeekBar", "Seek");
        addClassName("RatingBar", "Rating");
        addClassName("Spinner", "Spinner");
        addClassName("WebView", "Web");
        addClassName("EditText", "Edit");
        addClassName("CalendarView", "Calendar");

        // Containers
        addClassName("RadioGroup", "Radiogroup");
        addClassName("ListView", "List");
        addClassName("GridView", "GridView");
        addClassName("ExpandableListView", "ExpandableList");
        addClassName("ScrollView", "Scroll");
        addClassName("SearchView", "Search");
        addClassName("TabHost", "TabHost");
        addClassName("TabView", "Tab");
        addClassName("VideoView", "Video");

        /**
         * Attribute aliases
         */
        addAttr("context");
        addAttr("text");
        addAttr("textSize");
        addAttr("label");
        addAttr("hint");
        addAttr("prompt");
        addAttr("onClick");
        addAttr("inputType");
        addAttr("inputMethod");
        addAttr("layout_gravity", "layoutGravity");
        addAttr("layout_width", "width");
        addAttr("layout_height", "height");
        addAttr("layout_weight", "weight");
        addAttr("padding");
        addAttr("paddingTop");
        addAttr("paddingBottom");
        addAttr("paddingLeft");
        addAttr("paddingRight");
        addAttr("paddingStart");
        addAttr("paddingEnd");
        addAttr("foreground");
        addAttr("background");
        addAttr("orientation");
        addAttr("layout");
        addAttr("rowCount");
        addAttr("columnCount");
        addAttr("labelFor");
        addAttr("baselineAligned");
        addAttr("contentDescription");
        addAttr("imeActionLabel");
        addAttr("privateImeOptions");
        addAttr("numeric");
        addAttr("imeActionId");
        addAttr("imeOptions");
        addAttr("freezesText");
        addAttr("editorExtras");
        addAttr("editable");
        addAttr("digits");
        addAttr("cursorVisible");
        addAttr("capitalize");
        addAttr("phoneNumber");
        addAttr("password");
        addAttr("bufferType");
        addAttr("autoText");
        addAttr("enabled");
        addAttr("singleLine");
        addAttr("scaleType");
        addAttr("visibility");
        addAttr("textIsSelectable");
        addAttr("importantForAccessibility");
        addAttr("listPreferredItemPaddingLeft");
        addAttr("listPreferredItemPaddingRight");
        addAttr("listPreferredItemPaddingStart");
        addAttr("listPreferredItemPaddingEnd");
        addAttr("index");

        // AbsoluteLayout layout params
        addAttr("layout_y", "y");
        addAttr("layout_x", "x");

        // GridLayout layout params
        addAttr("layout_row", "row");
        addAttr("layout_rowSpan", "rowSpan");
        addAttr("layout_column", "column");
        addAttr("layout_columnSpan", "columnSpan");

        // TableRow
        addAttr("span", "layout_span");

        // RelativeLayout layout params:
        addFourSideAttr("layout_align", "align");
        addFourSideAttr("layout_alignParent", "alignParent");
        addAttr("layout_alignWithParentIfMissing", "alignWithParentIfMissing");
        addAttr("layout_alignBaseline", "alignBaseline");
        addAttr("layout_centerInParent", "centerInParent");
        addAttr("layout_centerVertical", "centerVertical");
        addAttr("layout_centerHorizontal", "centerHorizontal");
        addAttr("layout_toRightOf", "toRightOf");
        addAttr("layout_toLeftOf", "toLeftOf");
        addAttr("layout_toStartOf", "toStartOf");
        addAttr("layout_toEndOf", "toEndOf");
        addAttr("layout_below", "below");
        addAttr("layout_above", "above");

        // Margins
        addAttr("layout_margin", "margin");
        addFourSideAttr("layout_margin", "margin");

        // Attributes: Drawables
        addAttr("tileMode");

        // Attributes: CoordinatorLayout
        addAttr("layout_anchor", "anchor");
        addAttr("layout_anchorGravity", "anchorGravity");
        addAttr("layout_behavior", "behavior");
        addAttr("layout_keyline", "keyline");

        addAttr("tag");
        addAttr("numColumns");

        addAttr("handle");
        addAttr("content");
        addAttr("checked");

        addFourSideAttr("drawable"); // drawableTop, drawableBottom...
        addAttr("drawablePadding");

        addAttr("useDefaultMargins");
        addAttr("marginsIncludedInAlignment");
        addAttr("src");
        addAttr("gravity");
        addAttr("weightSum");
        addAttr("ems");

        /**
         * Parameter aliases
         */
        addParam("match_parent", "match");
        addParam("wrap_content", "wrap");

        // Force convert fill_parent to match_parent
        XML_TO_SHP_PARAMS.put("fill_parent", "match");
    }

    /**
     * Converts Shape class name to original Android class name.
     * @param shapeName Shape class name (ex: Linear)
     * @return Original class name (ex: LinearLayout)
     */
    public static String originalClassName(String shapeName) {
        return SHP_TO_XML_CLASS_NAMES.get(shapeName, shapeName);
    }

    /**
     * Converts original Android class name to Shape class name.
     * @param originalName Original class name (ex: LinearLayout)
     * @return Shape class name (ex: Linear)
     */
    public static String shapeClassName(String originalName) {
        return XML_TO_SHP_CLASS_NAMES.get(originalName, originalName);
    }

    public static String originalAttrName(String lessName) {
        return SHP_TO_XML_ATTRS.get(lessName, lessName);
    }
    
    public static String shapeAttrName(String originalName) {
        return XML_TO_SHP_ATTRS.get(originalName, originalName);
    }

    public static String originalParam(String lessName) {
        return SHP_TO_XML_PARAMS.get(lessName, lessName);
    }

    public static String shapeParam(String originalName) {
        return XML_TO_SHP_PARAMS.get(originalName, originalName);
    }

    /**
     * Methods to support bi-directional converting.
     */
    private static void addFourSideAttr(String origPrefix, String shpPrefix) {
        for (String side : FOUR_SIDES) addAttr(origPrefix + side, shpPrefix + side);
    }

    private static void addFourSideAttr(String origPrefix) {
        addFourSideAttr(origPrefix, origPrefix);
    }

    private static void addAttr(String origName, String shpName) {
        SHP_TO_XML_ATTRS.put(shpName, origName);
        XML_TO_SHP_ATTRS.put(origName, shpName);
    }

    private static void addAttr(String origName) {
        addAttr(origName, origName);
    }

    private static void addClassName(String origName, String shpName) {
        SHP_TO_XML_CLASS_NAMES.put(shpName, origName);
        XML_TO_SHP_CLASS_NAMES.put(origName, shpName);
    }

    private static void addClassName(String origName) {
        addClassName(origName, origName);
    }

    private static void addParam(String origName, String shpName) {
        SHP_TO_XML_PARAMS.put(shpName, origName);
        XML_TO_SHP_PARAMS.put(origName, shpName);
    }

    private static void addParam(String origName) {
        addParam(origName, origName);
    }

}
