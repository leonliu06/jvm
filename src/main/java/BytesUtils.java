/**
 * Created by li.liu on 2017/9/22.
 */

/**
 * Bytes数组处理工具
 */
public class BytesUtils {

    public static int bytes2Int(byte[] b, int start, int len){
        int sum = 0;
        int end = start + len;
        for(int i = start; i < end; i++){
            int n = ((int) b[i]) & 0xff;
            n <<= (end - i) * 8;
            sum += n;
        }
        return sum;
    }

    public static byte[] int2Bytes(int value, int len){
        byte[] b = new byte[len];
        for(int i = 0; i < len; i++){
            b[len - i - 1] = (byte) ((value >> i * 8) & 0xff);
        }
        return b;
    }

    public static String bytes2String(byte[] b, int start, int len){
        return new String(b, start, len);
    }

    public static byte[] string2Bytes(String str){
        return str.getBytes();
    }

    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes){
        byte[] newBytes = new byte[originalBytes.length + (replaceBytes.length - len)];
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(originalBytes, offset + len, newBytes, offset + replaceBytes.length, originalBytes.length - offset - replaceBytes.length);
        return newBytes;
    }

}
