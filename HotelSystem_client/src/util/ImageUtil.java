package util;

import java.io.File;

import javafx.stage.FileChooser;

public class ImageUtil {

	public static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("View Pictures");
		//����file chooser��Ĭ�ϴ�·�� ��user.home�� 
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		//�����ļ���ʽ
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
	}
}
