package com.shape.ast.attributes;

import com.shape.error.SyntaxError;

/**
 * Copyright (C) 2015 Therne. All rights are reserved.
 *
 * @author Vista
 */
public class ResourceAttribute extends Attribute {

    /**
     * Resource types
     */
    private static final String[] RESOURCE_TYPES = new String[] {
        "anim", "animator", "bool", "color", "drawable", "dimen", "id", "integer",
        "layout", "menu", "string", "style"
    };

    protected String resourceType, resourceName;
    protected String resourcePackage;

    public ResourceAttribute(String key, String value) {
        super(key, value);
    }

    public ResourceAttribute(String key, String resourceType, String resourceName) throws SyntaxError {
        super(key, resourceType + "/" + resourceName);

        this.resourceName = resourceName;
        this.resourceType = resourceType;

        // check package suffix(:) (ex: @android:color/black)
        int suffixIndex = resourceType.indexOf(':');
        if (suffixIndex != -1) {
            this.resourcePackage = resourceType.substring(0, suffixIndex);
            this.resourceType = resourceType.substring(suffixIndex+1, resourceType.length());
        }

        // unknown resource type?
        for (String type : RESOURCE_TYPES) {
            if (type.equals(resourceType)) return;
        }

        // TODO : throw SyntaxError if no token matches
//        throw new SyntaxError("Unknown resource type : " + resourceType);
    }
}
