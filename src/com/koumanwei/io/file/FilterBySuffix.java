package com.koumanwei.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件名过滤器 返回用户指定类型的文件
 * 
 * @author koumanwei
 *
 */
public class FilterBySuffix implements FilenameFilter {
	private String suffix;

	public FilterBySuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".java");
	}
}
