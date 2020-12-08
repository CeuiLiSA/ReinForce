package `fun`.aragaki.rr

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object RR {

    fun decrypt(url: String, token: String, extraHeader: Map<String, String>) =
        check(url, token.substring(2, 18))

    private fun check(url: String, subToken: String): String {
        return if (empty(url) || !url.contains("http") && !url.contains("m3u8") && !url.contains("tss=ios"))
            String(aes(Base64.decode(url, 0), subToken.toByteArray()), Charsets.UTF_8)
        else url
    }

    private fun empty(str: String) = str.isEmpty() || str == "null"

    private fun aes(bArr: ByteArray, bArr2: ByteArray, i: Int = 2) =
        Cipher.getInstance("AES/CBC/PKCS5Padding").apply {
            init(
                i, SecretKeySpec(bArr2, "AES"),
                IvParameterSpec("w9f1[oK8%fwHBsw7".toByteArray(charset("UTF-8")))
            )
        }.doFinal(bArr)
}