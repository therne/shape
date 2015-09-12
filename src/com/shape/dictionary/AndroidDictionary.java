package com.shape.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidDictionary {

    private static final Map<String, String>
            classNames = new HashMap<>(),
            attrs = new HashMap<>();

    static {
        /**
         * Class Name Aliases
         */

        // Layouts
        classNames.put("linear", "LinearLayout");
        classNames.put("relative", "RelativeLayout");
        classNames.put("frame", "FrameLayout");
        classNames.put("table", "TableLayout");
        classNames.put("row", "TableRow");

        // Widget
        classNames.put("text", "TextView");
        classNames.put("button", "Button");
        classNames.put("radio", "RadioButton");
        classNames.put("check", "CheckBox");
        classNames.put("switch", "Switch");
        classNames.put("toggle", "ToggleButton");
        classNames.put("imagebutton", "ImageButton");
        classNames.put("image", "ImageView");
        classNames.put("progress", "ProgressBar");
        classNames.put("seek", "SeekBar");
        classNames.put("rating", "RatingBar");
        classNames.put("spinner", "Spinner");
        classNames.put("web", "WebView");
        classNames.put("edit", "EditText");

        // Containers
        classNames.put("radiogroup", "RadioGroup");
        classNames.put("list", "ListView");
        classNames.put("gridview", "GridView");
        classNames.put("expandablelist", "ExpandableListView");
        classNames.put("scroll", "ScrollView");
        classNames.put("search", "SearchView");
        classNames.put("tabhost", "TabHost");
        classNames.put("video", "VideoView");

        // Others
        classNames.put("include", "include");
        classNames.put("view", "View");
        classNames.put("space", "Space");

        // Support library
        classNames.put("recycler", "android.support.v7.widget.RecyclerView");
        classNames.put("card", "android.support.v7.widget.CardView");
        classNames.put("viewpager", "android.support.v4.ViewPager");
        classNames.put("gridlayout", "android.support.v7.widget.GridLayout");

        /**
         * Attribute aliases
         */

        attrs.put("width", "layout_width");
        attrs.put("height", "layout_height");
        attrs.put("weight", "layout_weight");
        attrs.put("margin", "layout_margin");
        attrs.put("marginTop", "layout_marginTop");
        attrs.put("marginLeft", "layout_marginLeft");
        attrs.put("marginRight", "layout_marginRight");
        attrs.put("marginBottom", "layout_marginBottom");
        attrs.put("marginStart", "layout_marginStart");
        attrs.put("marginEnd", "layout_marginEnd");
        attrs.put("layoutGravity", "layout_gravity");

        /**
         * Param-aliasable attribute names
         */
//        aliasableAttrs.add("layout_width");
//        aliasableAttrs.add("layout_height");

        /**
         * Param aliases
         */
//        params.put("match", "match_parent");
//        params.put("wrap", "wrap_content");
//        params.put("fill_parent", "match_parent"); // NO LEGACY!
    }

    public static String widgetName(String lessName) {
        String convertedValue = classNames.get(lessName.toLowerCase());
        if (convertedValue == null) {
            convertedValue = Character.toUpperCase(lessName.charAt(0)) + lessName.substring(1);
        }
        return convertedValue;
    }
    
    public static String attributeName(String lessName) {
        return attrs.getOrDefault(lessName, lessName);
    }

//    @Deprecated
//    public static boolean isAliasableAttr(String attrName) {
//        return aliasableAttrs.contains(attrName);
//    }
//
//    @Deprecated
//    public static String param(String value) {
//        return params.getOrDefault(value, value);
//    }
}
