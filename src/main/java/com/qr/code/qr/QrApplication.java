package com.qr.code.qr;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class QrApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrApplication.class, args);


        try {
            QRCodeGenerator.generateQRCodeImage("My eloquent QR image", 350, 350, QRCodeGenerator.QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
	}

}

@Controller
class MyClass {

    @Value("${qr.code.image.path}")
    String qrCodeImage;


    @GetMapping("/qr")
    public ModelAndView getQr() {
        ModelAndView modelAndView = new ModelAndView();
        String decodedText = null;
        try {
            File file = new File(qrCodeImage);
            decodedText = QRCodeReader.decodeQRCode(file);
            if(decodedText == null) {
                System.out.println("No QR Code found in the image");
            } else {
                System.out.println("Decoded text = " + decodedText);
            }
        } catch (IOException e) {
            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
        }
        modelAndView.addObject("decodedText", decodedText);
        modelAndView.setViewName("qr");
        return modelAndView;
    }

}