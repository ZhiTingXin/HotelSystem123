package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImageUtil {

	private static Stage stage;
	private static FileChooser fileChooser = new FileChooser();
	private static String path = "";
	
	public static String setImagePath(ImageView image) {
		configureFileChooser(fileChooser);
		File file = fileChooser.showOpenDialog(stage);
		String imgName = "src/Img/"+file.getName();
		path = file.getAbsolutePath();
	
		Image newImage = new Image("file:" + path, 200, 200, false, false);
		try {
			File file1 = new File(imgName);
			ImageIO.write(SwingFXUtils.fromFXImage(newImage, null), "jpg", file1);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		image.setImage(newImage);
		return imgName;
	}

	public static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("View Pictures");
		// 设置file chooser的默认打开路径 “user.home”
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		// 设置文件格式
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
	}
	public static Image setImage(String path) {
		File file = new File(path);
		Image image = null;
		try {
			InputStream stream = new FileInputStream(file);
			image = new Image(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return image;
	}

}
