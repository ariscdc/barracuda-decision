package com.ariscdc.barracuda.decision.util;

import java.util.Collection;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20151103
 */
public class CollectionUtils {

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection != null && collection.isEmpty();
    }
}
