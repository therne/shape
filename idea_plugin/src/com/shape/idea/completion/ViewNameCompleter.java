package com.shape.idea.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.IconLoader;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.shape.idea.psi.ShapeAttrKey;
import com.shape.idea.psi.ShapeTypes;
import com.shape.idea.psi.ShapeViewName;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ViewNameCompleter extends CompletionProvider<CompletionParameters> {

    private static final String[] VIEW_NAMES = new String[] {
            "AnalogClock", "AutoCompleteText", "Button", "Calendar", "CheckBox", "CheckedText",
            "Chronometer", "DatePicker", "DeviceScreen", "DialerFilter", "DigitalClock", "Edit",
            "ExpandableList", "Fragment", "Frame", "Gallery", "GestureOverlay", "GridLayout",
            "GridView", "HorizontalScroll", "Image", "ImageButton", "include", "Linear", "List",
            "MediaController", "merge", "MultiAutoCompleteText", "NumberPicker", "ProgressBar",
            "QuickContactBadge", "Radio", "RadioGroup", "RatingBar", "Relative", "requestFocus",
            "Scroll", "Search", "SeekBar", "SlidingDrawer", "Space", "Spinner", "StackView",
            "SurfaceView", "Switch", "TabHost", "TableLayout", "TableRow", "TabWidget",
            "Text", "TextClock", "TextSwitcher", "TextureView", "TimePicker", "ToggleButton",
            "VideoView", "View", "ViewFlipper", "WebView", "ZoomButton", "ZoomControls"
    };

    private static ArrayList<LookupElement> lookupCache;

    static PsiElementPattern.Capture<PsiElement> pattern() {
        return PlatformPatterns.psiElement()
                .withElementType(ShapeTypes.IDENTIFIER)
                .withSuperParent(3, ShapeViewName.class);
    }

    private Icon getIconOrDefault(String name) {
        String path = "/icons/views/" + name + ".png";
        if (getClass().getClassLoader().getResource(path) == null) {
            path = "/icons/views/customView.png";
        }
        return IconLoader.getIcon(path);
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters completionParameters,
                                  ProcessingContext processingContext,
                                  @NotNull CompletionResultSet resultSet) {

        if (lookupCache == null) {
            lookupCache = new ArrayList<>();
            for (String name : VIEW_NAMES) {
                lookupCache.add(LookupElementBuilder.create(name)
                        .withInsertHandler((context, lookupElement) -> {
                            Editor editor = context.getEditor();
                            int cursorOffset = editor.getCaretModel().getOffset();
                            editor.getDocument().insertString(cursorOffset, " (");
                            editor.getCaretModel().moveToOffset(cursorOffset + 2);
                        })
                        .withIcon(getIconOrDefault(name)));
            }
        }
        resultSet.addAllElements(lookupCache);
    }
}
