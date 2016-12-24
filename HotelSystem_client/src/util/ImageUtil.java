package util;

import java.io.File;

import javafx.stage.FileChooser;

public class ImageUtil {

	public static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("View Pictures");
		//设置file chooser的默认打开路径 “user.home” 
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		//设置文件格式
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
	}
}
