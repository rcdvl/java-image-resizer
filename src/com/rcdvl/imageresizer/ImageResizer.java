package com.rcdvl.imageresizer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageResizer {

	private ImageResizer() {}
	
	public static void resizeRecursively(String inputDir, double ratio) throws IOException {
		File[] imagesWithinDir = FileUtils.getImagesWithinDir(inputDir);
		File outputDir = new File(inputDir, "resized-r" + ratio);
		
		if (!outputDir.exists()) {
			outputDir.mkdir();
		}
		
		for (File imageFile : imagesWithinDir) {
			BufferedImage bufImg = ImageIO.read(imageFile);
			BufferedImage resizedImage = resizeImage(bufImg, (int) (bufImg.getWidth() * ratio), (int) (bufImg.getHeight() * ratio));
			ImageIO.write(resizedImage, FileUtils.getFileExtension(imageFile.getName()), new File(outputDir.getAbsolutePath() + File.separator + imageFile.getName()));
		}
	}
	
	public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
		int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
	 
		return resizedImage;
	}
}
