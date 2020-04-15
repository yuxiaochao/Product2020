package com.huarui.common;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Hashtable;
import java.util.UUID;

/**
 * 生成二维码类
 * @author Administrator
 *
 */
@SuppressWarnings("unused")
public class QRCodeUtil {

    private static final String FORMAT_NAME = "PNG";
    // LOGO宽度
    private static final int WIDTH = 180;
    // LOGO高度
    private static final int HEIGHT = 180;

	private static BufferedImage createImage(String content, String imgPath,
                                             boolean needCompress) throws Exception {
        Hashtable hints = new Hashtable();
        int count = content.trim().length();
	    if(count<=5)hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	    if(count>=6 || count<=14)hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
	    if(count>=15 || count<=35)hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	    if(count>=36 || count<=200)hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入图片
//        QRCodeUtil.insertImage(image, imgPath, needCompress);
        return image;
    }

   
/*    private static void insertImage(BufferedImage source, String imgPath,
            boolean needCompress) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            System.err.println(""+imgPath+"   该文件不存在！");
            return;
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }*/

   /**
    * 生成二维码到指定地址
    * @param content 二维码内容
    * @param imgPath 二维码中间图标地址
    * @param destPath 二维码生成地址
    * @param needCompress 
    * @return 二维码文件名
    * @throws Exception
    */
    public static String encode(String content, String imgPath, String destPath,
                                boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath,needCompress);
        mkdirs(destPath);
        String file = UUID.randomUUID().toString().replaceAll("-", "")+".PNG";
        ImageIO.write(image, FORMAT_NAME, new File(destPath+"/"+file));
        alpha(destPath+"/"+file,destPath+"/"+file);
        return file;
    }

   
    public static void mkdirs(String destPath) {
        File file =new File(destPath);
        //当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

   
    public static void alpha(String image, String destPath){
    	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		   try { 
		    ImageIcon imageIcon = new ImageIcon(image);
		    BufferedImage bufferedImage = new BufferedImage(imageIcon
		      .getIconWidth(), imageIcon.getIconHeight(), 
		      BufferedImage.TYPE_4BYTE_ABGR);
		    Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
		    g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon 
		      .getImageObserver()); 
		    int alpha = 0; 
		    for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage 
		      .getHeight(); j1++) { 
		     for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage 
		       .getWidth(); j2++) { 
		      int rgb = bufferedImage.getRGB(j2, j1); 
		    
		      int R =(rgb & 0xff0000 ) >> 16 ; 
		      int G= (rgb & 0xff00 ) >> 8 ; 
		      int B= (rgb & 0xff ); 
		      if(((255-R)<30) && ((255-G)<30) && ((255-B)<30)){ 
		       rgb = ((alpha + 1) << 24) | (rgb & 0x00ffffff); 
		      } 

		      bufferedImage.setRGB(j2, j1, rgb); 

		     } 
		    } 

		    g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver()); 
//		    String  destName = UUID.randomUUID().toString().replaceAll("-", "")+".PNG";
		    ImageIO.write(bufferedImage, "PNG", new File(destPath));
		   } catch (Exception e) {
		   }
    	
    }
    
   
//    public static void main(String[] args) {
//    	 try {
//			encode("网络大学","","C:/Users/Administrator/Desktop",false);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
   
}