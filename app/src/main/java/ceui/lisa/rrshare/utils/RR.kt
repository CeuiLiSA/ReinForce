package `fun`.aragaki.rr

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object RR {

    fun decrypt(url: String, token: String, extraHeader: Map<String, String>): String {
//        if (dlma(url, "http", false, 2, null)) {
//            val subToken = token.substring(2, 18)
//            return aa(url, subToken)
//        }
        val subToken = token.substring(2, 18)
        return aa(url, subToken)
        throw Exception("decrypt failed!")
    }

    //    AESCipher.aesDecryptStri…).token.substring(2, 18))
    fun aa(url: String, subToken: String): String {
        return if (aea(url) || !url.contains("http") && !url.contains("m3u8") && !url.contains("tss=ios")) {
            String(aes(Base64.decode(url, 0), subToken.toByteArray()), Charsets.UTF_8)
        } else url
    }

    fun aea(str: String?): Boolean {
        return str == null || "".equals(str.trim(), true) || "null".equals(str.trim(), true);
    }


    private fun aes(bArr: ByteArray, bArr2: ByteArray, i: Int = 2): ByteArray {
        val secretKeySpec = SecretKeySpec(bArr2, "AES")
        val ivParameterSpec = IvParameterSpec("w9f1[oK8%fwHBsw7".toByteArray(charset("UTF-8")))
        val instance: Cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        instance.init(i, secretKeySpec, ivParameterSpec)
        return instance.doFinal(bArr)
    }
}