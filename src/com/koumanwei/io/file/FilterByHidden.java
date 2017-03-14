package com.koumanwei.io.file;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件过滤器 返回用户指定类型的文件
 * 
 * @author koumanwei
 *
 */
public class FilterByHidden implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		return pathname.isHidden();
	}

}
