package com.shape.idea.completion;

import com.android.tools.idea.rendering.AppResourceRepository;
import com.android.tools.idea.rendering.DynamicResourceValueItem;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.augment.PsiAugmentProvider;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.util.ProcessingContext;
import com.intellij.util.containers.*;
import com.intellij.util.indexing.FileBasedIndex;
import com.shape.dictionary.AndroidDictionary;
import com.shape.idea.psi.ShapeTypes;
import com.shape.idea.psi.ShapeViewName;
import org.jetbrains.android.AndroidIdIndex;
import org.jetbrains.android.augment.ResourceTypeClassBase;
import org.jetbrains.android.dom.AndroidDomElementDescriptorProvider;
import org.jetbrains.android.dom.converters.ResourceReferenceConverter;
import org.jetbrains.android.dom.layout.AndroidLayoutUtil;
import org.jetbrains.android.facet.AndroidFacet;
import org.jetbrains.android.facet.SimpleClassMapConstructor;
import org.jetbrains.android.resourceManagers.ResourceManager;
import org.jetbrains.android.util.AndroidUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.*;
import java.util.HashMap;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ViewNameCompleter extends CompletionProvider<CompletionParameters> {

    static PsiElementPattern.Capture<PsiElement> pattern() {
        return PlatformPatterns.psiElement()
                .withElementType(ShapeTypes.IDENTIFIER)
                .withSuperParent(3, ShapeViewName.class);
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters completionParameters,
                                  ProcessingContext processingContext,
                                  @NotNull CompletionResultSet resultSet) {

        PsiElement position = completionParameters.getPosition();
        AndroidFacet facet = AndroidFacet.getInstance(position);
        if (facet == null) {
            return;
        }

        final Map<String, PsiClass> classMap = facet.getClassMap(
                AndroidUtils.VIEW_CLASS_NAME, SimpleClassMapConstructor.getInstance());

        for (String rootTag : AndroidLayoutUtil.getPossibleRoots(facet)) {
            final PsiClass aClass = classMap.get(rootTag);
            LookupElementBuilder builder = aClass != null
                    ? LookupElementBuilder.create(aClass, AndroidDictionary.shapeClassName(rootTag))
                    : LookupElementBuilder.create(AndroidDictionary.shapeClassName(rootTag));
            final Icon icon = AndroidDomElementDescriptorProvider.getIconForViewTag(rootTag);

            if (icon != null) {
                builder = builder.withIcon(icon);
            }
            resultSet.addElement(builder);
        }

//        Project myProject = facet.getModule().getProject();
//        final List<XmlAttributeValue> declarations = new ArrayList<>();
//        final Collection<VirtualFile> files =
//                FileBasedIndex.getInstance().getContainingFiles(AndroidIdIndex.INDEX_ID, "+hello", GlobalSearchScope.allScope(myProject));
//        final Set<VirtualFile> fileSet = new com.intellij.util.containers.HashSet<VirtualFile>(files);
//        final PsiManager psiManager = PsiManager.getInstance(myProject);
//
//        System.err.println(files.size());

//        ResourceManager manager = facet.getResourceManager(null);
//        for (VirtualFile subdir : manager.getResourceSubdirsToSearchIds()) {
//            for (VirtualFile file : subdir.getChildren()) {
//                if (fileSet.contains(file)) {
//                    final PsiFile psiFile = psiManager.findFile(file);
//                    System.err.println(file.getPath());
//                }
//            }
//        }

//        final GlobalSearchScope scope = GlobalSearchScope.allScope(myProject);
//        final FileBasedIndex index = FileBasedIndex.getInstance();
//
//        index.processValues(AndroidIdIndex.INDEX_ID, AndroidIdIndex.MARKER, null, new FileBasedIndex.ValueProcessor<Set<String>>() {
//            @Override
//            public boolean process(VirtualFile file, Set<String> value) {
//                System.err.println(file.getPath());
//                System.err.println(value.toString());
//                return true;
//            }
//        }, scope);
    }
}
