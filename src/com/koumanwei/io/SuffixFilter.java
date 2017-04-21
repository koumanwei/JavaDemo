package com.koumanwei.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 2017-04-21 下午3:08
 *
 * @author koumanwei
 * @version 1.0
 */
public class SuffixFilter implements FilenameFilter {

    private String suffix;

    public SuffixFilter(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }
}
