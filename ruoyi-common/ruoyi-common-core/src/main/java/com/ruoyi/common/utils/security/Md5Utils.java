package com.ruoyi.common.utils.security;

import java.security.MessageDigest;
import java.security.DigestInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;

/**
 * Md5加密方法
 * 
 * @author ruoyi
 */
public class Md5Utils
{
    private static final Logger log = LoggerFactory.getLogger(Md5Utils.class);

    private static byte[] md5(String s)
    {
        MessageDigest algorithm;
        try
        {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        }
        catch (Exception e)
        {
            log.error("MD5 Error...", e);
        }
        return null;
    }

    private static final String toHex(byte hash[])
    {
        if (hash == null)
        {
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++)
        {
            if ((hash[i] & 0xff) < 0x10)
            {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    private static byte[] fileMD5(String inputFile, int _bufferSize)
    {
        // 缓冲区大小
        int bufferSize = _bufferSize;

        FileInputStream fileInputStream = null;
        DigestInputStream digestInputStream = null;

        try
        {
            // 拿到一个MD5转换器 同样这里可以换成SHA1
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            // 使用DigestInputStream
            fileInputStream = new FileInputStream(inputFile);
            digestInputStream = new DigestInputStream(fileInputStream,messageDigest);

            // read的过程中进行MD5处理，直到读完文件
            byte[] buffer = new byte[bufferSize];

            while (digestInputStream.read(buffer) > 0);
            // 获取最终的MessageDigest
            messageDigest= digestInputStream.getMessageDigest();

            // 拿到结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();

            return resultByteArray;
        }
        catch (Exception e)
        {
            log.error("File MD5 Error...", e);
            return null;
        }
        // 释放资源
        finally {
            try
            {
                digestInputStream.close();
            }
            catch (Exception e) { }

            try {
                fileInputStream.close();

            }
            catch (Exception e) { }
        }
    }

    //  字符串MD5
    public static String hash(String s)
    {
        try
        {
            return new String(toHex(md5(s)).getBytes("UTF-8"), "UTF-8");
        }
        catch (Exception e)
        {
            log.error("not supported charset...{}", e);
            return s;
        }
    }

    //  文件MD5
    public static String fileHash(String filePath)
    {
        int bufferSize =  256 * 1024;
        try
        {
            return new String(toHex(fileMD5(filePath, bufferSize)).getBytes("UTF-8"), "UTF-8");
        }
        catch (Exception e)
        {
            log.error("not supported charset...{}", e);
            return null;
        }
    }
}
