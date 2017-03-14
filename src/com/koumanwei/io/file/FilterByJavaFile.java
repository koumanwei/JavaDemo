package com.koumanwei.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件名过滤器 返回.java文件
 * 
 * @author koumanwei
 *
 */
public class FilterByJavaFile implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".java");
	}
}
