package com.shape.idea.parser;

import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.WhitespacesBinders;
import com.intellij.lang.impl.PsiBuilderAdapter;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.resolve.FileContextUtil;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.indexing.IndexingDataKeys;
import com.shape.idea.psi.ShapeTypes;
import gnu.trove.TObjectIntHashMap;
import gnu.trove.TObjectIntProcedure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ShapeParsingUtil extends GeneratedParserUtilBase {
    private static final Key<TObjectIntHashMap<String>> MODES_KEY = Key.create("MODES_KEY");

    @NotNull
    private static TObjectIntHashMap<String> getParsingModes(@NotNull PsiBuilder builder_) {
        TObjectIntHashMap<String> flags = builder_.getUserDataUnprotected(MODES_KEY);
        if (flags == null) builder_.putUserDataUnprotected(MODES_KEY, flags = new TObjectIntHashMap<String>());
        return flags;
    }

    public static boolean consumeBlock(PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level) {
        PsiFile file = builder_.getUserDataUnprotected(FileContextUtil.CONTAINING_FILE_KEY);
        if (file == null) return false;
        VirtualFile data = file.getUserData(IndexingDataKeys.VIRTUAL_FILE);
        if (data == null) return false;
        int i = 0;
        PsiBuilder.Marker m = builder_.mark();
        do {
            IElementType type = builder_.getTokenType();
            i += type == ShapeTypes.LBRACE ? 1 : type == ShapeTypes.RBRACE ? -1 : 0;
            builder_.advanceLexer();
        }
        while (i > 0 && !builder_.eof());
        boolean result = i == 0;
        if (result) {
            m.drop();
        }
        else {
            m.rollbackTo();
        }
        return result;
    }

    public static boolean emptyImportList(PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level) {
        PsiBuilder.Marker marker = getCurrentMarker(builder_ instanceof PsiBuilderAdapter ? ((PsiBuilderAdapter)builder_).getDelegate() : builder_);
        if (marker != null) {
            marker.setCustomEdgeTokenBinders(WhitespacesBinders.GREEDY_LEFT_BINDER, null);
        }
        return true;
    }

    public static boolean isModeOn(@NotNull PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level, String mode) {
        return getParsingModes(builder_).get(mode) > 0;
    }

    public static boolean withOn(PsiBuilder builder_, int level_, String mode, GeneratedParserUtilBase.Parser parser) {
        return withImpl(builder_, level_, mode, true, parser, parser);
    }

    public static boolean withOff(PsiBuilder builder_, int level_, GeneratedParserUtilBase.Parser parser, String... modes) {
        final TObjectIntHashMap<String> map = getParsingModes(builder_);

        TObjectIntHashMap<String> prev = new TObjectIntHashMap<String>();

        for (String mode : modes) {
            int p = map.get(mode);
            if (p > 0) {
                map.put(mode, 0);
                prev.put(mode, p);
            }
        }

        boolean result = parser.parse(builder_, level_);

        prev.forEachEntry(new TObjectIntProcedure<String>() {
            @Override
            public boolean execute(String mode, int p) {
                map.put(mode, p);
                return true;
            }
        });

        return result;
    }

    private static boolean withImpl(PsiBuilder builder_, int level_, String mode, boolean onOff, GeneratedParserUtilBase.Parser whenOn, GeneratedParserUtilBase.Parser whenOff) {
        TObjectIntHashMap<String> map = getParsingModes(builder_);
        int prev = map.get(mode);
        boolean change = ((prev & 1) == 0) == onOff;
        if (change) map.put(mode, prev << 1 | (onOff ? 1 : 0));
        boolean result = (change ? whenOn : whenOff).parse(builder_, level_);
        if (change) map.put(mode, prev);
        return result;
    }


    public static boolean exitMode(@NotNull PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level, String mode, boolean safe) {
        TObjectIntHashMap<String> flags = getParsingModes(builder_);
        int count = flags.get(mode);
        if (count == 1) flags.remove(mode);
        else if (count > 1) flags.put(mode, count - 1);
        else if (!safe) builder_.error("Could not exit inactive '" + mode + "' mode at offset " + builder_.getCurrentOffset());
        return true;
    }


    @Nullable
    private static PsiBuilder.Marker getCurrentMarker(@NotNull PsiBuilder builder_) {
        try {
            for (Field field : builder_.getClass().getDeclaredFields()) {
                if ("MyList".equals(field.getType().getSimpleName())) {
                    field.setAccessible(true);
                    List production = (List)field.get(builder_);
                    return (PsiBuilder.Marker) ContainerUtil.getLastItem(production);
                }
            }
        }
        catch (Exception ignored) {}
        return null;
    }


}
