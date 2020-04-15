package com.huarui.common.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImgCompress {
    private Image img;
    private int width;
    private int height;
    public static InputStream ImgCompressImg(InputStream inputStream) throws IOException {
        ImgCompress imgCom = new ImgCompress(inputStream);
        return imgCom.resizeFix(400, 400);
    }
    /**
     * 构造函数
     */
    public ImgCompress(InputStream inputStream) throws IOException {
        img = ImageIO.read(inputStream);      // 构造Image对象
        width = img.getWidth(null);    // 得到源图宽
        height = img.getHeight(null);  // 得到源图长
    }
    /**
     * 按照宽度还是高度进行压缩
     * @param w int 最大宽度
     * @param h int 最大高度
     */
    public InputStream resizeFix(int w, int h) throws IOException {
        InputStream fis = null ;
        if (width / height > w / h) {
            fis = resizeByWidth(w);
        } else {
            fis = resizeByHeight(h);
        }
        return fis;
    }
    /**
     * 以宽度为基准，等比例放缩图片
     * @param w int 新宽度
     */
    public InputStream resizeByWidth(int w) throws IOException {
        int h = (int) (height * w / width);
        return  resize(w, h);
    }
    /**
     * 以高度为基准，等比例缩放图片
     * @param h int 新高度
     */
    public InputStream resizeByHeight(int h) throws IOException {
        int w = (int) (width * h / height);
        return resize(w, h);
    }
    /**
     * 强制压缩/放大图片到固定的大小
     * @param w int 新宽度
     * @param h int 新高度
     */
    public InputStream resize(int w, int h) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB );
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        return is;
    }
}
